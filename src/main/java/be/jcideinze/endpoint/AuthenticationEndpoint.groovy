package be.jcideinze.endpoint

import be.jcideinze.service.AuthenticationService

import static spark.Spark.before
import static spark.Spark.get

@Singleton
class AuthenticationEndpoint implements Endpoint {

    private def path = "/auth"

    @Override
    void routes() {

        before("/event/*", { req, res ->
            boolean authenticated;
            AuthenticationService.instance.verifyJwt(req.cookie("jwt"))
            if (!authenticated) {
                halt(401, "You are not welcome here");
            }
        });

        get("$path/identify", { req, res ->
            final String email = req.queryParams("email")
            def jwt = AuthenticationService.instance.identify(email)
            //email is sent
            //res.cookie("jwt", jwt, 36000); //set cookie to secure
            jwt
        })

        get("$path/login/:uuid", { req, res ->
            final String jwt = req.queryParams("jwt")
            final String uuid = req.params("uuid")
            def token = AuthenticationService.instance.login(uuid, jwt)
            res.cookie("jwt", token, 36000); //set cookie to secure
            res.redirect("/index")
        })


    }

    @Override
    void handlers() {

    }
}
