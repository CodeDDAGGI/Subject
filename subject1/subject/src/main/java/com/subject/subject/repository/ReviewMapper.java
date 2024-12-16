package com.subject.subject.repository;

import com.subject.subject.dto.response.RespReviewDto;
import com.subject.subject.entity.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    int add(Review review);
    List<Review> getByMovieId(Long movieId);

}
