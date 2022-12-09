package com.example.popmov.api.service;


import com.example.popmov.api.data.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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

    public AbandeonedResponse animalAddAPI(int page) throws ParseException, URISyntaxException {

        String str = "http://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo?serviceKey=tt0TIgh4JEG1OSKZfrkc45TJXCysw2LRwPbdb2PRax2rn%2BJXMKBF1oTfcKbBNde1LtomtFJUT8EUrv4uBY36BQ%3D%3D&pageNo="+Integer.toString(page);
        URI uriTest = new URI(str);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<List<AnimalResponse>>(){};
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(
                uriTest,
                HttpMethod.GET,
                httpEntity,
                String.class
        );
        System.out.println(responseEntity.getBody());
        AbandeonedResponse result = parser(responseEntity.getBody());
        return result;
    }
    public AbandeonedResponse parser(String xml) {
        ObjectMapper xmlMapper = new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        AbandeonedResponse response = null;
        try {
            response = xmlMapper.readValue(xml, AbandeonedResponse.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;
    }
}