package com.test.springrestapi.services.impl;

import com.test.springrestapi.dto.news.NewsRequestDTO;
import com.test.springrestapi.dto.news.NewsResponseDTO;
import com.test.springrestapi.models.News;
import com.test.springrestapi.repositories.NewsRepository;
import com.test.springrestapi.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    @Override
    public NewsResponseDTO createNews(NewsRequestDTO requestDTO) {
        News news = News.builder()
                .body(requestDTO.body())
                .title(requestDTO.title())
                .build();

        newsRepository.save(news);

        NewsResponseDTO responseDTO = NewsResponseDTO.builder()
                .title(news.getTitle())
                .body(news.getBody())
                .build();
        return responseDTO;
    }

    @Override
    public List<NewsResponseDTO> getAllNews() {
        List<NewsResponseDTO> newsResponseDTOList = new ArrayList<>();

        List<News> news = newsRepository.findAll();

        for(News allNews : news){
            NewsResponseDTO responseDTO = NewsResponseDTO.builder()
                    .title(allNews.getTitle())
                    .body(allNews.getBody())
                    .build();

            newsResponseDTOList.add(responseDTO);
        }

        return newsResponseDTOList;
    }
}
