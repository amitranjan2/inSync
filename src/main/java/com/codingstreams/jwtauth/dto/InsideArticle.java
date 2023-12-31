package com.codingstreams.jwtauth.dto;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsideArticle {
    private String title;
    private String subTitle;
}
