package com.example.popmov.dto;


import com.example.popmov.entity.Board;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BoardDTO {



    private Long id;

    private String title;

    private String content;

    private String visit;

    private String companion;

    private String writer;

    private LocalDateTime createdAt;

    public static Board toEntity(BoardDTO dto){

        return Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .visit(dto.getVisit())
                .companion(dto.getCompanion())
                .writer(dto.getWriter())
                .createdAt(dto.getCreatedAt())
                .build();
    }

    public static BoardDTO toDTO(Board entity){

        return BoardDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .visit(entity.getVisit())
                .writer(entity.getWriter())
                .companion(entity.getCompanion())
                .createdAt(entity.getCreatedAt())
                .build();
    }


}
