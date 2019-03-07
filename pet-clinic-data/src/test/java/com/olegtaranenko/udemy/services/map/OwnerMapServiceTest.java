package com.olegtaranenko.udemy.services.map;

import com.olegtaranenko.udemy.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by user1 at Mar 07, 2019
 */
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long ownerId = 1L;
    final String lastName = "Oleg";


    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void save() {
        Long bobId = 2L;
        Owner bob = Owner.builder().id(bobId).build();
        Owner saved = ownerMapService.save(bob);

        assertEquals(bobId, saved.getId());
    }

    @Test
    void saveNoId() {
        Owner newOwner = Owner.builder().build();

        newOwner = ownerMapService.save(newOwner);
        assertNotNull(newOwner);
        assertNotNull(newOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName("foo");

        assertNull(owner);
    }
}