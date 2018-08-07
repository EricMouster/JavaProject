package fr.imie.recipe.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class User {
	
	/*
	 * Attributes 
	 */
	
	private String username;
	private String mail;
	private String password;
	
	@ManyToOne
	private List<Recipe> recipes;
	
	/*
	 * Constructor
	 */
	
	public User() {
		super();
	}

	public User(String username, String mail, String password) {
		super();
		this.username = username;
		this.mail = mail;
		this.password = password;
	}
	
	/*
	 * Getter and Setters
	 */
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

}
