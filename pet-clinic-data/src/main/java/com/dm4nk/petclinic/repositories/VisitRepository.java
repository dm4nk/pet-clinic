package com.dm4nk.petclinic.repositories;

import com.dm4nk.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface VisitRepository extends CrudRepository<Visit, Long> {
    Collection<Visit> findAll();
}
