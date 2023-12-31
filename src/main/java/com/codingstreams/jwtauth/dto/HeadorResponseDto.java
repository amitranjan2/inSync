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
public class HeadorResponseDto {
    private String title;

    private List<Articles> articlesList;

}
