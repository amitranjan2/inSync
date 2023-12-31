package com.codingstreams.jwtauth.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutsideMainArticleContent {

    private String title;
    private String subTitle;

    private String description;

    private String type;

    private String date;

    List<MainArticlesContent> contents;


}
