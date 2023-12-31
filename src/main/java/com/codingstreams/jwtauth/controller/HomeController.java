package com.codingstreams.jwtauth.controller;

import com.codingstreams.jwtauth.dto.*;
import com.codingstreams.jwtauth.service.HomePageService;
import com.codingstreams.jwtauth.service.MainArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homePage")
public class HomeController {
    @Autowired
    private HomePageService homePageService;

    @Autowired
    private MainArticleService mainArticleService;
    @GetMapping("")
    public HomePageResponseDto availableToAll() {
//        return "I'm publicly accessed by everyone.";

        return homePageService.getHomePageResponse();
    }

    @GetMapping("/featureResult/{id}")
    public HomePageResponseDto featureResult(@PathVariable String id) {
//        return "I'm publicly accessed by everyone.";

        return homePageService.getFeatureResult(id);
    }

    @GetMapping("/featureArticle/{id}")
    public OutsideMainArticleContent featureArticles(@PathVariable Long id) {
//        return "I'm publicly accessed by everyone.";

        return homePageService.getFeatureArticles(id,true,null);
    }


    @GetMapping("/api/non-featured-articles")
    public PaginatedMainArticleDTO getMainArticles(
            @RequestParam(required = false) String category,
            Pageable pageable) {
        return mainArticleService.getMainArticlesByCategoryAndStatus(category, pageable);
    }

    @GetMapping("/api/featured-articles/{id}")
    public MainArticleDto getFeaturedArticles(@PathVariable  Long id) {
        return mainArticleService.getFeaturedArticles(id);
    }


}
