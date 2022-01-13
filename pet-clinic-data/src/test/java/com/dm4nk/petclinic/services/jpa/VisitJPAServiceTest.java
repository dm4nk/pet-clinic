package com.dm4nk.petclinic.services.jpa;

import com.dm4nk.petclinic.model.Visit;
import com.dm4nk.petclinic.repositories.VisitRepository;
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
class VisitJPAServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitJPAService visitJPAService;

    Visit visit;

    @BeforeEach
    void setUp() {
        visit = Visit.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<Visit> petSpeciality = new HashSet<>();
        petSpeciality.add(visit);
        when(visitRepository.findAll()).thenReturn(petSpeciality);

        Set<Visit> actualSet = visitJPAService.findAll();

        assertArrayEquals(petSpeciality.toArray(), actualSet.toArray());

        verify(visitRepository, times(1)).findAll();
    }

    @Test
    void findByID() {
        when(visitRepository.findById(1L)).thenReturn(Optional.ofNullable(visit));

        Visit returnedVisit = visitJPAService.findByID(1L);
        Visit nullPetType = visitJPAService.findByID(2L);

        assertEquals(visit.getId(), returnedVisit.getId());
        assertNull(nullPetType);

        verify(visitRepository, times(2)).findById(anyLong());
    }

    @Test
    void save() {
        when(visitRepository.save(any())).thenReturn(visit);

        Visit savedVisit = visitJPAService.save(visit);

        assertEquals(visit.getId(), savedVisit.getId());

        verify(visitRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        visitJPAService.delete(any());

        verify(visitRepository, times(1)).delete(any());
    }

    @Test
    void deleteByID() {
        visitJPAService.deleteByID(anyLong());

        verify(visitRepository, times(1)).deleteById(anyLong());
    }
}