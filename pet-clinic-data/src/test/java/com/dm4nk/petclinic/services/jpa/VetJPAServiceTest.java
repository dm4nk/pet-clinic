package com.dm4nk.petclinic.services.jpa;

import com.dm4nk.petclinic.model.Vet;
import com.dm4nk.petclinic.repositories.VetRepository;
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
class VetJPAServiceTest {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetJPAService vetJPAService;

    Vet vet;

    @BeforeEach
    void setUp() {
        vet = Vet.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<Vet> petVet = new HashSet<>();
        petVet.add(vet);
        when(vetRepository.findAll()).thenReturn(petVet);

        Set<Vet> actualSet = vetJPAService.findAll();

        assertArrayEquals(petVet.toArray(), actualSet.toArray());

        verify(vetRepository, times(1)).findAll();
    }

    @Test
    void findByID() {
        when(vetRepository.findById(1L)).thenReturn(Optional.ofNullable(vet));

        Vet returnedVet = vetJPAService.findByID(1L);
        Vet nullPetType = vetJPAService.findByID(2L);

        assertEquals(vet.getId(), returnedVet.getId());
        assertNull(nullPetType);

        verify(vetRepository, times(2)).findById(anyLong());
    }

    @Test
    void save() {
        when(vetRepository.save(any())).thenReturn(vet);

        Vet savedVet = vetJPAService.save(vet);

        assertEquals(vet.getId(), savedVet.getId());

        verify(vetRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        vetJPAService.delete(any());

        verify(vetRepository, times(1)).delete(any());
    }

    @Test
    void deleteByID() {
        vetJPAService.deleteByID(anyLong());

        verify(vetRepository, times(1)).deleteById(anyLong());
    }
}