package com.example.popmov.api.data;


import lombok.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalRequest {

    private String partCode;
    /*
    * 분야 코드
    * PC03 관광지
    * PC02 숙박지
    * PC01  식음료
    * PC04  체험
    * PC05  동물병원
    *
    * */
    private Integer page;
    //페이지번호
    private Integer pageBlock;
    //한 페이지에 결과수 1~50

    public MultiValueMap<String,String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String,String>();
        map.add("partCode", partCode);
        map.add("page",page.toString());
        map.add("pageBlock",pageBlock.toString());

        return map;
    }
}
