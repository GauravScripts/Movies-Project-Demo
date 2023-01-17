package com.stackroute.auth.authapp.service;

import com.stackroute.auth.authapp.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String, String> generateToken(User user);
}
