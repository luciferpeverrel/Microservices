package com.example.demo;

import com.example.demo.controller.CarsController;
import com.example.demo.model.Cars;
import com.example.demo.service.CarsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(CarsMockitoTest.class)
public class CarsMockitoTest {
    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    @Mock
    private CarsService carsService;

    @InjectMocks
    @Autowired
    private CarsController carsController;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(carsController).build();
    }

    Cars cars1 = new Cars(1,"Electra",178);
    Cars cars2 = new Cars(2,"Tesla",300);

    @Test
    public void getCars() throws Exception{
        List<Cars> carss = new ArrayList<Cars>(Arrays.asList(cars1,cars2));
        Mockito.when(carsService.getCars()).thenReturn(carss);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/get")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].carName",is("Electra")));

    }



}