package com.example.popmov.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {


    @Id
    private String name;

    private String image;

    private String link;

    private String pubDate;

    private String director;

    private String actor;

    private double userRating;

    @OneToMany(mappedBy = "movie_id")
    private Set<Lik> likeList;

    public void changeName(String name){
        this.name = name;
    }
}
