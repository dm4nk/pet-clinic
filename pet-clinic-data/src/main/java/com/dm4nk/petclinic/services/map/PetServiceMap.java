package com.dm4nk.petclinic.services.map;

import com.dm4nk.petclinic.model.Pet;
import com.dm4nk.petclinic.services.PetService;

import java.util.Set;

public class PetServiceMap extends MapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }
}
