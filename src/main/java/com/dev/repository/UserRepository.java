package com.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.entity.User;

/**
 * Repository for User
 * @author Vivek Gupta
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
	User findByEmail(String emailId);
}
