package com.dm4nk.petclinic.services.jpa;

import com.dm4nk.petclinic.model.PetType;
import com.dm4nk.petclinic.repositories.PetTypeRepository;
import com.dm4nk.petclinic.services.PetTypeService;
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
public class PetTypeJPAService implements PetTypeService {

    PetTypeRepository petTypeRepository;

    @Override
    public Set<PetType> findAll() {
        return new HashSet<>(petTypeRepository.findAll());
    }

    @Override
    public PetType findByID(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        petTypeRepository.deleteById(id);
    }
}
