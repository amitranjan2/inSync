package com.codingstreams.jwtauth.repository;

import com.codingstreams.jwtauth.model.MainArticleEntity;
import com.codingstreams.jwtauth.model.SectionBar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository
public interface MainArticleRepository extends AbstractJpaRepository<MainArticleEntity, Long>{
    Page<MainArticleEntity> findAll(Pageable pageable);

    Page<MainArticleEntity> findByStatus(boolean status, Pageable pageable);

    Page<MainArticleEntity> findByStatusAndFeatureArticle(boolean status, boolean featureArticle, Pageable pageable);



    MainArticleEntity findByIdAndFeatureArticleAndStatus(Long id, boolean featureArticle, boolean status);
    MainArticleEntity  findByIdAndStatus(Long id,  boolean status);

    Page<MainArticleEntity> findByCategoryAndStatus(String category, boolean status, Pageable pageable);







}
