package com.dm4nk.petclinic.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pet extends BaseEntity {
    @Column(name = "name")
    @NotEmpty
    String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owner owner;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    Set<Visit> visits = new HashSet<>();

    @Builder
    public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
        super(id);
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;

        if (visits != null)
            this.visits = visits;
    }
}
