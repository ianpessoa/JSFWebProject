package main.java.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;

import main.java.entities.Product;
import main.java.model.dao.DAOFactory;
import main.java.model.dao.ProductDAO;

@ApplicationScoped
public class ProductService {

	private List<Product> products = new ArrayList<Product>();

	ProductDAO productDAO = DAOFactory.createProductDAO();

	@PostConstruct
	public void init() {
		products = productDAO.findAll();
	}

	public List<Product> getProducts() {
		return new ArrayList<Product>(products);
	}

	public List<Product> getProducts(int size) {

		if (products.size() > 0) {
			if (size > products.size()) {
				return products;
			}

			else {
				return new ArrayList<Product>(products.subList(0, size));
			}
		}
		else {
			return new ArrayList<Product>();
		}

	}

	public List<Product> getClonedProducts(int size) {
		List<Product> results = new ArrayList<Product>();
		List<Product> originals = getProducts(size);
		for (Product original : originals) {
			results.add((Product) original.clone());
		}
		return results;
	}
}
