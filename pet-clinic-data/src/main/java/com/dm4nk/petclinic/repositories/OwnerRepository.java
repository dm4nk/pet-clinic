package com.dm4nk.petclinic.repositories;

import com.dm4nk.petclinic.model.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);


    @Query("select o from Owner o where o.lastName like %?1%")
    List<Owner> findAllByLastNameLike(String lastName);
}
