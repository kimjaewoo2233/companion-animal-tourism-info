package com.example.popmov.dto;


import com.example.popmov.entity.Lik;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private String title;

    private String link;

    private String image;

    private String pubDate;

    private String director;

    private String actor;

    private double userRating;

    private Set<Lik> likeList;
}
