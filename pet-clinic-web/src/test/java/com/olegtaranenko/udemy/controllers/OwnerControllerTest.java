package com.olegtaranenko.udemy.controllers;

import com.olegtaranenko.udemy.model.Owner;
import com.olegtaranenko.udemy.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by user1 at Mar 07, 2019
 */
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    private static final Long ID = 1L;
    @Mock
    OwnerService service;

    @InjectMocks
    OwnerController controller;

    private Set<Owner> owners = new HashSet<>();

    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        owners.clear();
        owners.add(Owner.builder().id(ID).build());
        owners.add(Owner.builder().id(ID + 1).build());

        mvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void listOwners() throws Exception {

        when(service.findAll()).thenReturn(owners);

        mvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void listOwnersByIndex() throws Exception {

        when(service.findAll()).thenReturn(owners);

        mvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOnwersNotimplemented() throws Exception {
        mvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyZeroInteractions(service);
    }
}