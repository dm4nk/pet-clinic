package com.dm4nk.petclinic.bootstrap;

import com.dm4nk.petclinic.model.Owner;
import com.dm4nk.petclinic.model.PetType;
import com.dm4nk.petclinic.model.Vet;
import com.dm4nk.petclinic.services.OwnerService;
import com.dm4nk.petclinic.services.PetTypeService;
import com.dm4nk.petclinic.services.VetService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DataLoader implements CommandLineRunner {

    OwnerService ownerService;
    VetService vetService;
    PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        System.out.println("Loaded data");
    }
}
