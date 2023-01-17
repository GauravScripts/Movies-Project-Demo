package com.example.movielist.controller;

import com.example.movielist.domain.Movie;
import com.example.movielist.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieControler {
    private final MovieService movieService;
    @Autowired
    public MovieControler(MovieService movieService) {
        this.movieService = movieService;
    }
    // http://localhost:8080/movie/get-all-movies [GET]
    @GetMapping("/get-all-movies")
    public ResponseEntity<?> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }
    // http://localhost:8080/movie/get-movie-by-id/XXXXX [GET]
    @GetMapping("/get-movie-by-id/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable String movieId){
        return ResponseEntity.ok(movieService.getMovieById(movieId));
    }
    // http://localhost:8080/movie/admin/add-new-movie [POST]
    @PostMapping("/admin/add-new-movie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.addMovie(movie));
    }
    // http://localhost:8080/movie/admin/update-movie [PUT]
    @PutMapping("/admin/update-movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.updateMovie(movie));
    }
    // http://localhost:8080/movie/admin/delete-movie/XXXXX [DELETE]
    @DeleteMapping("/admin/delete-movie/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable String movieId){
        return ResponseEntity.ok(movieService.deleteMovie(movieId));
    }
}
