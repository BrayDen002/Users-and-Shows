package com.bradend.ExamBelt.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bradend.ExamBelt.models.User;
import com.bradend.ExamBelt.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	// -------------------- CRUD USERS ---------------------------//
	// register user and hash their password
    public User registerUser(User user) {
    	// TAKING THE PLAIN TEXT PASSWORD AND TURNING INTO HASHED VERSION
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }
    
//    GET ALL INFO FROM USER
    public List<User> allUsers(){
		return userRepo.findAll();
	}
    // find user by email
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long user_id) {
    	return userRepo.findById(user_id).orElse(null);
    }
    
//    CREATE A USER
    public User saveUser(User u) {
    	return userRepo.save(u);
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepo.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
	
}
