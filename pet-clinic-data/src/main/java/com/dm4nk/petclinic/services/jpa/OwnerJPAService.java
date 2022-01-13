package com.dm4nk.petclinic.services.jpa;

import com.dm4nk.petclinic.model.Owner;
import com.dm4nk.petclinic.repositories.OwnerRepository;
import com.dm4nk.petclinic.services.OwnerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("jpa")

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OwnerJPAService implements OwnerService {

    OwnerRepository ownerRepository;

    @Override
    public Set<Owner> findAll() {
        return new HashSet<>(ownerRepository.findAll());
    }

    @Override
    public Owner findByID(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }
}
