package com.olegtaranenko.udemy.petclinic.bootstrap;

import com.olegtaranenko.udemy.model.*;
import com.olegtaranenko.udemy.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      PetService petService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dogsType = petTypeService.save(new PetType("Dog"));
        PetType catsType = petTypeService.save(new PetType("Cat"));


        Owner irisha = new Owner();
        irisha.setFirstName("Irina");
        irisha.setLastName("Taranenko");
        irisha.setAddress("Taubestr 7");
        irisha.setCity("Leipzig");
        irisha.setTelephone("+49 179 5425012");
        Pet bonita = new Pet(dogsType,"Bonita");
        bonita.setOwner(irisha);
        bonita.setBirthDate(LocalDate.parse("2012-04-29"));
        irisha.getPets().add(bonita);

        ownerService.save(irisha);

        Owner mak = new Owner();
        mak.setAddress("Alterbergstr 12");
        mak.setCity("Lahr");
        mak.setTelephone("+49 152 123420874");
        mak.setFirstName("Irina");
        mak.setLastName("Mak");
        Pet cosmos = new Pet(catsType,"Kosmos");
        cosmos.setBirthDate(LocalDate.parse("2013-01-12"));
        cosmos.setOwner(mak);
        mak.getPets().add(cosmos);
        ownerService.save(mak);

        Visit catVisit = new Visit();
        catVisit.setPet(cosmos);
        catVisit.setData(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);
        System.out.println("Loaded Owners");

        Speciality radio = specialityService.save(new Speciality("Radiology"));
        Speciality immuno = specialityService.save(new Speciality("Immunology"));

        Vet vet1 = new Vet();
        vet1.setFirstName("Spoch");
        vet1.setLastName("Ben");
        vet1.getSpeciality().add(radio);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Winny");
        vet2.setLastName("Puh");
        vet2.getSpeciality().add(immuno);
        vetService.save(vet2);

        System.out.println("Loaded Vets");
        
    }
}
