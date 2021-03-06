package main.java.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.model.dao.impl.CategoryDAOImpl;
import main.java.model.dao.impl.ProductDAOImpl;
import main.java.model.dao.impl.UserDAOImpl;

public class DAOFactory {

	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jsf-system-jpa");
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
	public static UserDAOImpl createUserDAO() {
		return new UserDAOImpl();
	}
	
	public static ProductDAOImpl createProductDAO() {
		return new ProductDAOImpl();
	}
	
	public static CategoryDAOImpl createCategoryDAO() {
		return new CategoryDAOImpl();
	}
}
