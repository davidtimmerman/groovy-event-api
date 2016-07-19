package be.jcideinze.endpoint

import be.jcideinze.Datasource
import be.jcideinze.model.Registration

import java.sql.Connection
import java.sql.ResultSet

import static spark.Spark.*

@Singleton
public class ParticipantEndpoint implements Endpoint {

    @Override
    public void routes() {

        put("/participant", { req, res ->
            Connection connection = Datasource.instance.connection()
            assert (req.queryParams("name") != null)
            def name = req.queryParams('name')
            // Insert two rows into the "accounts" table.
            try {
                connection.createStatement().execute "INSERT INTO participants (id, name) VALUES (1, '$name')"
            } catch (Exception e) {
                println e.getMessage()
            }
            connection.close()
            halt(200)
        })

        get("/participant/:id", { req, res ->
            Connection connection = Datasource.instance.connection()
            assert (req.params(':id') != null)
            def id = req.params(':id')
            try {
                ResultSet result = connection.createStatement().executeQuery("SELECT * FROM participants WHERE id = $id")
                result.next()
                def p = new Registration(firstName: result.getString("name"))
                connection.close()
                p
            } catch (Exception e) {
                println e.getMessage()
            }

        })
    }

    @Override
    void handlers() {

    }
}
