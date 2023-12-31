package com.codingstreams.jwtauth.dto;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoDto {
    private String title;
    private String description;
    private String VideoUrl;
}
