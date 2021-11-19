package com.dm4nk.petclinic.repositories;

import com.dm4nk.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
