package main.java.services;

import main.java.entities.User;
import main.java.model.dao.DAOFactory;
import main.java.model.dao.UserDAO;

public class UserService {
	
	UserDAO userDAO = DAOFactory.createUserDAO();
	
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}
	
	public void insertUser(User user) {
		userDAO.insert(user);
	}
	
}
