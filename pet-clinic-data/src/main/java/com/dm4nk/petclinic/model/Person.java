package com.dm4nk.petclinic.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person extends BaseEntity {

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;
}
