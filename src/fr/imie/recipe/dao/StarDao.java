package fr.imie.recipe.dao;

import java.util.List;

import fr.imie.recipe.entity.Star;

public interface StarDao {
	void addStar(Star s);
	List<Star> getAllStars();
	Star findStarById(Long id);
	void removeStar(Star s);
}
