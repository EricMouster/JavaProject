package fr.imie.recipe.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Star {
	
	/*
	 * Attributes 
	 */
	
	@OneToMany
	@JoinColumn(name="recipe_id")
	private Recipe recipe;
	
	private Long number;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private User user;

	/*
	 * Constructor
	 */
	
	public Star() {
		super();
	}

	public Star(Recipe recipe, Long number, User user) {
		super();
		this.recipe = recipe;
		this.number = number;
		this.user = user;
	}
	
	/*
	 * Getter and Setters
	 */

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
