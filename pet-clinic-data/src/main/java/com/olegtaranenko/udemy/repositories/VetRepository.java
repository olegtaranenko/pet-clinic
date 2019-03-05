package com.olegtaranenko.udemy.repositories;


import com.olegtaranenko.udemy.model.Owner;
import com.olegtaranenko.udemy.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
