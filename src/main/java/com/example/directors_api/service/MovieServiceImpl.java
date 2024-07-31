package com.example.directors_api.service;

import com.example.directors_api.client.MovieClient;
import com.example.directors_api.exceptions.MovieException;
import com.example.directors_api.model.Movie;
import com.example.directors_api.model.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieClient movieClient;


    @Autowired
    public MovieServiceImpl(MovieClient movieClient) {
        this.movieClient = movieClient;
    }


    public List<String> getDirectors(int threshold) {
        try {
            int pageNumber = 1;
            MovieResponse response = movieClient.getMovies(pageNumber);
            if(response == null || response.getData()==null){
                throw new MovieException("No data from the API movie");
            }

            List<Movie> movies = response.getData();

            Map<String, Long> directorMovies = movies
                    .stream()
                    .filter(movie -> movie.getDirector() != null)
                    .collect(Collectors.groupingBy(Movie::getDirector, Collectors.counting()));

            return directorMovies.entrySet().stream()
                    .filter(entry -> entry.getValue() > threshold)
                    .map(Map.Entry::getKey)
                    .sorted()
                    .collect(Collectors.toList());

        }catch (Exception e){
            throw new MovieException("Error trying to get or process data",e);
        }
    }
}
