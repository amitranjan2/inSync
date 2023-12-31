package com.codingstreams.jwtauth.dto;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Articles {
    private String date;
    private String title;
    private String subTitle;

    private String topHeader;

    private String imageUrl;

    private String description;


}
