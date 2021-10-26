package com.kn4md.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
}
