package com.codingstreams.jwtauth.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "main_article_inside_details")
@Table(name = "main_article_inside_details")
public class MainArticleInsideDetailsEntity extends AbstractJpaEntity {

    @Column(name = "image")
    private String image;

    @Column(name = "title")
    private String title;
    @Column(name = "type")
    private String type;

    @Column(name = "href")
    private String href;

    @Column(name = "video")
    private String video;


    @Column(name = "subTitle")
    private String subTitle;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "main_article_entity_id")
    private MainArticleEntity mainArticleEntity;

}
