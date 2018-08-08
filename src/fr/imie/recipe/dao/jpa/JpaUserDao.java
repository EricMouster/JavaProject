package fr.imie.recipe.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.recipe.dao.UserDao;
import fr.imie.recipe.entity.User;

public class JpaUserDao implements UserDao {
	
	EntityManagerFactory emf;

	public JpaUserDao(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public void addUser(User u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(u);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT u FROM User AS u");
		List<User> users = query.getResultList();
		em.close();
		return users;
	}

	@Override
	public User findUserById(Long id) {
		EntityManager em = emf.createEntityManager();
		User u = em.find(User.class, id);
		em.close();
		return u;
	}

	@Override
	public void removeUser(User u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			if (em.contains(u)) u = em.merge(u);
			em.remove(u);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		
	}

}
