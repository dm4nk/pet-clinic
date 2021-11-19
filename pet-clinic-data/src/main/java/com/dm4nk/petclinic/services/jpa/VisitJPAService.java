package com.dm4nk.petclinic.services.jpa;

import com.dm4nk.petclinic.model.Visit;
import com.dm4nk.petclinic.repositories.VisitRepository;
import com.dm4nk.petclinic.services.VisitService;
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
public class VisitJPAService implements VisitService {

    VisitRepository visitRepository;

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visitSet = new HashSet<>();
        visitRepository.findAll().forEach(visitSet::add);
        return visitSet;
    }

    @Override
    public Visit findByID(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.save(object);
    }

    @Override
    public void deleteByID(Long id) {
        visitRepository.deleteById(id);
    }
}
