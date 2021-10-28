package com.kn4md.petclinic.services;
import com.kn4md.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByID(Long id);

    Pet Save(Pet pet);

    Set<Pet> findAll();
}
