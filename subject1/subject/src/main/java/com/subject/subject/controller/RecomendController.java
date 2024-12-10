package com.subject.subject.controller;

import com.subject.subject.dto.response.RespRecommendDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecomendController {

    @GetMapping("/movies/recomendations/popular")
    public ResponseEntity<?> getPopularMovies(RespRecommendDto dto){
        return ResponseEntity.ok().body("popular movies");
    }
}
