package com.subject.subject.repository;

import com.subject.subject.dto.response.RespPopularDto;
import com.subject.subject.entity.Movie;
import com.subject.subject.entity.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommendMapper {

    List<Movie> getPopularMovies();
    List<Movie> getLatestMovies();
}
