package com.example.popmov.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Board {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        private String content;

        private String visit;   //방문장소

        private String companion;       //반려견 이름

        private String writer;

        @CreatedDate
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDateTime createdAt;

        public void modifyBoard(String title,String content,String visit,String companion){
                this.title = title;
                this.content = content;
                this.companion = companion;
                this.visit =visit;
        }

}
