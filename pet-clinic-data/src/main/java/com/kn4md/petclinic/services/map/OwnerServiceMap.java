package com.kn4md.petclinic.services.map;

import com.kn4md.petclinic.model.Owner;
import com.kn4md.petclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends MapService<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }
}
