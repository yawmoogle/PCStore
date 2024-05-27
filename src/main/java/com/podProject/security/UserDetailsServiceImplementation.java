package com.podProject.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.podProject.model.User;
import com.podProject.repository.UserRepo;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional = userRepo.findByUsername(username);
		
		User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User with username "+ username +" not found."));
		
		return new UserPrincipal(user);
	}

}
