package com.example.directors_api.client;

import com.example.directors_api.config.FeignConfiguration;
import com.example.directors_api.model.MovieResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient(name = "movieClient", url = "${movies.api.url}", configuration = FeignConfiguration.class)
public interface MovieClient {

    //@GetMapping("/api/movies/search")
    /**
     * Method  to get a list of movies from the EndPoint by page.
     *
     * @param page to get a list of movies.
     * @return a MovieResponse Object
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/movies/search",consumes = "application/json",  produces = "application/json")
    MovieResponse getMovies(@RequestParam("page") int page);
}
