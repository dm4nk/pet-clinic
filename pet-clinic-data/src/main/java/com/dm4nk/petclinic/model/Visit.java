package com.dm4nk.petclinic.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
