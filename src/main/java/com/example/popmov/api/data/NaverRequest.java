package com.example.popmov.api.data;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NaverRequest {


    private String query;

    public MultiValueMap<String,String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String,String>();
        map.add("query", query);
        map.add("display","5");


        return map;
    }
}
