package com.practice.UserAuthenticationService.repository;

import com.practice.UserAuthenticationService.domain.User;
import com.practice.UserAuthenticationService.exception.UserNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserIdAndPassword(int userId,String password) throws UserNotFoundException;
}
