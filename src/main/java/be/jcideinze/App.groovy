package be.jcideinze

import be.jcideinze.endpoint.Endpoint
import be.jcideinze.endpoint.EventEndpoint
import be.jcideinze.endpoint.ParticipantEndpoint

class App {
    static void main(String[] args) {
        List<Endpoint> endpoints = [new EventEndpoint(), new ParticipantEndpoint()]
        endpoints.forEach({ e -> e.routes(); e.handlers() })
    }
}
