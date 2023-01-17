package com.example.movielist.repository;
import com.example.movielist.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMovieRepository extends MongoRepository<User, String> {
}
