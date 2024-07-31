package com.example.directors_api.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieResponse {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    @NotBlank
    private List<Movie> data;
}
