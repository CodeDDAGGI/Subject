package com.subject.subject.service;

import com.subject.subject.dto.response.RespReviewDto;
import com.subject.subject.entity.Movie;
import com.subject.subject.entity.Review;
import com.subject.subject.repository.MovieMapper;
import com.subject.subject.repository.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private MovieMapper movieMapper;

    @Transactional(rollbackFor = Exception.class)
    public RespReviewDto registerReview(Review review) {
        Movie movie = movieMapper.getMovie(review.getMovieId());
        if(movie == null){
           throw new RuntimeException("Movie not found");
        }
        reviewMapper.add(review);
        return RespReviewDto.builder()
                .message("Review registered successfully")
                .build();
    }

    public List<Review> getReviews(Long movieId) {

        return reviewMapper.getByMovieId(movieId);
    }
}
