package com.example.movielist.service;

import com.example.movielist.domain.Movie;

import java.util.List;

public interface MovieService {
    public abstract List<Movie> getAllMovies();
    public abstract Movie getMovieById(String movieId);
    public abstract Movie addMovie(Movie movie);
    public abstract Movie updateMovie( Movie movie);
    public abstract boolean deleteMovie(String movieId);
}
