package com.subject.subject.controller;

import com.subject.subject.dto.request.ReqMovieRegisterDto;
import com.subject.subject.dto.request.ReqReviewDto;
import com.subject.subject.dto.response.RespMovieListDto;
import com.subject.subject.entity.Movie;
import com.subject.subject.entity.Review;
import com.subject.subject.service.MovieService;
import com.subject.subject.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/movies")
    public ResponseEntity<?> registerMovie(@RequestBody ReqMovieRegisterDto dto){
        System.out.println(dto);
        return ResponseEntity.ok().body(movieService.registerMovie(dto));
    }

    @GetMapping("/movies")
    public ResponseEntity<?> getMovies(@RequestParam(value="title", required = false) String title,
                                       @RequestParam(value="genre", required = false) String genre){
        List<Movie> movies = movieService.getMovies(title, genre);
        System.out.println("영화" + movies);
        return ResponseEntity.ok().body(movies);
    }

    @PostMapping("/movies/{movieId}/reviews")
    public ResponseEntity<?> registerReview(@PathVariable Long movieId , @RequestBody ReqReviewDto dto){
        Review review = Review.builder()
                .movieId(movieId)
                .userId(dto.getUserId())
                .content(dto.getContent())
                .rating(dto.getRating())
                .build();

        return ResponseEntity.ok().body(reviewService.registerReview(review));
    }

    @GetMapping("/movies/{movieId}/reviews")
    public ResponseEntity<?> getReviews(@PathVariable Long movieId){
        List<Review> reviews = reviewService.getReviews(movieId);
        return ResponseEntity.ok().body(reviews);
    }

    @GetMapping("/movies/pages")
    public ResponseEntity<?> getMoviesByPage(
            @RequestParam(value="page", required = false) int page,
            @RequestParam(value="size", required = false) int size){
        RespMovieListDto movies = movieService.getMoviesByPage(page,size);
        return ResponseEntity.ok().body(movies);
    }

}
