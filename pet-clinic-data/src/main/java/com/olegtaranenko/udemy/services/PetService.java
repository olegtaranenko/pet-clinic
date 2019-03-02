package com.olegtaranenko.udemy.services;

import com.olegtaranenko.udemy.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet Pet);

    Set<Pet> findAll();
}
