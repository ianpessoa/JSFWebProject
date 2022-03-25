package main.java.model.dao;

import main.java.entities.User;

public interface UserDAO {

	void insert(User obj);
	
	void update(User obj);
	
	void deleteById(String id);
	
	User findById(Integer id);

	User findByUsername(String username);
}
