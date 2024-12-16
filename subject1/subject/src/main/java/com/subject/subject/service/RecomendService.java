package com.subject.subject.service;

import com.subject.subject.dto.response.RespLatestDto;
import com.subject.subject.dto.response.RespPopularDto;
import com.subject.subject.entity.Movie;
import com.subject.subject.entity.Review;
import com.subject.subject.repository.RecommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendService {
    @Autowired
    private RecommendMapper recommendMapper;

    public List<RespPopularDto>getPopularMovies() {
        List<Movie> popularMovies = recommendMapper.getPopularMovies();
        return popularMovies.stream().map(movie -> RespPopularDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .avgRating(movie.getAvgRating())
                .reviewCount(movie.getReviewCount())
                .build()).toList();
    }

    public List<RespLatestDto> getLatestMovies (){
        List<Movie> latestMovies = recommendMapper.getLatestMovies();
        return latestMovies.stream().map(movie -> RespLatestDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .release_date(movie.getRelease_date())
                .build()).toList();
    }
}