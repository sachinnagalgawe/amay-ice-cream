package com.parlor.amayicecream.service;

import java.util.List;
import java.util.Map;

import com.parlor.amayicecream.model.User;

/**
 * User service : for all services related to user
 * 
 * @author sachin
 */
public interface UserService {

	/**
	 * Create User
	 * 
	 * @return User
	 */
	public User create(User user);
	
	/**
	 * Fetch all users
	 * 
	 * @return List<User>
	 */
	public List<User> fetchAll();
	
	/**
	 * Login
	 * 
	 * @param user
	 * @return
	 */
	public boolean userLogin(User user);
	
	/**
	 * Login validation
	 * 
	 * @param user
	 * @return
	 */
	public Map<String, String> userLoginValidation(User user);
}
