package com.example.movielist.controller;

import com.example.movielist.domain.Movie;
import com.example.movielist.domain.User;
import com.example.movielist.service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@CrossOrigin // Annotation for allowing cross-origin requests
@RestController // Annotation indicating that this class is a REST controller in Spring framework
@RequestMapping("/movie") // Annotation for mapping the base URL for all the following methods
public class UserMovieController {
    private final UserMovieService userMovieService; // private field to store an instance of UserMovieService
    @Autowired // Annotation indicating that this field will be autowired by Spring framework
    public UserMovieController(UserMovieService userMovieService) {
        this.userMovieService = userMovieService;
    }
    // constructor to initialize the userMovieService field
    // http://localhost:8080/movie/add-user [POST]
    @PostMapping("add-user") // Annotation for mapping this method to handle POST requests to the '/movie/add-user' endpoint
    public ResponseEntity<?> addUser(@RequestBody User user){
        user.setMovies(new ArrayList<Movie>()); // Initialize the user's movies list
        return ResponseEntity.ok(userMovieService.addUser(user)); // calls the addUser method on userMovieService to add a new user and returns a response with the added user
    }
    // http://localhost:8080/movie/get-user-details [GET]
    @GetMapping("get-user-details") // Annotation for mapping this method to handle GET requests to the '/movie/get-user-details' endpoint
    public ResponseEntity<?> getUserDetails(HttpServletRequest request){
        String emailId = (String) request.getAttribute("current_user_emailid"); // Get the emailId of the current user from the request
        return ResponseEntity.ok(userMovieService.getUserDetails(emailId)); // calls the getUserDetails method on userMovieService to get a user with the emailId and returns a response with the user details
    }
    // http://localhost:8080/movie/add-movie-to-user [POST]
    @PostMapping("add-movie-to-user") // Annotation for mapping this method to handle POST requests to the '/movie/add-movie-to-user' endpoint
    public ResponseEntity<?> addMovie(@RequestBody Movie movie, HttpServletRequest request){
        String current_email = (String) request.getAttribute("current_user_emailid"); // Get the emailId of the current user from the request
        return ResponseEntity.ok(userMovieService.addMovie(current_email,movie)); // calls the addMovie method on userMovieService to add a movie to the current user's movies list and returns a response with the updated user
    }
}
