package com.subject.subject.service;

import com.subject.subject.dto.response.RespReviewDto;
import com.subject.subject.entity.Review;
import com.subject.subject.repository.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public RespReviewDto registerReview(Review review) {
        reviewMapper.insertReview(review);
        return RespReviewDto.builder()
                .message("Review registered successfully")
                .build();
    }

    public RespReviewDto getReviews(int movieId) {
        return reviewMapper.getReviewsByMovieId(movieId);

    }
}
