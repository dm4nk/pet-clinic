package com.dm4nk.petclinic.services.jpa;

import com.dm4nk.petclinic.model.Pet;
import com.dm4nk.petclinic.repositories.PetRepository;
import com.dm4nk.petclinic.services.PetService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PetJPAService implements PetService {

    PetRepository petRepository;

    @Override
    public Set<Pet> findAll() {
        return new HashSet<>(petRepository.findAll());
    }

    @Override
    public Pet findByID(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        petRepository.deleteById(id);
    }
}
