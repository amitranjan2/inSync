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
public class MainArticlesContent {
    private String sideBarTitle;
    private String href;


    private InsideMainArticleContent insideMainArticleContent;


}
