package com.example.directors_api.service;

import java.util.List;

public interface MovieService {
    List<String> getDirectors(int threshold);
}
