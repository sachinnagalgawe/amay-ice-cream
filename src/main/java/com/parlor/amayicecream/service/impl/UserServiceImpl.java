package com.parlor.amayicecream.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parlor.amayicecream.controller.UserController;
import com.parlor.amayicecream.model.User;
import com.parlor.amayicecream.repository.UserRepository;
import com.parlor.amayicecream.service.UserService;

/**
 * UserServiceImpl class for all user services
 * 
 * @author sachin
 */
@Service
public class UserServiceImpl implements UserService {

	// Declare the Logger
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Create user
	 * 
	 * @param User
	 * @return User
	 */
	@Override
	public User create(User user) {
		logger.info("Creating new user");
		User createdUser = userRepository.save(user);
		return createdUser;
	}
	
	/**
	 * Fetch all users
	 * 
	 * @return List<User>
	 */
	public List<User> fetchAll() {
		logger.info("Fetching all users");
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}
	
	/**
	 * Login
	 * 
	 * @param user
	 * @return
	 */
	public boolean userLogin(User user) {
		logger.info("Login in for user");
		if(user != null) {
			String username = user.getUsername();
			String password = user.getPassword();
		
			User userFound = userRepository.findByUsernameAndPassword(username, password);
			if(userFound != null) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Login validation
	 * 
	 * @param user
	 * @return
	 */
	public Map<String, String> userLoginValidation(User user) {
		Map<String, String> validationErrors = new HashMap<>();
		if(user != null) {
			String username = user.getUsername();
			String password = user.getPassword();
			
			if(username == null || username.equals("")) {
				validationErrors.put("username", "Please provide username");
			}else if(password == null || password.equals("")) {
				validationErrors.put("password", "Please provide password");
			}
		}else {
			validationErrors.put("user", "request body cant be null");
		}
		return validationErrors;
	}
}
