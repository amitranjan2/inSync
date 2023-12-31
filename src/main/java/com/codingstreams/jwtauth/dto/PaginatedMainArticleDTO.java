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
public class PaginatedMainArticleDTO {
    private List<MainArticleDto> content;
    private int totalPages;
    private long totalElements;

    private String title;
    private String description;
    private String subTitle;

    private List<CtaDto> ctaDtoList;
}
