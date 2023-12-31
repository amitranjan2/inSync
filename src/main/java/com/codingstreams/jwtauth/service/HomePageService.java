package com.codingstreams.jwtauth.service;

import com.codingstreams.jwtauth.dto.*;

public interface HomePageService {
    HomePageResponseDto getHomePageResponse();

    HomePageResponseDto getFeatureResult(String id);

    OutsideMainArticleContent getFeatureArticles(Long id,boolean featureArticles,String type);

    NavBarDto getNavbar();
    
}
