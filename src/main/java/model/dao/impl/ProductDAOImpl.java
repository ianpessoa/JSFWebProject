package main.java.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import main.java.entities.Product;
import main.java.model.dao.DAOFactory;
import main.java.model.dao.ProductDAO;

public class ProductDAOImpl implements ProductDAO{

	@Override
	public void insert(Product obj) {
		EntityManager em = DAOFactory.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public void update(Product obj) {
		EntityManager em = DAOFactory.getEntityManager();
		
		em.getTransaction().begin();
		em.refresh(obj);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public void deleteById(String id) {
		EntityManager em = DAOFactory.getEntityManager();
		
		Product u = em.find(Product.class, 2);
		
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public Product findById(Integer id) {
		
		EntityManager em = DAOFactory.getEntityManager();
		
		Product Product = em.find(Product.class, id);
		
		em.close();
		
		return Product;
		
	}
	
	@Override
	public List<Product> findAll(){
		EntityManager em = DAOFactory.getEntityManager();
		List<Product> products = new ArrayList<Product>();
		try {
			products = em.createQuery(
					  "SELECT p from Product p", Product.class).getResultList();
		}
		catch(NoResultException e) {
			return products;
		}
		em.close();
		
		return products;
	}

}