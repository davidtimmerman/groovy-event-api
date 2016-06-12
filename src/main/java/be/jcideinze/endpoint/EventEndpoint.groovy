package be.jcideinze.endpoint

import be.jcideinze.model.Registration
import be.jcideinze.service.RegistrationService
import com.fasterxml.jackson.databind.ObjectMapper

import static spark.Spark.exception;
import static spark.Spark.get
import static spark.Spark.halt;
import static spark.Spark.put;

class EventEndpoint implements Endpoint {

    private def path = "/event"
    private def mapper = new ObjectMapper()


    @Override
    void routes() {

        String.metaClass.mapTo = { T ->
            mapper.readValue(delegate, T)
        }

        get("/event/list", { req, res -> "events list" })

        get("$path/:id/registration/:registration", { req, res ->
            req.params('id')
        })

        put("$path/:id/register", { req, res ->
            Registration r = req.body().mapTo(Registration)
            r.id = 1
            assert r.isValid()
            RegistrationService.instance.register(new Integer(req.params('id')), r)
            res.status(200)
        })
    }

    @Override
    void handlers() {

        exception(Exception.class, { exception, req, res ->
            exception.printStackTrace()
            def head = exception.stackTrace.head()
            res.status(500);
            res.body("""
            {
                \"exception\":\"$exception.message\",
                \"stackTrace\":\"$head\",
            }
            """);
        });
    }

}