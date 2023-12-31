package com.codingstreams.jwtauth.dto;
import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CtaDto {

    private String title;

    private String type;
    private String hrefLink;


}
