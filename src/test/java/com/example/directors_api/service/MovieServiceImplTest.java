package com.example.directors_api.service;

import com.example.directors_api.client.MovieClient;
import com.example.directors_api.exceptions.MovieException;
import com.example.directors_api.model.Movie;
import com.example.directors_api.model.MovieResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.description;
import static org.mockito.Mockito.when;

public class MovieServiceImplTest {

    @Mock
    private MovieClient movieClient;

    @InjectMocks
    private MovieServiceImpl movieServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void GetDirectorsTest(){
        Movie movie1=new Movie("What's Up, Tiger Lily?","1966","5","1967","1:30:20","Comedy","Woody Allen","Woody Allen","A lot of actors");
        Movie movie2=new Movie("WBullets Over Broadway","1994","5","1996","1:50:20","Drama","Woody Allen","Woody Allen","A lot of actors");
        Movie movie3=new Movie("Kill Bill","2004","5","2005","1:58:20","Fiction","Quentin Tarantino","Quentin Tarantino","A lot of actors");
        Movie movie4=new Movie("DJango","2012","5","2012","2:40:20","Drama","Quentin Tarantino","Quentin Tarantino","A lot of actors");
        Movie movie5=new Movie("Once Upon a Time in Hollywood","2019","5","2019","1:50:30","Comedy","Quentin Tarantino","Quentin Tarantino","A lot of actors");
        Movie movie6=new Movie("Kill Bill 2","2004","5","2004","1:30:20","Drama","Quentin Tarantino","Quentin Tarantino","A lot of actors");

        List<Movie> moviesList = new ArrayList<>();
        moviesList.add(movie1);
        moviesList.add(movie2);
        moviesList.add(movie3);
        moviesList.add(movie4);
        moviesList.add(movie5);
        moviesList.add(movie6);

        MovieResponse movieResponse=new MovieResponse(1,10,6,1,moviesList);

        when(movieClient.getMovies(1)).thenReturn(movieResponse);

        List<String> directorsResponse=movieServiceImpl.getDirectors(1);

        assertNotNull(directorsResponse);
        assertEquals(2, directorsResponse.size());
        assertEquals(Arrays.asList("Quentin Tarantino","Woody Allen"), directorsResponse);
    }

    @Test
    public void GetDirectorsTest_Exception(){
        when(movieClient.getMovies(1)).thenReturn(null);

        MovieException exception = assertThrows(MovieException.class, () -> {
            movieServiceImpl.getDirectors(1);
        });

        assertEquals("Error trying to get or process data", exception.getMessage());

    }

}
