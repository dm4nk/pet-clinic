package com.kn4md.petclinic.services;

import com.kn4md.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByID(Long id);

    Vet Save(Vet vet);

    Set<Vet> findAll();
}
