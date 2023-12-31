package com.codingstreams.jwtauth.service.Impl;

import com.codingstreams.jwtauth.dto.CtaDto;
import com.codingstreams.jwtauth.enums.DateFormat;
import com.codingstreams.jwtauth.dto.MainArticleDto;
import com.codingstreams.jwtauth.dto.MainArticleInsideDetailsDTO;
import com.codingstreams.jwtauth.dto.PaginatedMainArticleDTO;
import com.codingstreams.jwtauth.model.MainArticleEntity;
import com.codingstreams.jwtauth.model.MainArticleInsideDetailsEntity;
import com.codingstreams.jwtauth.model.SectionBar;
import com.codingstreams.jwtauth.repository.MainArticleRepository;
import com.codingstreams.jwtauth.repository.SectionBarRepository;
import com.codingstreams.jwtauth.service.MainArticleService;
import com.codingstreams.jwtauth.utill.DateUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class MainArticleServiceImpl implements MainArticleService {
    @Autowired
    private MainArticleRepository mainArticleRepository;

    @Autowired
    private SectionBarRepository sectionBarRepository;

    @Override
    public void saveMainArticle(MainArticleDto mainArticleDTO) {
        MainArticleEntity mainArticleEntity = new MainArticleEntity();
        BeanUtils.copyProperties(mainArticleDTO, mainArticleEntity);
        mainArticleEntity.setCreatedAt(new Date());


        if (mainArticleDTO.getMainArticleInsideDetails() != null) {
            for (MainArticleInsideDetailsDTO detailsDTO : mainArticleDTO.getMainArticleInsideDetails()) {
                MainArticleInsideDetailsEntity details = new MainArticleInsideDetailsEntity();
                BeanUtils.copyProperties(detailsDTO, details);
                details.setMainArticleEntity(mainArticleEntity);
                mainArticleEntity.getMainArticleInsideDetails().add(details);
            }
        }

        mainArticleRepository.save(mainArticleEntity);

    }

    @Override
    public PaginatedMainArticleDTO getAllMainArticles(Pageable pageable) {
        Page<MainArticleEntity> mainArticlePage = mainArticleRepository.findAll(pageable);

        return returnPaginatedResponse(mainArticlePage,true);
    }

    public PaginatedMainArticleDTO returnPaginatedResponse(Page<MainArticleEntity> mainArticlePage,boolean isSectionBarRequired){



        List<MainArticleDto> mainArticleDTOList = mainArticlePage
                .map(this::convertToDTO)
                .getContent();
        List<CtaDto> ctaDtoList = new ArrayList<>();

       if(isSectionBarRequired) {
           List<SectionBar> sectionBar = sectionBarRepository.findByStatus(true);
           List<SectionBar> sortedSectionBar = sectionBar.stream()
                   .sorted(Comparator.comparingLong(SectionBar::getPriority))
                   .toList();


           sortedSectionBar.forEach(sectionBar1 -> {
               ctaDtoList.add(CtaDto.builder().title(sectionBar1.getTitle()).hrefLink(sectionBar1.getRedirectionLink()).type(sectionBar1.getType())
                       .build());

           });
       }

        return PaginatedMainArticleDTO.builder().content(mainArticleDTOList).totalElements(mainArticlePage.getTotalElements()).totalPages(mainArticlePage.getTotalPages())
                .ctaDtoList(ctaDtoList)
                .title("Blog template using Next Js, Typescript and Taildwind CSS. rrrrrrrr")
                .subTitle("This is a simple and static component based blog template for everyone testing.").build();

    }

    @Override
    public PaginatedMainArticleDTO getMainArticlesByCategoryAndStatus(String category, Pageable pageable) {
        Page<MainArticleEntity> mainArticlePage = mainArticleRepository.findByCategoryAndStatus(category,true,pageable);

        return returnPaginatedResponse(mainArticlePage,false);
    }

    @Override
    public MainArticleDto getFeaturedArticles(Long id) {
        MainArticleEntity mainArticlePage = mainArticleRepository.findByIdAndFeatureArticleAndStatus(id,true,true);
        if(Objects.isNull(mainArticlePage)){
            throw new RuntimeException("no video found");
        }
        MainArticleDto mainArticleDto = convertToDTO(mainArticlePage);

        mainArticleDto.setTitle("welcome to this section");
        mainArticleDto.setDescription("See all the page component");

        return mainArticleDto;
    }

    private MainArticleDto convertToDTO(MainArticleEntity mainArticleEntity) {
        ModelMapper modelMapper = new ModelMapper();
        MainArticleDto mainArticleDTO = modelMapper.map(mainArticleEntity, MainArticleDto.class);

        if(Objects.nonNull(mainArticleEntity) && Objects.nonNull(mainArticleEntity.getCreatedAt())){
            mainArticleDTO.setCreatedAt(DateUtil.customDateFormatter(mainArticleEntity.getCreatedAt(), DateFormat.DD_MMM_YY1));
        }




        // Convert MainArticleInsideDetails entities to DTOs
        List<MainArticleInsideDetailsDTO> detailsDTOList = mainArticleEntity.getMainArticleInsideDetails()
                .stream()
                .map(details -> modelMapper.map(details, MainArticleInsideDetailsDTO.class))
                .collect(Collectors.toList());

        mainArticleDTO.setMainArticleInsideDetails(detailsDTOList);

        return mainArticleDTO;
    }
}
