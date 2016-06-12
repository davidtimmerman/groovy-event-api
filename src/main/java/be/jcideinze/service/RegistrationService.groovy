package be.jcideinze.service

import be.jcideinze.Datasource
import be.jcideinze.model.Registration
import groovy.sql.Sql

import java.sql.Timestamp
import java.time.LocalDateTime

@Singleton
class RegistrationService {

    Sql sql = new Sql(Datasource.instance.get())

    Boolean register(Integer eventId, Registration registration) {
        def params = registration.toList() + registration.hashCode() + new Timestamp(new Date().getTime())
        sql.execute 'insert into REGISTRATIONS (id, first_name, last_name, email, vat, hash, insert_date) values (?, ?, ?, ?, ?, ?, ?)', params
    }
}
