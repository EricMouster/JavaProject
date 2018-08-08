package fr.imie.recipe.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.recipe.dao.StarDao;
import fr.imie.recipe.entity.Star;

public class JpaStarDao implements StarDao {
	
	EntityManagerFactory emf;

	public JpaStarDao(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public void addStar(Star s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(t);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Star> getAllStars() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT s FROM Star AS s");
		List<Star> stars = query.getResultList();
		em.close();
		return stars;
	}

	@Override
	public Star findStarById(Long id) {
		EntityManager em = emf.createEntityManager();
		Star s = em.find(Star.class, id);
		em.close();
		return s;
	}

	@Override
	public void removeStar(Star s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			if (em.contains(s)) s = em.merge(s);
			em.remove(s);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		
	}

}
