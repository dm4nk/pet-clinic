package com.kn4md.petclinic.services;

import com.kn4md.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName();
}
