package com.kn4md.petclinic.services;

import com.kn4md.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName();

    Owner findByID(Long id);

    Owner Save(Owner owner);

    Set<Owner> findAll();
}
