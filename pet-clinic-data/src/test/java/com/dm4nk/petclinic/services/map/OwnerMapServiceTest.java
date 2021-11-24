package com.dm4nk.petclinic.services.map;

import com.dm4nk.petclinic.model.Owner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@FieldDefaults(level = AccessLevel.PRIVATE)
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 3L;
    final String ownerLastName = "Ivanov";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(ownerLastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findByID() {
        Owner owner = ownerMapService.findByID(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void delete() {

        ownerMapService.delete(ownerMapService.findByID(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner = Owner.builder().id(id).build();

        Owner savedOwner = ownerMapService.save(owner);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = Owner.builder().build();
        Owner savedOwner = ownerMapService.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteByID() {
        ownerMapService.deleteByID(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(ownerLastName);

        assertNotNull(owner);

        assertEquals(ownerLastName, owner.getLastName());
    }
}