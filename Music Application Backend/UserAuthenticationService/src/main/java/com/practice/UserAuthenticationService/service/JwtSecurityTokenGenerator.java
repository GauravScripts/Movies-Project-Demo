package com.practice.UserAuthenticationService.service;

import com.practice.UserAuthenticationService.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTokenGenerator implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken = null;

        jwtToken = Jwts.builder()
                .setSubject(String.valueOf(user.getUserId()))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"mykey").compact();

        Map<String,String> map = new HashMap<>();
        map.put("user_role",user.getRole());
        map.put("user_email",user.getUserId());
        map.put("token",jwtToken);
        map.put("message", "User Successfully logged in");
        map.put("role",user.getRole());
        return map;
    }
}
