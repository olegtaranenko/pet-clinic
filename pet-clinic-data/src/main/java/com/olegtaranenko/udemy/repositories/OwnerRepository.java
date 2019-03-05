package com.olegtaranenko.udemy.repositories;


import com.olegtaranenko.udemy.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
