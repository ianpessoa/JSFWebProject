package main.java.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import main.java.entities.Category;
import main.java.model.dao.CategoryDAO;
import main.java.model.dao.DAOFactory;

public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public void insert(Category obj) {
		EntityManager em = DAOFactory.getEntityManager();

		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();

		em.close();
	}

	@Override
	public void update(Category obj) {
		EntityManager em = DAOFactory.getEntityManager();

		em.getTransaction().begin();
		em.refresh(obj);
		em.getTransaction().commit();

		em.close();
	}

	@Override
	public void deleteById(String id) {
		EntityManager em = DAOFactory.getEntityManager();

		Category u = em.find(Category.class, 2);

		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();

		em.close();
	}

	@Override
	public Category findById(Integer id) {

		EntityManager em = DAOFactory.getEntityManager();

		Category Category = em.find(Category.class, id);

		em.close();

		return Category;

	}

	@Override
	public List<Category> findAll() {
		EntityManager em = DAOFactory.getEntityManager();
		List<Category> Categorys = new ArrayList<Category>();
		try {
			Categorys = em.createQuery("SELECT c from Category c", Category.class).getResultList();
		} catch (NoResultException e) {
			return Categorys;
		}
		em.close();

		return Categorys;
	}

}