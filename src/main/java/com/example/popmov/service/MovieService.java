package com.example.popmov.service;


import com.example.popmov.api.data.BoxOfficeRequest;
import com.example.popmov.api.data.NaverRequest;
import com.example.popmov.api.data.NaverResponse;
import com.example.popmov.api.service.BoxOfficeApi;
import com.example.popmov.api.service.NaverSearchApi;
import com.example.popmov.dto.MovieDTO;
import com.example.popmov.entity.Movie;
import com.example.popmov.repository.MovieRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    private final NaverSearchApi naverSearchApi;

    private final BoxOfficeApi boxOfficeApi;

//    public Integer getLikeCount(String name){
//
//        return movieRepository.getMovieList(name)
//                .getLikeList()
//                .stream().filter(lik -> lik.isLik() == true)
//                .collect(Collectors.toList()).size();
//    }
//
//    public void boxDataUpdate() throws JsonProcessingException {
//        List<NaverResponse.Items> movieList = new ArrayList<>();
//
//        boxOfficeApi.boxOfficeGet(BoxOfficeRequest.builder().build()).forEach(boxOfficeResponse -> {
//            movieList.add(naverSearchApi
//                    .movieSearch(NaverRequest.builder()
//                            .query(boxOfficeResponse.getMovieNm()).build()).getItems()
//                    .stream().filter(items -> items.getUserRating() > 5.0)
//                    .findFirst().orElse(null));
//        });
//
//        for (NaverResponse.Items items : movieList) {
//            if(items != null){
//                movieRepository.save(Movie.builder()
//                        .name(items.getTitle())
//                        .link(items.getLink())
//                        .image(items.getImage())
//                        .pubDate(items.getPubDate().toString())
//                        .director(items.getDirector())
//                        .actor(items.getActor())
//                        .userRating(items.getUserRating())
//                        .build());
//            }
//        }

    }







