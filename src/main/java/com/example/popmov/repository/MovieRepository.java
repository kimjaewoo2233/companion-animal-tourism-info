package com.example.popmov.repository;

import com.example.popmov.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,String> {

        @Query("select m from Movie m left join fetch m.likeList l where m.name = :name")
        public Movie getMovieList(String name);




}
