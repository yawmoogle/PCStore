package com.podProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.podProject.model.User;
import com.podProject.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public boolean registerNewUser(User user) {
		
		Optional<User> userOptional = userRepo.findByUsername(user.getUsername());
		
		if(userOptional.isEmpty()) {
			
			String pw = user.getPassword();
			
			user.setPassword(passwordEncoder.encode(pw));
			
			userRepo.save(user);
			return true;
		}else {
			return false;
		}
	}

	public User findUser(long userId) {
		Optional<User> userOptional = userRepo.findById(userId);
		
		User user = userOptional.orElse(new User("defaultName","defaultPassword", null, null));
		
		return user;
	}

	public List<User> findAllUsers() {
		
		return userRepo.findAll();
	}

//	public boolean verifyUserCredentials(String username, String password) {
//		Optional<User> userOptional = userRepo.findByUsername(username);
//		
//		if(userOptional.isEmpty()) {
//			return false;
//		} else {
//			return userOptional.get().getPassword().equals(password);
//		}
//	}

	public User findVerifiedUser(String username) {
		return userRepo.findByUsername(username).get();
	}
	
}
