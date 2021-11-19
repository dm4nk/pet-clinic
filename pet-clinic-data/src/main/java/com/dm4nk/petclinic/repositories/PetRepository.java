package com.dm4nk.petclinic.repositories;

import com.dm4nk.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
