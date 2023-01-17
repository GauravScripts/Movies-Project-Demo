package com.stackroute.auth.authapp.repository;

import com.stackroute.auth.authapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    // save() [ when new user registers ]
    // findByEmailIdAndPassword(emailid, password);
    public abstract User findByEmailIdAndPassword(String emailId, String password);
    // select * from User where emailid = ? and password= ?
}
// emailId  password