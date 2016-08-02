package be.jcideinze.model.api

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Registration {
    String email
    String firstName
    String lastName
    String vat


    Boolean isValid() {
        return firstName && lastName && email
        //TODO regex for email and vat
    }
}
