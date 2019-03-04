package com.olegtaranenko.udemy.services;

import com.olegtaranenko.udemy.model.Owner;

public interface OwnerService extends CrudService<Owner> {

    Owner findByLastName(String text);

}
