package com.olegtaranenko.udemy.services.map;

import com.olegtaranenko.udemy.model.Owner;
import com.olegtaranenko.udemy.model.Pet;
import com.olegtaranenko.udemy.services.OwnerService;
import com.olegtaranenko.udemy.services.PetService;
import com.olegtaranenko.udemy.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"map", "default"})
public class OwnerMapService extends AbstractMapService<Owner> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType().getId() == null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                    if (pet.getId() == null) {
                        petService.save(pet);
//                        object.getPets().add(s)
                    }
                });
            }
        }

        return super.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return null;
    }

    @Override
    public Owner findByLastName(String text) {
        return null;
/*
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
*/
    }
}
