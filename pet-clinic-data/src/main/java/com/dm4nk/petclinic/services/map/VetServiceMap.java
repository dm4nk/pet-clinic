package com.dm4nk.petclinic.services.map;

import com.dm4nk.petclinic.model.Vet;
import com.dm4nk.petclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends MapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }
}
