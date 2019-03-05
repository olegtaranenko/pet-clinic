package com.olegtaranenko.udemy.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialitys = new HashSet<>();

    public Set<Speciality> getSpeciality() {
        return specialitys;
    }

    public void setSpeciality(Set<Speciality> specialitys) {
        this.specialitys = specialitys;
    }
}
