package main.java.model.dao;

import java.util.List;

import main.java.entities.Category;

public interface CategoryDAO {

	void insert(Category obj);
	
	void update(Category obj);
	
	void deleteById(String id);
	
	Category findById(Integer id);
	
	List<Category> findAll();
}
