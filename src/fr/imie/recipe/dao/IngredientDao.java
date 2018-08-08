package fr.imie.recipe.dao;

import java.util.List;

import fr.imie.recipe.entity.Ingredient;
import fr.imie.recipe.entity.User;

public interface IngredientDao {

	void addIngredient(Ingredient i);
	List<Ingredient> getAllIngredients();
	Ingredient findIngredientById(Long id);
	void removeIngredient(Ingredient i);
	List<Ingredient> findByUser(User user);

}