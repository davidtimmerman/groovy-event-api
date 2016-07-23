package be.jcideinze.endpoint

import be.jcideinze.model.Registration
import be.jcideinze.model.User
import be.jcideinze.service.RegistrationService
import be.jcideinze.service.UserService
import com.fasterxml.jackson.databind.ObjectMapper

import static spark.Spark.*

@Singleton
class EventEndpoint implements Endpoint {

    private def path = "/event"
    private def mapper = new ObjectMapper()


    @Override
    void routes() {


        String.metaClass.mapTo = { T ->
            mapper.readValue(delegate, T)
        }
        get("$path/:id/registration/:registration", { req, res ->
            req.params('id')
        })

        put("$path/:id/register", { req, res ->
            Registration r = req.body().mapTo(Registration)
            assert r.isValid()
            UserService.instance.create(new User(r.email, r.firstName, r.lastName))
            //create new user + send email with logon
            //put registration in cache

            //RegistrationService.instance.register(new Integer(req.params('id')), r)
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