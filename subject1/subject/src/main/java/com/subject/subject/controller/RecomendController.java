package com.subject.subject.controller;

import com.subject.subject.service.RecomendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies/recomendations")
public class RecomendController {

    @Autowired
    private RecomendService recomendService;

    @GetMapping("/popular")
    public ResponseEntity<?> getPopularMovies(){
        return ResponseEntity.ok().body(recomendService.getPopularMovies());
    }

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestMovies(){
        return ResponseEntity.ok().body(recomendService.getLatestMovies());
    }
}
