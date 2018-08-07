package fr.imie.recipe.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Recipe {
	
	/*
	 * Attributes 
	 */
	
	private String name;
	
	@OneToMany(mappedBy="recipe")
	private List<Quantity> quantities;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private User user;

	
	/*
	 * Constructor
	 */
	
	public Recipe() {
		super();
	}

	public Recipe(String name) {
		super();
		this.name = name;
	}

	public Recipe(String name, List<Quantity> quantities, User user) {
		super();
		this.name = name;
		this.quantities = quantities;
		this.user = user;
	}
	
	/*
	 * Getter and Setters
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Quantity> getQuantities() {
		return quantities;
	}

	public void setQuantities(List<Quantity> quantities) {
		this.quantities = quantities;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
