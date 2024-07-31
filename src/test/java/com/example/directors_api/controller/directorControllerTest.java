package com.example.directors_api.controller;

import com.example.directors_api.service.MovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.awt.*;
import java.util.Arrays;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

@WebMvcTest(DirectorController.class)
public class directorControllerTest {

    @MockBean
    private MovieServiceImpl movieServiceImpl;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getDirectorsTest() throws Exception{
        when(movieServiceImpl.getDirectors(1)).thenReturn(Arrays.asList("Woody Alllen","Quentin Tarantino"));

        mockMvc.perform(get( "/api/directors?threshold=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[\"Woody Alllen\", \"Quentin Tarantino\"]"));

    }

    @Test
    public void getDirectorsTest_NoData() throws Exception{

        when(movieServiceImpl.getDirectors(1)).thenReturn(Arrays.asList());

        mockMvc.perform(get( "/api/directors?threshold=5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

    }

    @Test
    public void getDirectorsTest_Error() throws Exception{

        when(movieServiceImpl.getDirectors(1)).thenThrow(new RuntimeException("Service error"));

        mockMvc.perform(get( "/api/directors?threshold=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Service error"));

    }



}
