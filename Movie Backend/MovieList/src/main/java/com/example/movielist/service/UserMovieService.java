package com.example.movielist.service;

import com.example.movielist.domain.Movie;
import com.example.movielist.domain.User;

import java.util.List;

public interface UserMovieService {
    public abstract User addUser(User user);
    public abstract List<User> getAllUsers();
    public abstract User getUserDetails(String emailId);
    public abstract User addMovie(String emailId, Movie movie);
}
