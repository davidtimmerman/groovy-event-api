package be.jcideinze.repository

import be.jcideinze.Datasource
import be.jcideinze.model.User
import groovy.sql.Sql

@Singleton
class UserRepository {

    Sql sql = new Sql(Datasource.instance.get())

    User create(User user) {
        def params = user.toList()
        def result = sql.executeInsert 'insert into USERS (email, first_name, last_name) values (?, ?, ?)', params
        result[0] as User
    }

    Optional<User> read(Long id) {
        def params = [id]
        def rows = sql.rows 'select * from USERS where id = ?', params
        if(rows.size() == 0) {
            return Optional.empty()
        } else return Optional.of(rows[0].values() as User)
    }

    Optional<User> find(String email) {
        def params = [email]
        def rows = sql.rows 'select * from USERS where email = ?', params
        if(rows.size() == 0) {
            return Optional.empty()
        } else return Optional.of(rows[0].values() as User)
    }
}
