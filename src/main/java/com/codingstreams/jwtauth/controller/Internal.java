package com.codingstreams.jwtauth.controller;

import com.codingstreams.jwtauth.dto.NavBarDto;
import com.codingstreams.jwtauth.dto.OutsideMainArticleContent;
import com.codingstreams.jwtauth.dto.PaginatedMainArticleDTO;
import com.codingstreams.jwtauth.service.HomePageService;
import com.codingstreams.jwtauth.service.MainArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal")
public class Internal {
    @Autowired
    private HomePageService homePageService;

    @Autowired
    private MainArticleService mainArticleService;


    @GetMapping("homepage/api/main-featured-articles")
    public PaginatedMainArticleDTO getAllMainArticles(Pageable pageable) {
        return mainArticleService.getAllMainArticles(pageable);
    }
    @GetMapping("/homepage/navbar")
    public NavBarDto getNavbar() {
        return homePageService.getNavbar();
    }
    @GetMapping("/homepage/featureArticle/{id}")
    public OutsideMainArticleContent featureArticles(@PathVariable Long id) {
//        return "I'm publicly accessed by everyone.";

        return homePageService.getFeatureArticles(id,true,null);
    }
}
