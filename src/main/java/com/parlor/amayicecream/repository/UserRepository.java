package com.parlor.amayicecream.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.parlor.amayicecream.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	public List<User> findAll();
	
	public User findByUsernameAndPassword(String username, String password);
}
