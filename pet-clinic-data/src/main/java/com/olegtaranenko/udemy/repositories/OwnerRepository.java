package com.olegtaranenko.udemy.repositories;


import com.olegtaranenko.udemy.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findByLastName(String name);
}
