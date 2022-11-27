package com.example.popmov.api.data;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoxOfficeResponse {
    private String rank;
    private String rankOldAndNew;
    private String movieNm;
    private String audiCnt; //해당일에 관객수
    private String auidAcc; //누적관객수
}
