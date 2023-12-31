package com.codingstreams.jwtauth.service.Impl;

import com.codingstreams.jwtauth.dto.*;
import com.codingstreams.jwtauth.model.MainArticleEntity;
import com.codingstreams.jwtauth.model.MainArticleInsideDetailsEntity;
import com.codingstreams.jwtauth.model.SectionBar;
import com.codingstreams.jwtauth.repository.MainArticleRepository;
import com.codingstreams.jwtauth.repository.SectionBarRepository;
import com.codingstreams.jwtauth.service.HomePageService;
import io.micrometer.common.util.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j2
public class HomePageServiceImpl implements HomePageService {
   @Autowired
    private SectionBarRepository sectionBarRepository;

    @Autowired
    private MainArticleRepository mainArticleRepository;
    @Override
    public HomePageResponseDto getHomePageResponse() {

        List<CtaDto> ctaDtoList = new ArrayList<>();


        List<SectionBar> sectionBar  = sectionBarRepository.findByStatus(true);
        List<SectionBar> sortedSectionBar = sectionBar.stream()
                .sorted(Comparator.comparingLong(SectionBar::getPriority))
                .toList();


                sortedSectionBar.forEach(sectionBar1 -> {
            ctaDtoList.add(CtaDto.builder().title(sectionBar1.getTitle()).hrefLink(sectionBar1.getRedirectionLink()).type(sectionBar1.getType())
                    .build());

        });


         List<Articles> articlesList = new ArrayList<>();

        articlesList.add(Articles.builder().title("How to setup this blog template").subTitle("These are the steps to setup your blog ...")
                        .topHeader("Amit in blog").description("# demo").date("August 09 2023").imageUrl("https://res.cloudinary.com/dnfbe0pcx/image/upload/v1701634871/maths_aq0pk7.jpg")
                .build());

        articlesList.add(Articles.builder().title("How tdsfdsfdsfdso setup this blog template").subTitle("These are the steps to setup your blog ...")
                .topHeader("Amit in blog").description("# demo").date("August 09 2023").imageUrl("https://res.cloudinary.com/dnfbe0pcx/image/upload/v1701634871/maths_aq0pk7.jpg")
                .build());

        List<Articles> articlesListforFooter = new ArrayList<>();

        articlesListforFooter.add(Articles.builder().title("How to setup this blog template").subTitle("These are the steps to setup your blog ...")
                .topHeader("Amit in blog").description("# demo").date("August 09 2023").imageUrl("https://res.cloudinary.com/dnfbe0pcx/image/upload/v1701634871/maths_aq0pk7.jpg")
                .build());

        articlesListforFooter.add(Articles.builder().title("How tdsfdsfdsfdso setup this blog template").subTitle("These are the steps to setup your blog ...")
                .topHeader("Amit in blog").description("# demo").date("August 09 2023").imageUrl("https://res.cloudinary.com/dnfbe0pcx/image/upload/v1701634871/maths_aq0pk7.jpg")
                .build());

        articlesListforFooter.add(Articles.builder().title("How to setup this blog template").subTitle("These are the steps to setup your blog ...")
                .topHeader("Amit in blog").description("# demo").date("August 09 2023").imageUrl("https://res.cloudinary.com/dnfbe0pcx/image/upload/v1701634871/maths_aq0pk7.jpg")
                .build());

        articlesListforFooter.add(Articles.builder().title("How tdsfdsfdsfdso setup this blog template").subTitle("These are the steps to setup your blog ...")
                .topHeader("Amit in blog").description("# demo").date("August 09 2023").imageUrl("https://res.cloudinary.com/dnfbe0pcx/image/upload/v1701634871/maths_aq0pk7.jpg")
                .build());

        articlesListforFooter.add(Articles.builder().title("How to setup this blog template").subTitle("These are the steps to setup your blog ...")
                .topHeader("Amit in blog").description("# demo").date("August 09 2023").imageUrl("https://res.cloudinary.com/dnfbe0pcx/image/upload/v1701634871/maths_aq0pk7.jpg")
                .build());

        articlesListforFooter.add(Articles.builder().title("How tdsfdsfdsfdso setup this blog template").subTitle("These are the steps to setup your blog ...")
                .topHeader("Amit in blog").description("# demo").date("August 09 2023").imageUrl("https://res.cloudinary.com/dnfbe0pcx/image/upload/v1701634871/maths_aq0pk7.jpg")
                .build());



        return HomePageResponseDto.builder().title("Blog template using Next Js, Typescript and Taildwind CSS. testing")
                .subTitle("This is a simple and static component based blog template for everyone testing.")
//                .headorResponseDto(HeadorResponseDto.builder().title("Featured Article").articlesList(articlesList).build())
//                .footerResponseDto(HeadorResponseDto.builder().title("Featured Article").articlesList(articlesListforFooter).build())
                .ctaDtoList(ctaDtoList).build();
    }

