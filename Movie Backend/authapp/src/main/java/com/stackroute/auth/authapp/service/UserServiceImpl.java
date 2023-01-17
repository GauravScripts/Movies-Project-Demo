package com.stackroute.auth.authapp.service;

import com.stackroute.auth.authapp.model.SignupData;
import com.stackroute.auth.authapp.model.User;
import com.stackroute.auth.authapp.model.UserDTO;
import com.stackroute.auth.authapp.proxy.UserProxy;
import com.stackroute.auth.authapp.rabbitmq.EmailDTO;
import com.stackroute.auth.authapp.rabbitmq.MailProducer;
import com.stackroute.auth.authapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    // ServiceImpl needs proxy
    @Autowired
    private UserProxy userProxy;

  //  @Autowired
   // private MailProducer mailProducer;
    @Override
    public User registerUser1(SignupData signupData) {
        // signup data is carrying emailid, password, username, mobileno, address
        // seperate data
        // create DTO object and fill 2nd application user data
        // call proxy method and pass DTO
        UserDTO userDTO = new UserDTO(signupData.getEmailId(),signupData.getUserName(),
                signupData.getMobileNo(), signupData.getAddress());
        ResponseEntity response = userProxy.sendUserDtoToProductApp(userDTO); // inserts user record in ProductApp (MongoDB)
        // above method raises POST request as 'http://localhost:5555/product-app-v1/add-user' + userDto Object
        System.out.println(response);

        // create User object and fill emailid, password, role
        // call repo.save(userobject)
        User user = new User(signupData.getEmailId(), signupData.getPassword(),"ROLE_USER");
        User result= userRepository.save(user); // insert user record in AuthApp (MySQL)
        // call producer method, send mailDTO as reslt.emailid,  subject, body
        // create emailDTO object and fill data
        // call producer method, pass dto object
     //   EmailDTO emailDTO = new EmailDTO(result.getEmailId(),"Welcome to our application","Signup is success");
     //   mailProducer.sendMailDtoToQueue(emailDTO);
        return result;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loginCheck(User user) { // emailid+password
       // User result=userRepository.findByEmailIdAndPassword(user.getEmailId(), user.getPassword());
        //return result; // user object if login is success OR null
        if(userRepository.findById(user.getEmailId()).isPresent()){
            // user record found by emailid
            User result = userRepository.findById(user.getEmailId()).get();
            if (result.getPassword().equals(user.getPassword()))
            {
                    // password also matching
                return result;  // email +password matched
            }
            else{
                return null; // emailid matched, password nt matched
            }
        }
        else{
            // user record not found by mailid
            return null;
        }
    }
}
