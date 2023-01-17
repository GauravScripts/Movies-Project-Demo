package com.practice.UserAuthenticationService.service;

import com.practice.UserAuthenticationService.domain.User;
import com.practice.UserAuthenticationService.exception.UserAlreadyExistException;
import com.practice.UserAuthenticationService.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    User addUser(User user) throws UserAlreadyExistException;

    User findByUserIdAndPassword(int userId,String password) throws UserNotFoundException;

    List<User> getAllUser();

    boolean deleteUser(int userId) throws UserNotFoundException;
}
