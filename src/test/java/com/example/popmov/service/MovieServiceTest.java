package com.example.popmov.service;

import com.example.popmov.repository.LikeRepository;
import com.example.popmov.repository.MovieRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MovieServiceTest {
    @Autowired
    LikeRepository likeRepository;

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieService movieService;

    @Test
    @DisplayName("좋아요개수 테스트")
    void likeTest(){
      //  System.out.println(movieService.getLikeCount("영화1"));
    }
    @Test
    @DisplayName("영화 실제 저장 테스트")
    void movieSaveTest() throws JsonProcessingException {

      //  movieService.boxDataUpdate();

    }
}