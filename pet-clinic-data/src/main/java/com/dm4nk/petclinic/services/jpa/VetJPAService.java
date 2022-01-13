package com.dm4nk.petclinic.services.jpa;

import com.dm4nk.petclinic.model.Vet;
import com.dm4nk.petclinic.repositories.VetRepository;
import com.dm4nk.petclinic.services.VetService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class VetJPAService implements VetService {

    VetRepository vetRepository;

    @Override
    public Set<Vet> findAll() {
        return new HashSet<>(vetRepository.findAll());
    }

    @Override
    public Vet findByID(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        vetRepository.deleteById(id);
    }
}
