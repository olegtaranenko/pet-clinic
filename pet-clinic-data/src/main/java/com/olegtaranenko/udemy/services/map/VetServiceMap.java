package com.olegtaranenko.udemy.services.map;

import com.olegtaranenko.udemy.model.Vet;
import com.olegtaranenko.udemy.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
