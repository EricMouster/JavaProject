package fr.imie.recipe.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.recipe.dao.RecipeDao;
import fr.imie.recipe.entity.Recipe;
import fr.imie.recipe.entity.User;

public class JpaRecipeDao implements RecipeDao {

	private EntityManagerFactory emf;
	
	public JpaRecipeDao(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public void addRecipe(Recipe r) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(r);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getAllRecipes() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT r FROM Recipe AS r");
		List<Recipe> recipes = query.getResultList();
		em.close();
		return recipes;
	}

	@Override
	public Recipe findRecipeById(Long id) {
		EntityManager em = emf.createEntityManager();
		Recipe r = em.find(Recipe.class, id);
		em.close();
		return r;
	}

	@Override
	public void removeRecipe(Recipe r) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			if (em.contains(r)) r = em.merge(r);
			em.remove(r);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> findRecipeByUser(User user) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT r FROM Recipe AS r WHERE r.user = :user");
		query.setParameter("user", user);
		List<Recipe> recipes = query.getResultList();
		return recipes;
	}

}
