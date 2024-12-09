package com.subject.subject.controller;

import com.subject.subject.dto.request.ReqMovieRegisterDto;
import com.subject.subject.dto.response.RespMovieRegisterDto;
import com.subject.subject.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/movies")
    public ResponseEntity<?> registerMovie(ReqMovieRegisterDto dto){
        return ResponseEntity.ok().body(movieService.registerMovie(dto));
    }

    @GetMapping("/movies")
    public ResponseEntity<?> getMovies(@RequestParam(value="title", required = false) String title,
                                       @RequestParam(value="genre", required = false) String genre){
        List<RespMovieRegisterDto> movies = movieService.getMovies(title, genre);
        return ResponseEntity.ok().body(movies);
    }
}
