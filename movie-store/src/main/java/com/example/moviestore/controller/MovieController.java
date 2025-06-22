package com.example.moviestore.controller;

import com.example.moviestore.model.Movie;
import com.example.moviestore.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public String listMovies(@RequestParam(required = false) String category, Model model) {
        List<Movie> movies = (category != null) ? service.getByCategory(category) : service.getAll();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/{id}")
    public String movieDetails(@PathVariable Long id, Model model) {
        Movie movie = service.getById(id);
        model.addAttribute("movie", movie);
        return "movie-details";
    }
}