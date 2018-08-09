package fr.imie.recipe.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Ingredient {
	
	/*
	 * Attributes 
	 */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Float price;
	private String unit;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	/*
	 * Constructor
	 */
	
	public Ingredient() {
		super();
	}

	public Ingredient(String name, Float price, User user, String unit) {
		super();
		this.name = name;
		this.price = price;
		this.user = user;
		this.unit = unit;
	}

	/*
	 * Getter and Setters
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		String obj = "{ \"id\":\""+this.getId()+"\", \"name\": \""+this.getName()+"\", \"price\": \""+this.getPrice()+"\" }";
		return obj;
	}
	
}
