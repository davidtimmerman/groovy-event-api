package be.jcideinze.repository

import be.jcideinze.Datasource
import be.jcideinze.model.db.Registration

import groovy.sql.Sql

@Singleton
class RegistrationRepository {

    private final Sql sql = new Sql(Datasource.instance.get())

    Optional<Registration> create(Registration registration) {
        def params = registration.toList() + new Integer(registration.hashCode()).toString()/* + new Timestamp(new Date().getTime())*/
        try {
            def result = sql.executeInsert 'insert into REGISTRATIONS (event_id, subscriber, participant, vat, hash) values (?, ?, ?, ?, ?)', params
            Optional.of(result[0] as Registration)
        } catch (all) {
            return new Optional<Registration>()
        }
    }
}
