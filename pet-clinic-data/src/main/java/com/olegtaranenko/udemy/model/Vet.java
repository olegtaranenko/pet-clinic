package com.olegtaranenko.udemy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vet extends Person {

    private Set<Speciality> specialitys = new HashSet<>();

    public Set<Speciality> getSpeciality() {
        return specialitys;
    }

    public void setSpeciality(Set<Speciality> specialitys) {
        this.specialitys = specialitys;
    }
}
