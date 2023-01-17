package com.stackroute.auth.authapp.controller;

import com.stackroute.auth.authapp.model.SignupData;
import com.stackroute.auth.authapp.model.User;
import com.stackroute.auth.authapp.service.SecurityTokenGenerator;
import com.stackroute.auth.authapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth-app-v1")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;

    // http://localhost:4444/auth-app-v1/register-user1   [POST]
    @PostMapping("/register-user1")
    public ResponseEntity<?> registerUser1(@RequestBody SignupData signupData){
        return new ResponseEntity<>(userService.registerUser1(signupData),HttpStatus.OK);
    }

    // http://localhost:4444/auth-app-v1/registerUser   [POST]
    @PostMapping("/register-user") // not using now
    public ResponseEntity<?> registerUser(@RequestBody User user){
        user.setRole("ROLE_USER");
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.OK);
    }

    // http://localhost:4444/auth-app-v1/login-check  [POST]
    @PostMapping("/login-check")
    public ResponseEntity<?> loginCheck(@RequestBody User user){
        User result=userService.loginCheck(user);
        if(result!=null){
            // login success
           // return new ResponseEntity<>(result,HttpStatus.OK);
            return new ResponseEntity<>(securityTokenGenerator.generateToken(result),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Authentication failed", HttpStatus.OK);
        }
    }

}
