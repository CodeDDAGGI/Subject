package com.subject.subject.repository;

import com.subject.subject.entity.Movie;
import com.subject.subject.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieMapper {
    int registerMovie(Movie movie);
    User findByTitle(String title);
    int existsDuplicate(Movie movie);
    List<Movie> findByMovie(@Param("title") String title,@Param("genre") String genre);
}
