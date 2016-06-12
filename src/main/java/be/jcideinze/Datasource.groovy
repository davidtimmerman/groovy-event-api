package be.jcideinze

import com.zaxxer.hikari.HikariDataSource

import javax.sql.DataSource
import java.sql.Connection

@Singleton
class Datasource {

    HikariDataSource hikariDataSource

    private void setupHikari() {
        /*hikariDataSource = new HikariDataSource().with {
            jdbcUrl = "jdbc:postgresql://127.0.0.1:26257/bank?sslmode=disable"
            username = "archer"
        }*/

        hikariDataSource = new HikariDataSource(
                jdbcUrl: "jdbc:postgresql://127.0.0.1:26257/jci?sslmode=disable",
                username: "sterling")
    }

    DataSource get() {
        if (hikariDataSource == null) setupHikari()
        hikariDataSource
    }
}
