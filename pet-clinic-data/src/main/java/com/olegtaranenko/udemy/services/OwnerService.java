package com.olegtaranenko.udemy.services;

import com.olegtaranenko.udemy.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String text);

}
