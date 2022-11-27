package com.example.popmov.controller;


import com.example.popmov.api.data.AnimalRequest;
import com.example.popmov.api.data.AnimalResponse;
import com.example.popmov.api.service.AnimalApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DataController {

    private final AnimalApiService animalApiService;
    @GetMapping("/list")
    public ResponseEntity<List<AnimalResponse>> get(@RequestParam String partCode, @RequestParam int page) throws ParseException, JsonProcessingException {
        animalApiService.animalRequestAPI(AnimalRequest.builder().partCode(partCode)
                        .pageBlock(5)
                        .page(page)
                .build());

        return ResponseEntity.ok(animalApiService.animalRequestAPI(AnimalRequest.builder().partCode(partCode)
                .pageBlock(5)
                .page(page)
                .build()));
    }
}
