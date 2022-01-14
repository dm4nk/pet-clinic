package com.dm4nk.petclinic.controllers;

import com.dm4nk.petclinic.formatters.PetTypeFormatter;
import com.dm4nk.petclinic.model.Owner;
import com.dm4nk.petclinic.model.Pet;
import com.dm4nk.petclinic.model.PetType;
import com.dm4nk.petclinic.services.OwnerService;
import com.dm4nk.petclinic.services.PetService;
import com.dm4nk.petclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @Mock
    PetService petService;

    @Mock
    OwnerService ownerService;

    @Mock
    PetTypeService petTypeService;

    @InjectMocks
    PetController petController;

    MockMvc mockMvc;

    Owner owner;
    Set<PetType> petTypes;
    Pet pet;
    Set<Pet> pets;

    @BeforeEach
    void setUp() {
        pets = new HashSet<>();
        pets.add(Pet.builder().id(1L).name("Ben").owner(owner).build());
        pets.add(Pet.builder().id(2L).name("Thomas").owner(owner).build());

        owner = Owner.builder().id(1L).pets(pets).build();
        pet = Pet.builder().id(2L).build();

        petTypes = new HashSet<>();
        petTypes.add(PetType.builder().id(1L).name("Dog").build());
        petTypes.add(PetType.builder().id(2L).name("Cat").build());

        var conversionService = new DefaultFormattingConversionService();
        conversionService.addFormatterForFieldType(PetType.class, new PetTypeFormatter(petTypeService));
        mockMvc = MockMvcBuilders
                .standaloneSetup(petController)
                .setConversionService(conversionService)
                .build();
    }

    @Test
    void initCreationForm() throws Exception {
        when(ownerService.findByID(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(get("/owners/1/pets/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }

    @Test
    void processCreationForm() throws Exception {
        when(ownerService.findByID(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);
        when(petService.save(any())).thenReturn(pet);

        mockMvc.perform(post("/owners/1/pets/new")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Addison")
                        .param("birthDate", "2019-07-07")
                        .param("petType", "Cat"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(ownerService).save(any());
        verify(petService).save(any());
    }

    @Test
    void processCreationFormValidationFailed() throws Exception {
        when(ownerService.findByID(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(post("/owners/1/pets/new")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "")
                        .param("birthDate", "2019-07-07")
                        .param("petType", "Cat"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("pet"));

        verifyNoInteractions(petService);
    }

    @Test
    void initUpdateOwnerForm() throws Exception {
        when(ownerService.findByID(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);
        when(petService.findByID(anyLong())).thenReturn(pet);

        mockMvc.perform(get("/owners/1/pets/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }

    @Test
    void processUpdateOwnerForm() throws Exception {
        when(ownerService.findByID(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(post("/owners/1/pets/2/edit")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Addison")
                        .param("birthDate", "2019-07-07")
                        .param("petType", "Cat"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(ownerService).save(any());
        verify(petService).save(any());
    }
}