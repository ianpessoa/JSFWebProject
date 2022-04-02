package main.java.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import main.java.entities.User;
import main.java.model.dao.DAOFactory;
import main.java.model.dao.UserDAO;

public class UserDAOImpl implements UserDAO{

	@Override
	public void insert(User obj) {
		EntityManager em = DAOFactory.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public void update(User obj) {
		EntityManager em = DAOFactory.getEntityManager();
		
		em.getTransaction().begin();
		em.refresh(obj);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public void deleteById(String id) {
		EntityManager em = DAOFactory.getEntityManager();
		
		User u = em.find(User.class, 2);
		
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public User findById(Integer id) {
		
		EntityManager em = DAOFactory.getEntityManager();
		
		User user = em.find(User.class, id);
		
		em.close();
		
		return user;
		
	}
	
	@Override
	public User findByUsername(String username) {
		
		EntityManager em = DAOFactory.getEntityManager();
		User user = null;
		try {
			user = em.createQuery(
					  "SELECT u from User u WHERE u.username = :username", User.class).
					  setParameter("username", username).getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
		em.close();
		
		return user;
		
	}

}
