package com.olegtaranenko.udemy.petclinic.bootstrap;

import com.olegtaranenko.udemy.model.Owner;
import com.olegtaranenko.udemy.model.Vet;
import com.olegtaranenko.udemy.services.OwnerService;
import com.olegtaranenko.udemy.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Irina");
        owner1.setLasttName("Taranenko");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(1L);
        owner2.setFirstName("Jessica");
        owner2.setLasttName("Lang");
        ownerService.save(owner2);

        System.out.println("Loaded Owners");
        
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Spoch");
        vet1.setLasttName("Ben");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Winny");
        vet2.setLasttName("Puh");
        vetService.save(vet2);

        System.out.println("Loaded Vets");
        
    }
}
