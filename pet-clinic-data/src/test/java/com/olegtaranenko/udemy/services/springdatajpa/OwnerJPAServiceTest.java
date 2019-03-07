package com.olegtaranenko.udemy.services.springdatajpa;

import com.olegtaranenko.udemy.model.Owner;
import com.olegtaranenko.udemy.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by user1 at Mar 07, 2019
 */

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerJPAService service;

    private Owner smith;

    private final String LAST_NAME = "Smith";
    private final Long ID = 1L;

    @BeforeEach
    void setUp() {
        smith = Owner.builder().lastName(LAST_NAME).id(ID).build();
    }


    @Test
    void findByLastName() {
        // mockup instrumenting
        when(ownerRepository.findByLastName(any())).thenReturn(smith);

        Owner owner = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(ID).build());
        ownerSet.add(Owner.builder().id(ID + 1).build());

        // mockup instrumenting
        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);

        assertEquals(2, owners.size());
    }

    @Test
    void findById() {

        // mockup instrumenting
        when(ownerRepository.findById(any())).thenReturn(Optional.ofNullable(smith));

        Owner owner = service.findById(ID);

        assertNotNull(owner);
        assertEquals(ID, owner.getId());
    }

    @Test
    void save() {
        Owner noSmith = Owner.builder().id(ID + 1).build();
        when(ownerRepository.save(any())).thenReturn(noSmith);

        Owner saved = service.save(noSmith);

        assertNotNull(saved);

        assertNotEquals(ID, saved.getId());

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {

        service.delete(smith);

        assertEquals(0, service.findAll().size());

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(ID);

        assertEquals(0, service.findAll().size());

        verify(ownerRepository, times(1)).deleteById(any());
    }
}