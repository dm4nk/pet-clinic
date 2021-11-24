package com.dm4nk.petclinic.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")

@Getter
@Setter
@NoArgsConstructor
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

    @Builder
    public Owner(String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
        super(firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    public static class OwnerBuilder extends PersonBuilder {
        OwnerBuilder() {
            super();
        }
    }
}
