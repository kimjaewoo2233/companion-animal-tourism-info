package com.example.popmov.controller;


import com.example.popmov.dto.BoardDTO;
import com.example.popmov.service.BoardService;
import com.example.popmov.service.NaverBlogService;
import com.example.popmov.service.PageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final NaverBlogService naverBlogService;

    private final BoardService boardService;

    private final PageService pageService;


    @GetMapping("/")
    public String getMain(Model model){

        model.addAttribute("blog",naverBlogService.blogItems("춘천 반려동물 관광"));
        return "index";
    }

    @GetMapping("/board")
    public String getBoard(Model model,@PageableDefault(
            size = 10,sort="id",direction = Sort.Direction.DESC
    ) Pageable pageable){

        Page<BoardDTO> boardDTOPage = boardService.getList(pageable);
        List<Integer> pageNumbers = pageService.getPagination(pageable.getPageNumber(),boardDTOPage.getTotalPages());

        model.addAttribute("list", boardService.getList(pageable));
        model.addAttribute("pageNumbers",pageNumbers);
        model.addAttribute("page",pageable.getPageNumber());

        return "board";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/write")
    public String getWrite(){
        return "write";
    }



    @PreAuthorize("isAuthenticated()")
    @GetMapping("/read")
    public String getRead(@RequestParam(required = true) Long id,Model model){
                    model.addAttribute("element",boardService.getRead(id));
                    return "read";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/write")
    public String getPostWrite(BoardDTO dto){
        System.out.println(dto.getWriter());
                boardService.saveBoard(dto);
                return "redirect:/board";
    }

    @PostMapping("/delete")
    public String getDelete(BoardDTO dto){
        log.info("요청받은 데이터== {}",dto);

        boardService.delete(dto);
        return "redirect:/board";

    }
    @GetMapping("/modify")
    public String getModify(Model model,@RequestParam(required = true) Long id){
        model.addAttribute("element",boardService.getRead(id));

        return "modify";
    }

    @PostMapping("/modify")
    public String postModify(BoardDTO dto){
        log.info("요청받은 데이터== {}",dto);

        boardService.modify(dto);

        return "redirect:/board";
    }

}


