package com.example.popmov.repository;

import com.example.popmov.entity.Lik;
import com.example.popmov.entity.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    LikeRepository likeRepository;

    @Autowired
    MovieRepository movieRepository;


    @Test
    @DisplayName("연관관계 테스트")
    void jpaTest(){

        Movie movie = new Movie();

        Lik like1 = new Lik();
        like1.changeLike(movie,true);
        Lik like2 = new Lik();
        like2.changeLike(movie,false);
        movie.changeName("영화1");

        movieRepository.save(movie);
        likeRepository.saveAll(List.of(like1,like2));
        movieRepository.getMovieList("영화1")
                .getLikeList().stream().filter(lik -> lik.isLik() == true)
                .forEach(System.out::println);


    }
}