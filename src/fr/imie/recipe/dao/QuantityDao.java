package fr.imie.recipe.dao;

import java.util.List;

import fr.imie.recipe.entity.Quantity;

public interface QuantityDao {

	void addQuantity(Quantity q);
	List<Quantity> getAllQuantities();
	Quantity findQuantityById(Long id);
	void removeQuantity(Quantity q);

}