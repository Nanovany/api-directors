package com.example.directors_api.dto;

import com.example.directors_api.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ResponseEnd {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Movie> data;

}
