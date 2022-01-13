package com.dm4nk.petclinic.services.jpa;

import com.dm4nk.petclinic.model.Pet;
import com.dm4nk.petclinic.repositories.PetRepository;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetJPAServiceTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetJPAService petJPAService;

    Pet pet;

    @BeforeEach
    void setUp() {
        pet = Pet.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<Pet> petSet = new HashSet<>();
        petSet.add(pet);
        when(petRepository.findAll()).thenReturn(petSet);

        Set<Pet> actualSet = petJPAService.findAll();

        assertArrayEquals(petSet.toArray(), actualSet.toArray());

        verify(petRepository, times(1)).findAll();
    }

    @Test
    void findByID() {
        when(petRepository.findById(1L)).thenReturn(Optional.ofNullable(pet));

        Pet returnedPet = petJPAService.findByID(1L);
        Pet nullPet = petJPAService.findByID(2L);

        assertEquals(pet.getId(), returnedPet.getId());
        assertNull(nullPet);

        verify(petRepository, times(2)).findById(anyLong());
    }

    @Test
    void save() {
        when(petRepository.save(any())).thenReturn(pet);

        Pet savedPet = petJPAService.save(pet);

        assertEquals(pet.getId(), savedPet.getId());

        verify(petRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        petJPAService.delete(any());

        verify(petRepository, times(1)).delete(any());
    }

    @Test
    void deleteByID() {
        petJPAService.deleteByID(anyLong());

        verify(petRepository, times(1)).deleteById(anyLong());
    }
}