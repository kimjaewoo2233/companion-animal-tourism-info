package com.example.popmov.api.data;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AnimalResponse {

    private List<ResultList> resultList;
    private Integer totalCount;
    private String message;
        @Data
        @NoArgsConstructor
        public static class ResultList{

            private Integer contentSeq;
            private String areaName;
            private String partName;
            private String title;
            private String address;
            private String latitude;
            private String longitude;
            private String tel;
        }

}
