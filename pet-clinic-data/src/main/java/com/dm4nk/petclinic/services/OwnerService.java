package com.dm4nk.petclinic.services;

import com.dm4nk.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
