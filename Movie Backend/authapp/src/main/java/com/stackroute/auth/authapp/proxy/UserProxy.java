package com.stackroute.auth.authapp.proxy;

import com.stackroute.auth.authapp.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// http://localhost:6666/product-app-v1/add-user
@FeignClient(name="movie-service", url="localhost:8080")
public interface UserProxy {
    @PostMapping("/movie/add-user")
    public abstract ResponseEntity<?> sendUserDtoToMoiveApp(@RequestBody UserDTO userDTO);
 }












