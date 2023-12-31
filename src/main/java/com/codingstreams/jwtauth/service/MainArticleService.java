package com.codingstreams.jwtauth.service;

import com.codingstreams.jwtauth.dto.MainArticleDto;
import com.codingstreams.jwtauth.dto.PaginatedMainArticleDTO;
import com.codingstreams.jwtauth.model.MainArticleEntity;
import org.springframework.data.domain.Pageable;


public interface MainArticleService {
    void saveMainArticle(MainArticleDto mainArticleDTO);

//    Page<MainArticleEntity> findAll(Pageable pageable);

    PaginatedMainArticleDTO getAllMainArticles(Pageable pageable);

    PaginatedMainArticleDTO getMainArticlesByCategoryAndStatus(String category, Pageable pageable);

    MainArticleDto getFeaturedArticles(Long id);
}
