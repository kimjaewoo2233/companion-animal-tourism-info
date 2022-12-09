package com.example.popmov.api.service;

import com.example.popmov.api.data.AnimalRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

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

    @Test
    void test2() throws ParseException, JsonProcessingException, UnsupportedEncodingException, URISyntaxException {
       // System.out.println(animalApiService.animalAddAPI());
        String str = "http://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo?serviceKey=tt0TIgh4JEG1OSKZfrkc45TJXCysw2LRwPbdb2PRax2rn%2BJXMKBF1oTfcKbBNde1LtomtFJUT8EUrv4uBY36BQ%253D%253D&pageNo=3";
        String str2 = "http://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo?serviceKey=tt0TIgh4JEG1OSKZfrkc45TJXCysw2LRwPbdb2PRax2rn%2BJXMKBF1oTfcKbBNde1LtomtFJUT8EUrv4uBY36BQ%3D%3D&pageNo=3";
        System.out.println(str.equals(str2));
    }
}