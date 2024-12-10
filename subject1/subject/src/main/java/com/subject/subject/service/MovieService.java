package com.subject.subject.service;

import com.subject.subject.dto.request.ReqMovieRegisterDto;
import com.subject.subject.dto.response.RespMovieRegisterDto;
import com.subject.subject.entity.Movie;
import com.subject.subject.repository.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieMapper movieMapper;

    public RespMovieRegisterDto registerMovie(ReqMovieRegisterDto dto){
        int FindMovie = 0;
        FindMovie = movieMapper.existsDuplicate(dto.toEntity());

        if(FindMovie > 0){
            return RespMovieRegisterDto.builder()
                    .message("Movie already exists")
                    .build();
        }else {
            movieMapper.registerMovie(dto.toEntity());
            return RespMovieRegisterDto.builder()
                    .message("Movie registered successfully")
                    .build();
        }
    }

    public List<Movie> getMovies(String title, String genre){
        return movieMapper.findByMovie(title, genre);
    }
}
