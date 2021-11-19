package com.dm4nk.petclinic.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pet extends BaseEntity {
    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owner owner;

    @Column(name = "birthday")
    LocalDate birthday;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    Set<Visit> visits = new HashSet<>();
}
