package com.olegtaranenko.udemy.services.springdatajpa;

import com.olegtaranenko.udemy.model.Speciality;
import com.olegtaranenko.udemy.repositories.SpecialityRepository;
import com.olegtaranenko.udemy.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialityJPAService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityJPAService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialitys = new HashSet<>();

        specialityRepository.findAll().forEach(specialitys::add);

        return specialitys;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
