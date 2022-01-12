package com.dm4nk.petclinic.bootstrap;

import com.dm4nk.petclinic.model.*;
import com.dm4nk.petclinic.services.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DataLoader implements CommandLineRunner {

    OwnerService ownerService;
    VetService vetService;
    PetTypeService petTypeService;
    SpecialityService specialityService;
    VisitService visitService;

    @Override
    public void run(String... args) {
        int count = petTypeService.findAll().size();

        if (count == 0) loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Something");
        owner1.setCity("Miami");
        owner1.setTelephone("89277583192");

        Pet mikesDog = new Pet();
        mikesDog.setPetType(savedDogPetType);
        mikesDog.setOwner(owner1);
        mikesDog.setBirthDate(LocalDate.now());
        mikesDog.setName("Rosco");
        owner1.getPets().add(mikesDog);

        Pet mikesDog2 = new Pet();
        mikesDog2.setPetType(savedDogPetType);
        mikesDog2.setOwner(owner1);
        mikesDog2.setBirthDate(LocalDate.now());
        mikesDog2.setName("Rosco2");
        owner1.getPets().add(mikesDog2);

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
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Cat");
        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded data");
    }
}
