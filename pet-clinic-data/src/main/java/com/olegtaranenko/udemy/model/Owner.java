package com.olegtaranenko.udemy.model;

import java.util.Set;

public class Owner extends Person {
    private Set<Pet> pets;

    public Owner(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
