package fr.imie.recipe.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.recipe.dao.IngredientDao;
import fr.imie.recipe.entity.Ingredient;
import fr.imie.recipe.entity.User;

public class JpaIngredientDao implements IngredientDao {
	
	private EntityManagerFactory emf;
	
	public JpaIngredientDao(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public void addIngredient(Ingredient i) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(i);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ingredient> getAllIngredients() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT i FROM Ingredient AS i");
		List<Ingredient> ingredients = query.getResultList();
		em.close();
		return ingredients;
	}

	@Override
	public Ingredient findIngredientById(Long id) {
		EntityManager em = emf.createEntityManager();
		Ingredient i = em.find(Ingredient.class, id);
		em.close();
		return i;
	}

	@Override
	public void removeIngredient(Ingredient i) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			if(em.contains(i)) i = em.merge(i);
			em.remove(i);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ingredient> findByUser(User user) {
		EntityManager em =emf.createEntityManager();
		Query query = em.createQuery("SELECT i FROM Ingredient AS i WHERE i.user = :user");
		query.setParameter("user", user);
		List<Ingredient> ingredients = query.getResultList();
		return ingredients;
	}

}
