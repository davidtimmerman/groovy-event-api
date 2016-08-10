package be.jcideinze.endpoint

import be.jcideinze.exceptions.RegistrationNotFoundException
import be.jcideinze.exceptions.UserNotFoundException
import be.jcideinze.model.db.Registration
import be.jcideinze.model.User
import be.jcideinze.service.AuthenticationService
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
        get("$path/confirm/:uuid", { req, res ->
            Registration r = RegistrationService.instance.confirmRegistration(req.params('uuid'))
            //todo call authentication business and create a jwt - set a cookie and add the jwt
            def user = UserService.instance.read(r.participantId)
            def token = AuthenticationService.instance.createJwt(user.orElseThrow({-> new UserNotFoundException()}).email)
            res.cookie("jwt", token, 36000);
            res.redirect("/reservaties")
        })

        put("$path/:id/register", { req, res ->
            be.jcideinze.model.api.Registration r = req.body().mapTo(be.jcideinze.model.api.Registration)
            assert r.isValid()
            final User u = UserService.instance.create(new User(r.email, r.firstName, r.lastName))
            final UUID uuid = RegistrationService.instance.registerInCache(u, Long.parseLong(req.params('id')), r.vat)
            RegistrationService.instance.requestConfirmation(uuid, u.email)


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

        exception(RegistrationNotFoundException.class, { exception, req, res ->
            exception.printStackTrace()
            def head = exception.stackTrace.head()
            res.status(404);
            res.body("""
            {
                \"exception\":\"$exception.message\",
                \"stackTrace\":\"$head\",
            }
            """);
        });
    }

}