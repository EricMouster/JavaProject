package fr.imie.recipe.ws.resources;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.imie.recipe.dao.DaoFactory;
import fr.imie.recipe.entity.Ingredient;
import fr.imie.recipe.entity.User;

@Path("/Ingredient")
public class IngredientResource {

		@POST
		@Path("/AddIngredient")
		@Consumes("application/x-www-form-urlencoded")
		@Produces(MediaType.APPLICATION_JSON)
		public Response addIngredient(@FormParam("name") String name, @FormParam("price") String price, @FormParam("unit") String unit) throws ServletException, IOException {
			User u = DaoFactory.getUserDao().findUserById(1L);
			Ingredient i = new Ingredient(
						name,
						Float.parseFloat(price),
						u,
						unit
					);
			DaoFactory.getIngedienttDao().addIngredient(i);
			return Response.ok(i.toString()).build();
		}
		
}
