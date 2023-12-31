package com.codingstreams.jwtauth.controller;

import com.codingstreams.jwtauth.dto.MainArticleDto;
import com.codingstreams.jwtauth.dto.PaginatedMainArticleDTO;
import com.codingstreams.jwtauth.service.MainArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MainController {
   @Autowired
    private  MainArticleService mainArticleService;
    @GetMapping("/")
    public String availableToAll() {
        return "I'm publicly accessed by everyone.";
    }

    @GetMapping("/user")
    public String availableToAuthenticated() {
        return "I'm only accessible by authenticated users.";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin")
    public String availableToAdmin() {
        return "I'm only accessible by admin.";
    }

    @Secured({"ROLE_EDITOR", "ROLE_ADMIN"})
    @GetMapping("/editor")
    public String editor(){
        return "I'm only accessible by editor and admin.";
    }

    @PostMapping("/api/main-articles/save")
    public ResponseEntity<String> saveMainArticle(@RequestBody MainArticleDto mainArticleDTO) {
        mainArticleService.saveMainArticle(mainArticleDTO);
        return new ResponseEntity<>("Main article saved successfully", HttpStatus.CREATED);
    }


}
