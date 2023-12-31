package com.codingstreams.jwtauth.dto;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDto {
    private String title;
    private String description;
    private String imageUrl;

}
