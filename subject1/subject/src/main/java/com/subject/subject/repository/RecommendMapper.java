package com.subject.subject.repository;

import com.subject.subject.dto.response.RespRecommendDto;
import com.subject.subject.entity.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommendMapper {

    List<RespRecommendDto> getPopularMovies();
    List<Movie> getLatestMovies();
}
