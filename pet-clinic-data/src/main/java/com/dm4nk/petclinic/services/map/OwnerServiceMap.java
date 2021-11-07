package com.dm4nk.petclinic.services.map;

import com.dm4nk.petclinic.model.Owner;
import com.dm4nk.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends MapService<Owner, Long> implements OwnerService {

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

    //todo: implement that
    @Override
    public Owner findByLastName() {
        return null;
    }
}
