package com.example.popmov.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class NaverBlogServiceTest {

    @Autowired
    NaverBlogService naverBlogService;


    @Test
    void test(){
        naverBlogService.blogItems("춘천 반려동물 관광").forEach(System.out::println);
    }
}