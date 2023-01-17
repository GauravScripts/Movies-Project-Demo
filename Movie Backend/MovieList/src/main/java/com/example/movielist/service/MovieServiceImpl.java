package com.example.movielist.service;

import com.example.movielist.domain.Movie;
import com.example.movielist.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {
private final MovieRepository movieRepository;
@Autowired
public MovieServiceImpl(MovieRepository movieRepository) {
this.movieRepository = movieRepository;
}
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(String movieId) {
        return movieRepository.findById(movieId).get();
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.insert(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }


    @Override
    public boolean deleteMovie(String movieId) {
    movieRepository.deleteById(movieId);
    return true;
    }
}
