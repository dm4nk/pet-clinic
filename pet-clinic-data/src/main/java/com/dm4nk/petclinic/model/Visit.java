package com.dm4nk.petclinic.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Visit extends BaseEntity {
    @Column(name = "date")
    LocalDate date;

    @Column(name = "description")
    String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    Pet pet;
}
