package com.codingstreams.jwtauth.dto;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MainArticleInsideDetailsDTO {
    private String image;
    private String title;
    private String type;
    private String video;
    private String href;

    private String subTitle;
    private String description;
}
