package fr.imie.recipe.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import fr.imie.recipe.util.PersistenceManager;

public class PersistenceAppListener implements ServletContextListener {
	// Call on application initialization
	@Override
	public void contextInitialized(ServletContextEvent evt){
	    // Do nothing
	}

	// Call on application destruction
	@Override
	public void contextDestroyed(ServletContextEvent evt) {
	    PersistenceManager.closeEntityManagerFactory();
	}
}
