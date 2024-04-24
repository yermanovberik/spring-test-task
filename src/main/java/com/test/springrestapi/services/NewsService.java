package com.test.springrestapi.services;

import com.test.springrestapi.dto.news.NewsRequestDTO;
import com.test.springrestapi.dto.news.NewsResponseDTO;

import java.util.List;

public interface NewsService {
    NewsResponseDTO createNews(NewsRequestDTO requestDTO);
    List<NewsResponseDTO> getAllNews();
}