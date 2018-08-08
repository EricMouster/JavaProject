package fr.imie.recipe.dao;

import fr.imie.recipe.dao.jpa.*;
import fr.imie.recipe.util.PersistenceManager;

public class DaoFactory {
	
	private DaoFactory() {
		
	}
	
	public static IngredientDao getIngedienttDao() {
		return new JpaIngredientDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static QuantityDao getQuantityDao() {
		return new JpaQuantityDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static RecipeDao getRecipeDao() {
		return new JpaRecipeDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static StarDao getStarDao() {
		return new JpaStarDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static UserDao getUserDao() {
		return new JpaUserDao(PersistenceManager.getEntityManagerFactory());
	}

}