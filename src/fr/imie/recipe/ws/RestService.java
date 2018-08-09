package fr.imie.recipe.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import fr.imie.recipe.ws.resources.IngredientResource;

@ApplicationPath("/api")
public class RestService extends Application {
	public RestService() {
	}

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> returnValue = new HashSet<Class<?>>();
		returnValue.add(IngredientResource.class);
		return returnValue;
	}
}