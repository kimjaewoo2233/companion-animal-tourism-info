package com.example.popmov.controller;


import com.example.popmov.service.NaverBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final NaverBlogService naverBlogService;

    @GetMapping("/")
    public String getMain(Model model){

        model.addAttribute("blog",naverBlogService.blogItems("춘천 반려동물 관광"));
        return "index";
    }


}


