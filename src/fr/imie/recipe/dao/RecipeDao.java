package fr.imie.recipe.dao;

import java.util.List;

import fr.imie.recipe.entity.Recipe;
import fr.imie.recipe.entity.User;

public interface RecipeDao {

	void addRecipe(Recipe r);
	List<Recipe> getAllRecipes();
	Recipe findRecipeById(Long id);
	void removeRecipe(Recipe r);
	List<Recipe> findRecipeByUser(User user);
	
}
