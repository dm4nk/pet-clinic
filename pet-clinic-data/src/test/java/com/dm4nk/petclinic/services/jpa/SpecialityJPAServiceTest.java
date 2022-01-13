package com.dm4nk.petclinic.services.jpa;

import com.dm4nk.petclinic.model.Speciality;
import com.dm4nk.petclinic.repositories.SpecialityRepository;
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
class SpecialityJPAServiceTest {

    @Mock
    SpecialityRepository specialityRepository;

    @InjectMocks
    SpecialityJPAService specialityJPAService;

    Speciality speciality;

    @BeforeEach
    void setUp() {
        speciality = Speciality.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<Speciality> petSpeciality = new HashSet<>();
        petSpeciality.add(speciality);
        when(specialityRepository.findAll()).thenReturn(petSpeciality);

        Set<Speciality> actualSet = specialityJPAService.findAll();

        assertArrayEquals(petSpeciality.toArray(), actualSet.toArray());

        verify(specialityRepository, times(1)).findAll();
    }

    @Test
    void findByID() {
        when(specialityRepository.findById(1L)).thenReturn(Optional.ofNullable(speciality));

        Speciality returnedSpeciality = specialityJPAService.findByID(1L);
        Speciality nullPetType = specialityJPAService.findByID(2L);

        assertEquals(speciality.getId(), returnedSpeciality.getId());
        assertNull(nullPetType);

        verify(specialityRepository, times(2)).findById(anyLong());
    }

    @Test
    void save() {
        when(specialityRepository.save(any())).thenReturn(speciality);

        Speciality savedSpeciality = specialityJPAService.save(speciality);

        assertEquals(speciality.getId(), savedSpeciality.getId());

        verify(specialityRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        specialityJPAService.delete(any());

        verify(specialityRepository, times(1)).delete(any());
    }

    @Test
    void deleteByID() {
        specialityJPAService.deleteByID(anyLong());

        verify(specialityRepository, times(1)).deleteById(anyLong());
    }
}