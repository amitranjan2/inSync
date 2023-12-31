package com.codingstreams.jwtauth.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Setter


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "main_article_entity")
@Table(name = "main_article_entity")
public class MainArticleEntity extends AbstractJpaEntity {


    @Column(name = "image")
    private String image;

    @Column(name = "title")
    private String title;

    @Column(name = "subTitle")
    private String subTitle;
    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "small_image")
    private String smallImageUrl;

    @Column(name = "footer_title")
    private String footerTitle;

    @Column(name = "feature_article")
    private boolean featureArticle;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainArticleEntity")
    private List<MainArticleInsideDetailsEntity> mainArticleInsideDetails = new ArrayList<>();

    @Override
    public String toString() {
        return "MainArticleEntity{" +
                // ... other fields ...
                '}';
    }


}
