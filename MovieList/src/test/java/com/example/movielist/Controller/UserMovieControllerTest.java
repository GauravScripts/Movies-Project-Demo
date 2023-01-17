package com.example.movielist.Controller;

import com.example.movielist.controller.UserMovieController;
import com.example.movielist.domain.Movie;
import com.example.movielist.domain.User;
import com.example.movielist.service.UserMovieService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserMovieControllerTest {

    @InjectMocks
    private UserMovieController userMovieController;

    @Mock
    private UserMovieService userMovieService;

    @Test
    public void addUser_shouldReturnUserDetails_whenUserIsAdded() {
        //Given
        User user = new User();
        user.setMovies(new ArrayList<Movie>());
        Mockito.when(userMovieService.addUser(user)).thenReturn(user);
        //When
        ResponseEntity<?> responseEntity = userMovieController.addUser(user);
        //Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }

    @Test
    public void getUserDetails_shouldReturnUserDetails_whenEmailIdIsPresent() {
        //Given
        User user = new User();
        user.setMovies(new ArrayList<Movie>());
        Mockito.when(userMovieService.getUserDetails("some@email.com")).thenReturn(user);
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getAttribute("current_user_emailid")).thenReturn("some@email.com");
        //When
        ResponseEntity<?> responseEntity = userMovieController.getUserDetails(request);
        //Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }
}
