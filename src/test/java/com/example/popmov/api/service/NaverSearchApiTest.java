package com.example.popmov.api.service;

import com.example.popmov.api.data.NaverRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class NaverSearchApiTest {

    @Autowired
    NaverSearchApi naverSearchApi;

    @Test
    void test(){
        System.out.println(naverSearchApi.imageSearch(
                NaverRequest.builder().query("춘천 반려동물 관광").build()
        ));
    }

    @Test
    void test2(){
        String str = "<b>test</b>";
       String title = str.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");

        System.out.println(title);
    }
}