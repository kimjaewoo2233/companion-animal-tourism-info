package com.example.popmov.service;


import com.example.popmov.api.data.NaverRequest;
import com.example.popmov.api.data.NaverResponse;
import com.example.popmov.api.service.NaverSearchApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NaverBlogService {

    private final NaverSearchApi naverSearchApi;


    public List<NaverResponse.Items> blogItems(String searchQuery){

        return naverSearchApi.
                imageSearch(NaverRequest.builder()
                        .query(searchQuery).build())
                .getItems();
    }

}
