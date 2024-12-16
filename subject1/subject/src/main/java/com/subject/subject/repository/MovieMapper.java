package com.subject.subject.repository;

import com.subject.subject.entity.Movie;
import com.subject.subject.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieMapper {
    int registerMovie(Movie movie);
    Movie getMovie(Long movieId);
    Movie existsDuplicate(Movie movie);
    List<Movie> findByMovie(@Param("title") String title,@Param("genre") String genre);
    List<Movie> findByPage(@Param("page") int page, @Param("size") int size);
    int countMovies();
}
