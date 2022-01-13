package com.dm4nk.petclinic.repositories;

import com.dm4nk.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
    Collection<Speciality> findAll();
}
