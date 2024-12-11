//package com.example.subject.controller;
//
//import com.subject.subject.controller.MovieController;
//import com.subject.subject.dto.request.ReqMovieRegisterDto;
//import com.subject.subject.entity.Movie;
//import com.subject.subject.service.MovieService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.ResponseEntity;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class MovieControllerTest {
//    @Mock
//    private MovieService movieService;
//
//    @InjectMocks
//    private MovieController movieController;
//
//    private ReqMovieRegisterDto movieRegisterDto;
//
//    @BeforeEach
//    public void setUp() {
//        movieRegisterDto = new ReqMovieRegisterDto();
//        movieRegisterDto.setTitle("Inception");
//        movieRegisterDto.setDirector("Christopher Nolan");
//        movieRegisterDto.setGenre("Sci-Fi");
//        movieRegisterDto.setReleaseDate("2010-07-16");
//    }
//
//    @Test
//    public void testRegisterMovie() {
//        // Arrange
//        when(movieService.registerMovie(any(ReqMovieRegisterDto.class))).thenReturn("Movie registered successfully");
//
//        // Act
//        ResponseEntity<?> response = movieController.registerMovie(movieRegisterDto);
//
//        // Assert
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals("Movie registered successfully", response.getBody());
//        verify(movieService, times(1)).registerMovie(any(ReqMovieRegisterDto.class));
//    }
//}
