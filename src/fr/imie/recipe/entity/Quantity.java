package fr.imie.recipe.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Quantity {

	/*
	 * Attributes 
	 */

	private Long count;
	
	@ManyToOne
	@JoinColumn(name="recipe_id")
	private Recipe recipe;
	
	@ManyToOne
	@JoinColumn(name="ingredient_id")
	private Ingredient ingredient;
	
	
	/*
	 * Constructor
	 */
	
	public Quantity() {
		super();
	}

	public Quantity(Long count, Recipe recipe, Ingredient ingredient) {
		super();
		this.count = count;
		this.recipe = recipe;
		this.ingredient = ingredient;
	}
	
	/*
	 * Getter and Setters
	 */

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
		
}
