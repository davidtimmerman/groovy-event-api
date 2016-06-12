package be.jcideinze

import be.jcideinze.endpoint.Endpoint
import be.jcideinze.endpoint.EventEndpoint
import be.jcideinze.endpoint.ParticipantEndpoint
import be.jcideinze.filter.ResponseFilter
import com.fasterxml.jackson.databind.ObjectMapper

class App {
    static void main(String[] args) {
        private def mapper = new ObjectMapper()
        String.metaClass.mapTo = { T ->
            mapper.readValue(delegate, T)
        }

        List<Endpoint> endpoints = [EventEndpoint.instance]
        endpoints.forEach({ e -> e.routes(); e.handlers() })

        ResponseFilter.instance.filter()


    }
}
