package com.example.popmov.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Lik {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="movie_id")
        private Movie movie_id;
        //@ManyToOne으로 설정한 필드에 연관된 객체를 할당한 뒤에 저장하면 매핑된 칼럼에 연관된 객체의 실별자를 저장한다.
        //기본 로딩 EAGER


        private boolean lik;

        public void changeLike(Movie movie,boolean lik){
                this.movie_id = movie;
                this.lik = lik;

        }


}
