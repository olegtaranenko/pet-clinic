package com.olegtaranenko.udemy.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

//  TODO this not works, throws exception on compile
//  Error:(27, 5) java: builder() in com.olegtaranenko.udemy.model.Owner cannot hide builder() in com.olegtaranenko.udemy.model.Person
//  return type com.olegtaranenko.udemy.model.Owner.OwnerBuilder is not compatible with com.olegtaranenko.udemy.model.Person.PersonBuilder
//    @Builder
    public Owner(String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
        super(firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }
}
