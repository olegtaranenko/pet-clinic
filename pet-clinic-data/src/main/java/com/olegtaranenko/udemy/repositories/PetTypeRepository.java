package com.olegtaranenko.udemy.repositories;


import com.olegtaranenko.udemy.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
