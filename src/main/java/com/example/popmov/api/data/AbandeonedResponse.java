package com.example.popmov.api.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties({"numOfRows"})
public class AbandeonedResponse {

    public Header header;
    public Body body;


    @Data
    public static class Header{
        private String reqNo;
        private String resultCode;
        private String resultMsg;
    }

    @Data
    public static class Body{
            public List<Item> items;
    }

    @Data
    public static class Item{
                private String careNm;  //이름
                private String orgNm;
                private String divisionNm;
                private String saveTrgtAnimal;
                private String careAddr;
                private String jibunAddr;
                private String lat;
                private String lng;
//                private String dsignationDate;
//                private String weekOprStime;
//                private String weekOprEtime;
//                private String weekCellStime;
//                private String weekCellEtime;
//                private String weekendOprStime;
//                private String weekendOprEtime;
//                private String weekendCellStime;
//                private String weekendCellEtime;
//                private String closeDay;
//                private String vetPersonCnt;
//                private String specsPersonCnt;
//                private String medicalCnt;
//                private String breedCnt;
//                private String quarabtineCnt;
//                private String feedCnt;
//                private String transCarCnt;
//                private String careTel;
//                private String dataStdDt;
//                private String numOfRows;
//                private String pageNo;
//                private String totalCount;














    }
}
