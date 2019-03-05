package com.olegtaranenko.udemy.repositories;


import com.olegtaranenko.udemy.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
