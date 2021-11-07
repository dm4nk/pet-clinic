package com.dm4nk.petclinic.bootstrap;

import com.dm4nk.petclinic.model.Owner;
import com.dm4nk.petclinic.model.Vet;
import com.dm4nk.petclinic.services.OwnerService;
import com.dm4nk.petclinic.services.VetService;
import com.dm4nk.petclinic.services.map.OwnerServiceMap;
import com.dm4nk.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        System.out.println("Loaded data");
    }
}
