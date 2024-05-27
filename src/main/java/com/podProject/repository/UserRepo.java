package com.podProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.podProject.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);
	
}
