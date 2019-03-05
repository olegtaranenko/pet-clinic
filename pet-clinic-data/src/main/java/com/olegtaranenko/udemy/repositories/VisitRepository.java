package com.olegtaranenko.udemy.repositories;


import com.olegtaranenko.udemy.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
