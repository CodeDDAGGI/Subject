package com.subject.subject.dto.response;

import com.subject.subject.entity.Movie;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RespMovieListDto {
    private List<Movie> movies;
    private Integer totalCount;
}
