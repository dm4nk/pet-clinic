package com.dm4nk.petclinic.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PetType extends BaseEntity {
    @Column(name = "name")
    String name;

    @Builder
    public PetType(Long id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