    @Override
    public HomePageResponseDto getFeatureResult(String uuid) {

        log.info("sdf {}",uuid);
        return null;
    }

    @Override
    public OutsideMainArticleContent getFeatureArticles(Long id,boolean featureArticles,String articleType) {


//        MainArticleEntity mainArticlePage = mainArticleRepository.findByIdAndFeatureArticleAndStatus(id,featureArticles,true); // commenting for now

        MainArticleEntity mainArticlePage = mainArticleRepository.findByIdAndStatus(id,true);

        if(Objects.isNull(mainArticlePage)){
            return OutsideMainArticleContent.builder().contents(new ArrayList<>()).build();
        }

        List<MainArticleInsideDetailsEntity> mainArticleInsideDetails = mainArticlePage.getMainArticleInsideDetails();

        HashMap<String,  List<MainArticleInsideDetailsEntity>> hashMapMainArticleEntity = new HashMap<>();

        mainArticleInsideDetails.forEach(mainArticleInsideDetailsEntity -> {
            String type = mainArticleInsideDetailsEntity.getType();
            hashMapMainArticleEntity.computeIfAbsent(type, k -> new ArrayList<>()).add(mainArticleInsideDetailsEntity);
        });


        List<MainArticlesContent> mainArticlesContentList=new ArrayList<>();
        for (Map.Entry<String, List<MainArticleInsideDetailsEntity>> entry : hashMapMainArticleEntity.entrySet()) {
            String key = entry.getKey();
            List<MainArticleInsideDetailsEntity> value = entry.getValue();

            System.out.println("Type: " + key);
            List<ImageDto> imageDtos= new ArrayList<>();

            MainArticlesContent mainArticlesContent = MainArticlesContent.builder().build();
            InsideMainArticleContent insideMainArticleContent = new InsideMainArticleContent();

            // Iterate over the list of MainArticleInsideDetailsEntity
            for (MainArticleInsideDetailsEntity entity : value) {
                // Do something with each entity
                System.out.println("  Entity: " + entity.toString());

                if(StringUtils.isNotEmpty(entity.getImage()))
                imageDtos.add(ImageDto.builder().imageUrl(entity.getImage()).build());

                mainArticlesContent.setHref(entity.getHref());
                mainArticlesContent.setSideBarTitle(entity.getTitle());
                insideMainArticleContent.setTitle(entity.getTitle());
                insideMainArticleContent.setType(entity.getType());
                insideMainArticleContent.setDescription(entity.getDescription());
                insideMainArticleContent.setVideoUrl(entity.getVideo());

            }
            insideMainArticleContent.setImageDto(imageDtos);
            mainArticlesContent.setInsideMainArticleContent(insideMainArticleContent);

            mainArticlesContentList.add(mainArticlesContent);

        }

        return OutsideMainArticleContent.builder().title(mainArticlePage.getTitle()).subTitle(mainArticlePage.getSubTitle()).description(mainArticlePage.getDescription()).contents(mainArticlesContentList).build();

//        return mainArticlesContentList;
    }

    @Override
    public NavBarDto getNavbar() {
        List<CtaDto>ctaDtoList = new ArrayList<>();

        ctaDtoList.add(CtaDto.builder().title("Home").hrefLink("/").build());
        ctaDtoList.add(CtaDto.builder().title("About Us").hrefLink("/about-us").build());
        ctaDtoList.add(CtaDto.builder().title("Contact Us").hrefLink("/contact-us").build());
//        ctaDtoList.add(CtaDto.builder().title("Join Us").hrefLink("/join").type("JOIN").build());

        NavBarDto.builder().ctaDtoList(ctaDtoList);
        return NavBarDto.builder().ctaDtoList(ctaDtoList).build();
    }
}
