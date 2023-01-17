package com.example.movielist.service;
// package declaration specifying the package in which the class is located

import com.example.movielist.domain.Movie;
import com.example.movielist.domain.User;
import com.example.movielist.repository.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// importing necessary classes from other packages

import java.util.List;

@Service // Annotation indicating that this class is a Service class in Spring framework
public class UserMovieServiceImpl implements UserMovieService {

    private final UserMovieRepository userMovieRepository; // private field to store an instance of UserMovieRepository

    @Autowired // Annotation indicating that this field will be autowired by Spring framework
    public UserMovieServiceImpl(UserMovieRepository userMovieRepository) {
        this.userMovieRepository = userMovieRepository;
    }
// constructor to initialize the userMovieRepository field

    @Override // Annotation indicating that this method overrides a method from the UserMovieService interface
    public User addUser(User user) {
        return userMovieRepository.insert(user); // calls the insert method on userMovieRepository to add a new user
    }

    @Override
    public List<User> getAllUsers() {
        return userMovieRepository.findAll(); // calls the findAll method on userMovieRepository to get a list of all users
    }

    @Override
    public User getUserDetails(String emailId) {
        return userMovieRepository.findById(emailId).get(); // calls the findById method on userMovieRepository to get a user with a specific emailId
    }

    @Override // Annotation indicating that this method overrides a method from the UserMovieService interface
    public User addMovie(String emailId, Movie movie) {
        User user = userMovieRepository.findById(emailId).get(); // find user by emailId
        user.getMovies().add(movie); // add movie to the user's movies list
        return userMovieRepository.save(user); // save the updated user object
    }
}