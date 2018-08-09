package fr.imie.recipe.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.recipe.dao.DaoFactory;
import fr.imie.recipe.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = DaoFactory.getUserDao().connect(request.getParameter("name"), request.getParameter("password"));
		if (u != null) {
			Cookie c = new Cookie("userId", u.getId().toString());
			response.addCookie(c);
			request.setAttribute("currentUser", u);
			request.getRequestDispatcher("/").forward(request, response);
		} else {
			request.setAttribute("error", "error");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}

}
