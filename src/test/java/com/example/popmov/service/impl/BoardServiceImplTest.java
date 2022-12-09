package com.example.popmov.service.impl;

import com.example.popmov.dto.BoardDTO;
import com.example.popmov.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BoardServiceImplTest {


    @Autowired
    BoardService boardService;

    @Test
    @DisplayName("데이터 저장 테스트")
    void test1(){
        IntStream.rangeClosed(1,30).forEach(value->{
            boardService.saveBoard(BoardDTO.builder()
                    .title("제목..."+value)
                    .content("내용..."+value)
                    .visit("방문..."+value)
                    .companion("동물..."+value)
                    .build());
        });
    }

    @Test
    @DisplayName("모든 값 출력")
    void test2(){
        //boardService.getList().forEach(System.out::println);
    }
}