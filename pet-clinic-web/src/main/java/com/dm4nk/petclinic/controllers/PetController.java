package com.dm4nk.petclinic.controllers;

import com.dm4nk.petclinic.model.Owner;
import com.dm4nk.petclinic.model.Pet;
import com.dm4nk.petclinic.model.PetType;
import com.dm4nk.petclinic.services.OwnerService;
import com.dm4nk.petclinic.services.PetService;
import com.dm4nk.petclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final PetTypeService petTypeService;
    private final OwnerService ownerService;

    public PetController(PetService petService, PetTypeService petTypeService, OwnerService ownerService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
    }

    @InitBinder
    public void dataBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");

        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text));
            }
        });
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findByID(ownerId);
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = Pet.builder()
                .owner(owner)
                .build();
        owner.getPets().add(pet);
        model.addAttribute("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(@Validated Pet pet, Owner owner, BindingResult bindingResult, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            bindingResult.rejectValue("name", "duplicate", "already exists");
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            Pet savedPet = petService.save(pet);
            savedPet.setOwner(owner);
            owner.getPets().add(savedPet);
            ownerService.save(owner);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(Owner owner, @PathVariable("petId") Long petId, Model model) {
        model.addAttribute("pet", petService.findByID(petId));
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Validated Pet pet, BindingResult result, Owner owner, Model model, @PathVariable Long petId) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            Pet ownersPet = owner.getPets().stream()
                    .filter(pet1 -> pet1.getId() == petId)
                    .findFirst()
                    .orElse(null);
            if (ownersPet != null) {
                ownersPet.setName(pet.getName());
                ownersPet.setBirthDate(pet.getBirthDate());
                petService.save(ownersPet);
                ownerService.save(owner);
                return "redirect:/owners/" + owner.getId();
            } else
                return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        }
    }
}
