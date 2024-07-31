package com.example.directors_api.controller;

import com.example.directors_api.model.MovieResponse;
import com.example.directors_api.service.MovieServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DirectorController {

    private final MovieServiceImpl movieService;

    @Autowired
    public DirectorController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    /**
     * Endpoint to get a list of directors with more movies directed than the threshold.
     *
     * @param threshold the minimum number of movies directed by a director to be included in the response.
     * @return a list of directors.
     */
    @Operation(summary = "Get a list of movie by the threshold")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the list of movies",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Page not found",
                    content = @Content) })
    @GetMapping("/api/directors")
    public List<String> getDirectors(@RequestParam("threshold") int threshold) {
         return movieService.getDirectors(threshold);
    }
}
