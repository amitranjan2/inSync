package com.codingstreams.jwtauth.dto;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MainArticleDto {
    private Long id;
    private String image;
    private String title;
    private String subTitle;
    private String description;
    private String category;

    private String createdAt;
    private String smallImageUrl;
    private String footerTitle;
    private boolean featureArticle;
    private List<MainArticleInsideDetailsDTO> mainArticleInsideDetails;
}
