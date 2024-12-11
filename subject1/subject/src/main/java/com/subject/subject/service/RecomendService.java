package com.subject.subject.service;

import com.subject.subject.dto.response.RespRecommendDto;
import com.subject.subject.entity.Movie;
import com.subject.subject.repository.RecommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendService {
    @Autowired
    private RecommendMapper recommendMapper;

    public List<RespRecommendDto>getPopularMovies() {

        return recommendMapper.getPopularMovies();
    }

    public List<Movie> getLatestMovies (){
        return recommendMapper.getLatestMovies();
    }
}
