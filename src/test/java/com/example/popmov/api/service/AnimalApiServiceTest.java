package com.example.popmov.api.service;

import com.example.popmov.api.data.AnimalRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnimalApiServiceTest {


    @Autowired
    AnimalApiService animalApiService;

    @Test
    void test() throws JsonProcessingException, ParseException {
        System.out.println(animalApiService.animalRequestAPI(AnimalRequest.builder()
                .page(1)
                .pageBlock(2)
                .partCode("PC01")
                .build()));;

    }
}