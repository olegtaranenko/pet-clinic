package com.olegtaranenko.udemy.services;

import com.olegtaranenko.udemy.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(Long id);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
