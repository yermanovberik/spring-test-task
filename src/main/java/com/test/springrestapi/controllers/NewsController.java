package com.test.springrestapi.controllers;

import com.test.springrestapi.dto.news.NewsRequestDTO;
import com.test.springrestapi.dto.news.NewsResponseDTO;
import com.test.springrestapi.services.NewsService;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/news")
public class NewsController {
    private final NewsService newsService;

    @GetMapping("/allNews")
    @ResponseStatus(HttpStatus.OK)
    public List<NewsResponseDTO> getAllNews(){
        return newsService.getAllNews();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public NewsResponseDTO createNews(
            @RequestBody NewsRequestDTO requestDTO
    ) {
        return newsService.createNews(requestDTO);
    }

}
