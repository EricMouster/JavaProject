package fr.imie.recipe.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import fr.imie.recipe.dao.DaoFactory;
import fr.imie.recipe.entity.Ingredient;
import fr.imie.recipe.entity.Quantity;
import fr.imie.recipe.entity.Recipe;
import fr.imie.recipe.util.PersistenceManager;

/**
 * Servlet implementation class AddRecipeServlet
 */
@WebServlet("/AddRecipe")
public class AddRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRecipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Recipe recipe;
		if (request.getParameter("id") != null) {
			recipe = DaoFactory.getRecipeDao().findRecipeById(Long.parseLong(request.getParameter("id")));
		} else {
			recipe = new Recipe();
		}
		request.setAttribute("recipe", recipe);

		List<Ingredient> ingredients = DaoFactory.getIngedienttDao().getAllIngredients();
		request.setAttribute("ingredients", ingredients);
		
		request.getRequestDispatcher("/AddRecipe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("rowCount"));

		Recipe recipe = new Recipe();

		
		
		List<Quantity> quantities = new ArrayList<>();
		int rowCount = Integer.parseInt(request.getParameter("rowCount"));
		
		for (int i = 1; i <= rowCount; i++) {
			long ingredientId = Long.parseLong(request.getParameter("ingredient"+i));
			Long count = Long.parseLong(request.getParameter("count"+i));
			Ingredient ingredient = DaoFactory.getIngedienttDao().findIngredientById(ingredientId);
			
			Quantity quantity = new Quantity(count, recipe, ingredient);
			quantities.add(quantity);
		}
		
		recipe.setQuantities(quantities);
		DaoFactory.getRecipeDao().addRecipe(recipe);
		
		request.getRequestDispatcher("/MyRecipes.jsp").forward(request, response);

	}

}
