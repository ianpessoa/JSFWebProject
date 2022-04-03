package main.java.model.dao;

import java.util.List;

import main.java.entities.Product;

public interface ProductDAO {

	void insert(Product obj);
	
	void update(Product obj);
	
	void deleteById(String id);
	
	Product findById(Integer id);
	
	List<Product> findAll();
}
