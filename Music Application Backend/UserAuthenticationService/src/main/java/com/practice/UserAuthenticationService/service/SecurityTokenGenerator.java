package com.practice.UserAuthenticationService.service;

import com.practice.UserAuthenticationService.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {

    Map<String,String> generateToken(User user);
}
