package be.jcideinze.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Registration {
    Integer id
    String firstName
    String lastName
    String email
    String vat

    List toList() {
        this.class.declaredFields.findAll { !it.synthetic }.collect {
            this."$it.name"
        }
    }

    Boolean isValid() {
        return firstName && lastName && email && vat
    }
}
