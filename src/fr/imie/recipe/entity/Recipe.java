package fr.imie.recipe.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Recipe {
	
	/*
	 * Attributes 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="recipe")
	private List<Quantity> quantities;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	private String description;
	
	@OneToMany(mappedBy="recipe")
	private List<Instruction> instructions;
	private Long level;

	
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

	public Recipe(String name, List<Quantity> quantities, User user, String description, List<Instruction> instructions, Long level) {
		super();
		this.name = name;
		this.quantities = quantities;
		this.user = user;
		this.description = description;
		this.instructions = instructions;
		this.level = level;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

}
