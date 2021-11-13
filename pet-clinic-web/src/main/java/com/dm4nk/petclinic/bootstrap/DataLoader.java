package com.dm4nk.petclinic.bootstrap;

import com.dm4nk.petclinic.model.Owner;
import com.dm4nk.petclinic.model.Pet;
import com.dm4nk.petclinic.model.PetType;
import com.dm4nk.petclinic.model.Vet;
import com.dm4nk.petclinic.services.OwnerService;
import com.dm4nk.petclinic.services.PetTypeService;
import com.dm4nk.petclinic.services.VetService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
    public void run(String... args) {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Something");
        owner1.setCity("Miami");
        owner1.setTelephone("89277583192");
        Pet mikesDog = new Pet();
        mikesDog.setPetType(savedDogPetType);
        mikesDog.setOwner(owner1);
        mikesDog.setBirthday(LocalDate.now());
        mikesDog.setName("Rosco");
        owner1.getPets().add(mikesDog);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenenne");
        owner2.setAddress("321 Something");
        owner2.setCity("Miami");
        owner2.setTelephone("89277583193");
        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthday(LocalDate.now());
        fionasCat.setName("Cat");
        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        System.out.println("Loaded data");
    }
}
