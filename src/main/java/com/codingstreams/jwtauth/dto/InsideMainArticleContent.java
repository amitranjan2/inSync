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
public class InsideMainArticleContent {
    private String title;
    private String type;

    private String subTitle;
    private String date;
    private String description;

    private List<ImageDto> imageDto;
    private String videoUrl;


    private List<VideoDto> videoDto;

}
