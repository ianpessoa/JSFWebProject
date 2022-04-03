package main.java.services;

import java.util.List;

import javax.faces.bean.ApplicationScoped;

import main.java.entities.Category;
import main.java.model.dao.CategoryDAO;
import main.java.model.dao.DAOFactory;

@ApplicationScoped
public class CategoryService {

	CategoryDAO categoryDAO = DAOFactory.createCategoryDAO();
	
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}
	
	public Category findById(Integer id) {
		return categoryDAO.findById(id);
	}
}
