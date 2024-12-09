package com.subject.subject.dto.request;

import com.subject.subject.entity.Movie;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class ReqMovieRegisterDto {
    private String title;
    private String director;
    private String genre;
    private String releaseDate;

    public Movie toEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate = LocalDate.parse(releaseDate, formatter);
        return Movie.builder()
                .title(title)
                .director(director)
                .genre(genre)
                .releaseDate(parsedDate)
                .build();
    }
}
