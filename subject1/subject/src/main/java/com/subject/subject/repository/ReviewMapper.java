package com.subject.subject.repository;

import com.subject.subject.dto.response.RespReviewDto;
import com.subject.subject.entity.Review;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    Review insertReview(Review review);
    RespReviewDto getReviewsByMovieId(Long movieId);
}
