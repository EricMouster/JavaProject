package fr.imie.recipe.dao;

import java.util.List;

import fr.imie.recipe.entity.User;

public interface UserDao {
	void addUser(User u);
	List<User> getAllUsers();
	User findUserById(Long id);
	void removeUser(User u);
	User connect(String name, String password);
}
