package com.dm4nk.petclinic.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Owner extends Person {
    @Column(name = "address")
    String address;

    @Column(name = "city")
    String city;

    @Column(name = "telephone")
    String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    Set<Pet> pets = new HashSet<>();
}
