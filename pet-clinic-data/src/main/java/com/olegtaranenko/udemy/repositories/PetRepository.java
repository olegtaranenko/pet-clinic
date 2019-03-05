package com.olegtaranenko.udemy.repositories;


import com.olegtaranenko.udemy.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
