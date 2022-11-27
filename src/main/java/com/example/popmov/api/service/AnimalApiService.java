package com.example.popmov.api.service;


import com.example.popmov.api.data.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnimalApiService {

    public List<AnimalResponse> animalRequestAPI(AnimalRequest request) throws JsonProcessingException, ParseException {

        JSONParser parser = new JSONParser();

        var uri = UriComponentsBuilder
                .fromUriString("https://www.pettravel.kr/api/listPart.do")
                .queryParams(request.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<List<AnimalResponse>>(){};
        ResponseEntity<List<AnimalResponse>> responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                null,
                responseType
        );

        return responseEntity.getBody();
    }
}
