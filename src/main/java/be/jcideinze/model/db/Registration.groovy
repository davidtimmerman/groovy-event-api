package be.jcideinze.model.db

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.sql.Timestamp

@ToString
@EqualsAndHashCode
class Registration {
    Long id
    Long eventId
    Long subscriberId
    Long participantId
    String vat
    String hash
    Timestamp creationDate

    Registration() {
    }

    Registration(Long eventId, Long subscriberId, Long participantId, String vat) {
        this.eventId = eventId
        this.subscriberId = subscriberId
        this.participantId = participantId
        this.vat = vat
    }

    Registration(Long id, Long eventId, Long subscriberId, Long participantId, String vat, String hash, Timestamp creationDate) {
        this.id = id
        this.eventId = eventId
        this.subscriberId = subscriberId
        this.participantId = participantId
        this.vat = vat
        this.hash = hash
        this.creationDate = creationDate
    }

    List toList() {
        this.class.declaredFields.findAll { !it.synthetic }.collect {
            this."$it.name"
        } - null
    }

    Boolean isValid() {
        return firstName && lastName && email && vat
    }
}
