package com.dm4nk.petclinic.repositories;

import com.dm4nk.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
