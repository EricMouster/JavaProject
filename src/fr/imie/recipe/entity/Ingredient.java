package fr.imie.recipe.entity;

import javax.persistence.Entity;

@Entity
public class Ingredient {
	
	/*
	 * Attributes 
	 */
	
	private String name;
	private int price;
	
	/*
	 * Constructor
	 */
	
	public Ingredient() {
		super();
	}

	public Ingredient(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
