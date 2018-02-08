package com.parlor.amayicecream.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.assertj.core.internal.cglib.core.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parlor.amayicecream.model.User;
import com.parlor.amayicecream.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	// Declare the Logger
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * User login
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity userLogin(@RequestBody User user) {
		ResponseEntity response = null;
		logger.info("user Logging in");
		Map<String, String> validationError = userService.userLoginValidation(user);
		if(validationError != null && !validationError.isEmpty()) {
			response = new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
		}else {
			boolean loggedIn = userService.userLogin(user);
			response = new ResponseEntity<>(loggedIn, HttpStatus.OK);
		}
		return response;
	}
	
	/**
	 * Create User
	 * 
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		logger.info("Creating user");
		User createdUser = userService.create(user);
		return createdUser;
	}
	
	/**
	 * Get all Users
	 * 
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		logger.info("Get all users");
		List<User> allUsers = userService.fetchAll();
		return allUsers;
	}
}
