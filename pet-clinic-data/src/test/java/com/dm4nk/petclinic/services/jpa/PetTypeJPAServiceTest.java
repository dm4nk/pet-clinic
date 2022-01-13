package com.dm4nk.petclinic.services.jpa;

import com.dm4nk.petclinic.model.PetType;
import com.dm4nk.petclinic.repositories.PetTypeRepository;
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
class PetTypeJPAServiceTest {

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    PetTypeJPAService petTypeJPAService;

    PetType petType;

    @BeforeEach
    void setUp() {
        petType = PetType.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<PetType> petTypeSet = new HashSet<>();
        petTypeSet.add(petType);
        when(petTypeRepository.findAll()).thenReturn(petTypeSet);

        Set<PetType> actualSet = petTypeJPAService.findAll();

        assertArrayEquals(petTypeSet.toArray(), actualSet.toArray());

        verify(petTypeRepository, times(1)).findAll();
    }

    @Test
    void findByID() {
        when(petTypeRepository.findById(1L)).thenReturn(Optional.ofNullable(petType));

        PetType returnedPetType = petTypeJPAService.findByID(1L);
        PetType nullPetType = petTypeJPAService.findByID(2L);

        assertEquals(petType.getId(), returnedPetType.getId());
        assertNull(nullPetType);

        verify(petTypeRepository, times(2)).findById(anyLong());
    }

    @Test
    void save() {
        when(petTypeRepository.save(any())).thenReturn(petType);

        PetType savedPetType = petTypeJPAService.save(petType);

        assertEquals(petType.getId(), savedPetType.getId());

        verify(petTypeRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        petTypeJPAService.delete(any());

        verify(petTypeRepository, times(1)).delete(any());
    }

    @Test
    void deleteByID() {
        petTypeJPAService.deleteByID(anyLong());

        verify(petTypeRepository, times(1)).deleteById(anyLong());
    }
}