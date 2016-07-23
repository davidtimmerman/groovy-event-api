package be.jcideinze.service

import be.jcideinze.Datasource
import be.jcideinze.model.Registration
import be.jcideinze.model.User
import groovy.sql.Sql

import java.sql.Timestamp

@Singleton
class UserService {

    Sql sql = new Sql(Datasource.instance.get())

    User create(User user) {
        def params = user.toList()
        def result = sql.executeInsert 'insert into USERS (email, first_name, last_name) values (?, ?, ?)', params
        result[0] as User
    }
}
