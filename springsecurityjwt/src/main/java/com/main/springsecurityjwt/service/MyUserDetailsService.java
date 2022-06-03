package com.main.springsecurityjwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.main.springsecurityjwt.dao.CountryDao;
import com.main.springsecurityjwt.dao.UserDao;
import com.main.springsecurityjwt.entities.Country;
import com.main.springsecurityjwt.entities.User;
import com.main.springsecurityjwt.models.MyUserDetails;
import com.main.springsecurityjwt.save.SaveLogic;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserDao userDao;
	

	
	
		@Override
		public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
			Optional<User> user = userDao.findByUserName(userName);
			
			return user.map(MyUserDetails::new).get();
		}
	
	public List<User> getAll() {
		return userDao.findAll();
	}

	public String insert(User user) {
		String role = user.getRoles();
		role = "ROLE_" + role.toUpperCase();
		user.setRoles(role);
		userDao.save(user);
		return "Successfully Inserted";
	}

	public String deleteUserById(int id) {
		userDao.deleteById(id);
		return "Successfully Deleted";
	}

	public String update(User user) {
		String role = user.getRoles();
		role = "ROLE_" + role.toUpperCase();
		user.setRoles(role);
		userDao.save(user);
		return "Successfully Updated";
	}

	public User getUserById(int id) {
		return userDao.findById(id).get();
	}

	
	
	

}
