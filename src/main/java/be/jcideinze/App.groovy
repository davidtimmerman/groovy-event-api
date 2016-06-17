package be.jcideinze

import be.jcideinze.endpoint.AuthenticationEndpoint
import be.jcideinze.endpoint.Endpoint
import be.jcideinze.endpoint.EventEndpoint
import be.jcideinze.endpoint.ParticipantEndpoint
import be.jcideinze.endpoint.View
import be.jcideinze.filter.ResponseFilter
import com.fasterxml.jackson.databind.ObjectMapper

import java.security.Key

class App {

    static Key key = MacProvider.generateKey();
    static void main(String[] args) {

        List<Endpoint> endpoints = [EventEndpoint.instance]
        endpoints.forEach({ e -> e.routes(); e.handlers() })
        new View().routes()
        ResponseFilter.instance.filter()


    }
}
