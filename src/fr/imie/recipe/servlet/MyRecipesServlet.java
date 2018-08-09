package fr.imie.recipe.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.recipe.dao.DaoFactory;
import fr.imie.recipe.entity.Recipe;
import fr.imie.recipe.entity.User;

/**
 * Servlet implementation class MyRecipeServlet
 */
@WebServlet("/MyRecipes")
public class MyRecipesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyRecipesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User currentUser = (User) request.getAttribute("currentUser");
		List<Recipe> recipes = DaoFactory.getRecipeDao().findRecipeByUser(currentUser);
		request.setAttribute("recipes", recipes);
		request.getRequestDispatcher("/MyRecipes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
