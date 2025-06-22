package com.example.moviestore.service;

import com.example.moviestore.model.Movie;
import com.example.moviestore.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> getAll() {
        return repository.findAll();
    }

    public List<Movie> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    public Movie getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}