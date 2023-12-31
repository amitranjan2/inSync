package com.codingstreams.jwtauth.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "section_bar")
@Table(name = "section_bar")
public class SectionBar extends AbstractJpaEntity{
    @Column(name = "redirection_link")
    private String redirectionLink;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "image")
    private String image;

    @Column(name = "priority")
    private Long priority;

    @Lob
    @Column(name = "json_data")
    private String jsonData;
}
