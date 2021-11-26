package com.dm4nk.petclinic.services.jpa;

import com.dm4nk.petclinic.model.Owner;
import com.dm4nk.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerJPAService service;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName("Ivanov").build();
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().lastName("Ivanov").build());
        ownerSet.add(Owner.builder().lastName("Petrov").build());
        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> actualSet = service.findAll();
        assertEquals(ownerSet, actualSet);

        assertNotNull(actualSet);
        verify(ownerRepository).findAll();
    }

    @Test
    void findByID() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));

        Owner actualOwner = service.findByID(1L);

        assertEquals(actualOwner, owner);
        verify(ownerRepository).findById(any());
    }

    @Test
    void findByIDWithoutID() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        Owner actualOwner = service.findByID(1L);

        assertNull(actualOwner);
        verify(ownerRepository).findById(any());
    }

    @Test
    void save() {
        when(ownerRepository.save(owner)).thenReturn(owner);

        Owner actualOwner = service.save(owner);

        assertNotNull(actualOwner);
        verify(ownerRepository).save(owner);
    }

    @Test
    void delete() {
        service.delete(owner);

        verify(ownerRepository).delete(owner);
    }

    @Test
    void deleteByID() {
        Long id = 1L;
        service.deleteByID(id);

        verify(ownerRepository).deleteById(id);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(owner.getLastName())).thenReturn(owner);
        assertEquals(owner, service.findByLastName(owner.getLastName()));

        verify(ownerRepository).findByLastName(owner.getLastName());
    }
}