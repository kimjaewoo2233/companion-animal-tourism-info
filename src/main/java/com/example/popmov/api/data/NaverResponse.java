package com.example.popmov.api.data;

import lombok.*;

import java.util.Date;
import java.util.List;


@ToString
@Data
public class NaverResponse {
    private Integer total;
    private Integer start;
    private Integer display;
    private List<Items> items;

    @Data
    @NoArgsConstructor
    public static class Items {
        @Setter(AccessLevel.NONE)
        private String title;   //영화제목
        private String link;    //네이버에서 확인할 수있는 영화정보 url
        @Setter(AccessLevel.NONE)
        private String description;

        private void setDescription(String description){
            this.description = description.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
        }
        private void setTitle(String title){
            this.title = title.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");

        }
    }
}
