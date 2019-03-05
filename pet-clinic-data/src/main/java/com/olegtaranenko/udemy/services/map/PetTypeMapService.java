package com.olegtaranenko.udemy.services.map;

import com.olegtaranenko.udemy.model.PetType;
import com.olegtaranenko.udemy.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType PetType) {
        return super.save(PetType);
    }

    @Override
    public void delete(PetType PetType) {
        super.delete(PetType);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
