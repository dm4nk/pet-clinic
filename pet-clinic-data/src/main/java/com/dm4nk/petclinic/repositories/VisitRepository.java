package com.dm4nk.petclinic.repositories;

import com.dm4nk.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
