package com.stackroute.auth.authapp.service;

import com.stackroute.auth.authapp.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(User user) {
        // generate JWT user algo, userdata, issued time, expiration time, secret key...
        Map<String,String> result = new HashMap<String,String>();
       user.setPassword("");

        Map<String,Object> userdata = new HashMap<>();

        userdata.put("user_role",user.getRole());
        userdata.put("user_email",user.getEmailId());
        String jwt = Jwts.builder()
                .setClaims(userdata) // emailid,  role
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, "mysecretkey")
                .compact();

        result.put("token",jwt);
        result.put("message","User login success");
        result.put("role",user.getRole()); //This line is adding the role of the user to the result map.
        return result;
    }
}
