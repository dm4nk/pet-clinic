package com.dm4nk.petclinic.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PetType extends BaseEntity {
    @Column(name = "name")
    String name;
}
