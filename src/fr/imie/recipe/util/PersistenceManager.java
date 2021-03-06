package fr.imie.recipe.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	private static EntityManagerFactory emf;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("Recipe_PU");
		}
		return emf;
	}
	
	public static void closeEntityManagerFactory() {
		if (emf != null && emf.isOpen()) emf.close();
	}

}
