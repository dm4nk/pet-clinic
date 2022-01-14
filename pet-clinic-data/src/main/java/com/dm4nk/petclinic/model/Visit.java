package com.dm4nk.petclinic.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "visits")

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Visit extends BaseEntity {
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;

    @Column(name = "description")
    @NotEmpty
    String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    Pet pet;

    @Builder
    public Visit(Long id, LocalDate date, String description, Pet pet) {
        super(id);
        this.date = date;
        this.description = description;
        this.pet = pet;
    }
}
