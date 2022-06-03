package com.main.springsecurityjwt.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.springsecurityjwt.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	Optional<User> findByUserName(String userName);

	
}
