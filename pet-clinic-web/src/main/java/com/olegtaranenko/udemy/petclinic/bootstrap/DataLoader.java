package com.olegtaranenko.udemy.petclinic.bootstrap;

import com.olegtaranenko.udemy.model.Owner;
import com.olegtaranenko.udemy.model.PetType;
import com.olegtaranenko.udemy.model.Vet;
import com.olegtaranenko.udemy.services.OwnerService;
import com.olegtaranenko.udemy.services.PetService;
import com.olegtaranenko.udemy.services.PetTypeService;
import com.olegtaranenko.udemy.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dogsType = petTypeService.save(new PetType("Dog"));
        PetType catsType = petTypeService.save(new PetType("Cat"));
        
        
        Owner owner1 = new Owner();
        owner1.setFirstName("Irina");
        owner1.setLasttName("Taranenko");
        owner1.setAddress("Taubestr 7");
        owner1.setCity("Leipzig");
        owner1.setTelephone("+49 179 5425012");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setAddress("Blockschluck 14");
        owner2.setCity("Lahr");
        owner2.setTelephone("+49 152 123420874");
        owner2.setFirstName("Jessica");
        owner2.setLasttName("Lang");
        ownerService.save(owner2);

        System.out.println("Loaded Owners");
        
        Vet vet1 = new Vet();
        vet1.setFirstName("Spoch");
        vet1.setLasttName("Ben");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Winny");
        vet2.setLasttName("Puh");
        vetService.save(vet2);

        System.out.println("Loaded Vets");
        
    }
}
