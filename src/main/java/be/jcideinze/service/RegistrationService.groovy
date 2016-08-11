package be.jcideinze.service

import be.jcideinze.Datasource
import be.jcideinze.exceptions.RegistrationNotFoundException
import be.jcideinze.model.db.Registration
import be.jcideinze.model.User
import be.jcideinze.repository.RegistrationRepository
import groovy.sql.Sql
import org.cache2k.Cache
import org.cache2k.Cache2kBuilder

import java.sql.Timestamp
import java.util.concurrent.TimeUnit

@Singleton
class RegistrationService {

    private final Cache<Long, Registration> cache = new Cache2kBuilder<String, List<Registration>>() {}
            .name("registrations")
            .expireAfterWrite(15, TimeUnit.MINUTES)
            .build()



    UUID registerInCache(User subscriber, Long eventId, String vat) {
        Registration registration = new Registration(eventId,subscriber.id, subscriber.id, vat)
        UUID uuid = UUID.randomUUID()
        cache.put(uuid.toString(), registration)
        uuid
    }

    void requestConfirmation(UUID uuid, String email) {
        final def id = uuid.toString()
        String content = "http://localhost:4567/event/confirm/$id"
        MailGunService.instance.send(email, content)
    }

    /**
     * Confirms the registration in the cache by finding and removing it, and subsequently creating it
     * in the database.
     *
     * @param String uuid unique id used to put the registration in the cache
     * @return Registration the result of the database insert
     */
    Registration confirmRegistration(String uuid) {
        Optional<Registration> registration = findCachedRegistration uuid
        def r = RegistrationRepository.instance.create(registration.orElseThrow({ -> new RegistrationNotFoundException()}))
        r.get()
    }

    /**
     * Get all registrations for user
     *
     * @param Long userId id for which to find the registrations
     * @return Registration the result of the database insert
     */
    List<Registration> findRegistrations(Long userId) {
        RegistrationRepository.instance.read(userId)
    }

    private Optional<Registration> findCachedRegistration(String uuid) {
        Optional.ofNullable(cache.peek(uuid)) //peekAndRemove
    }
}
