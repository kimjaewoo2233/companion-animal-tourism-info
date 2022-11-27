package com.example.popmov.api.service;

import com.example.popmov.api.data.BoxOfficeRequest;
import com.example.popmov.api.data.NaverRequest;
import com.example.popmov.api.data.NaverResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BoxOfficeApiTest {


    @Autowired
    BoxOfficeApi boxOfficeApi;

    @Autowired
    NaverSearchApi naverSearchApi;
    @Test
    @DisplayName("박스오피스 정보 받아오는 테스트")
    void test() throws JsonProcessingException {
        boxOfficeApi.boxOfficeGet(BoxOfficeRequest.builder()
                .build()).forEach(System.out::println);
    }
    
    @Test
    @DisplayName("네이버 검색 정보가 작동하는지 테스트")
    void test2(){
        System.out.println(naverSearchApi.imageSearch(NaverRequest.builder().query("자백").build()));;
    }
    @Test
    @DisplayName("박스오피스 정보를 필터링하여 저장한다.")
    void test3() throws JsonProcessingException {
//        List<NaverResponse.Items> movieList = new ArrayList<>();
//        boxOfficeApi.boxOfficeGet(BoxOfficeRequest.builder().build()).forEach(boxOfficeResponse -> {
//            movieList.add(naverSearchApi
//                    .imageSearch(NaverRequest.builder()
//                            .query(boxOfficeResponse.getMovieNm()).build()).getItems()
//                    .stream().filter(items -> items.getUserRating() > 5.0)
//                    .findFirst().orElse(null));
//        });

//        movieList.forEach(System.out::println);
    }

}