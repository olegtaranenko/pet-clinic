package com.olegtaranenko.udemy.services.map;

import com.olegtaranenko.udemy.model.Owner;
import com.olegtaranenko.udemy.model.Vet;
import com.olegtaranenko.udemy.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
//        return super.findAll();
//        return this.findAll();
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
