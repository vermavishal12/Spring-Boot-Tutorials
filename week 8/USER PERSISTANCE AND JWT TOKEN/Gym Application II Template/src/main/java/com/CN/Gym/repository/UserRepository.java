package com.CN.Gym.repository;

import com.CN.Gym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
//	Optional<User> findByUsername(String username); 
	Optional<User> findByEmail(String email);
	
}
