package com.dm4nk.petclinic.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialities")

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Speciality extends BaseEntity {
    @Column(name = "description")
    String description;

    @Builder
    public Speciality(Long id, String description) {
        super(id);
        this.description = description;
    }
}
