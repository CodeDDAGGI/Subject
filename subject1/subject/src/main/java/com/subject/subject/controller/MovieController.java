package com.subject.subject.controller;

import com.subject.subject.dto.request.ReqMovieRegisterDto;
import com.subject.subject.dto.request.ReqReviewDto;
import com.subject.subject.dto.response.RespReviewDto;
import com.subject.subject.entity.Movie;
import com.subject.subject.entity.Review;
import com.subject.subject.entity.User;
import com.subject.subject.service.MovieService;
import com.subject.subject.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/movies")
    public ResponseEntity<?> registerMovie(ReqMovieRegisterDto dto){
        return ResponseEntity.ok().body(movieService.registerMovie(dto));
    }

    @GetMapping("/movies")
    public ResponseEntity<?> getMovies(@RequestParam(value="title", required = false) String title,
                                       @RequestParam(value="genre", required = false) String genre){
        List<Movie> movies = movieService.getMovies(title, genre);
        return ResponseEntity.ok().body(movies);
    }

    @PostMapping("/movies/{movieId}/reviews")
    public ResponseEntity<?> registerReview(@PathVariable Long movieId , @RequestBody ReqReviewDto dto){
        Review review = Review.builder()
                .movieId(movieId)
                .content(dto.getContent())
                .rating(dto.getRating())
                .build();

        return ResponseEntity.ok().body(reviewService.registerReview(review));
    }

    @GetMapping("/movies/{movieId}/reviews")
    public ResponseEntity<?> getReviews(@PathVariable Long movieId){
        RespReviewDto reviews = reviewService.getReviews(movieId);
        return ResponseEntity.ok().body(reviews);
    }
}
