package be.jcideinze

import be.jcideinze.endpoint.AuthenticationEndpoint
import be.jcideinze.endpoint.Endpoint
import be.jcideinze.endpoint.EventEndpoint
import be.jcideinze.endpoint.ParticipantEndpoint
import be.jcideinze.endpoint.View
import be.jcideinze.filter.ResponseFilter
import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.impl.crypto.MacProvider
import org.eclipse.jetty.server.Authentication
import spark.Spark

import java.security.Key

class App {

    static Key key = MacProvider.generateKey();

    static void main(String[] args) {

        Spark.staticFileLocation "/public" // Static files

        List<Endpoint> endpoints = [EventEndpoint.instance, ParticipantEndpoint.instance, AuthenticationEndpoint.instance]
        endpoints.forEach({ e -> e.routes(); e.handlers() })
        new View().routes()
        ResponseFilter.instance.filter()


    }
}
