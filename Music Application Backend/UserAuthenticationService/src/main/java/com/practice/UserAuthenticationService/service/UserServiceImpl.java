package com.practice.UserAuthenticationService.service;

import com.practice.UserAuthenticationService.domain.User;
import com.practice.UserAuthenticationService.exception.UserAlreadyExistException;
import com.practice.UserAuthenticationService.exception.UserNotFoundException;
import com.practice.UserAuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl (UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    public User addUser(User user) throws UserAlreadyExistException {
        if(userRepository.existsById(Integer.valueOf(user.getUserId()))){
            throw new UserAlreadyExistException();
        }
        User user1=userRepository.save(user);
        return user1;
    }

    @Override
    public User findByUserIdAndPassword(int userId, String password) throws UserNotFoundException {
        User user=userRepository.findByUserIdAndPassword(userId,password);
        if(user==null){
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(int userId) throws UserNotFoundException {
        boolean result=false;
        if(userRepository.findById(userId).isEmpty()){
            throw new UserNotFoundException();
        }else {userRepository.deleteById(userId);
                result=true;
            }
        return result;
    }
}
