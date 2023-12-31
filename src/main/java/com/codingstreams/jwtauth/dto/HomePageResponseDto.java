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
public class HomePageResponseDto {
    private String title;
    private String description;
    private String subTitle;

    private List<CtaDto> ctaDtoList;

    private HeadorResponseDto headorResponseDto;

    private HeadorResponseDto footerResponseDto;




}
