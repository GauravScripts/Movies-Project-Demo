package com.stackroute.auth.authapp.service;

import com.stackroute.auth.authapp.model.SignupData;
import com.stackroute.auth.authapp.model.User;

import java.util.Map;

public interface UserService {
    public abstract User registerUser1(SignupData signupData);
    public abstract User registerUser(User user);
    public abstract User loginCheck(User user);
}



