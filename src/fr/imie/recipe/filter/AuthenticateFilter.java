package fr.imie.recipe.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import fr.imie.recipe.dao.DaoFactory;

/**
 * Servlet Filter implementation class AuthenticateFilter
 */
@WebFilter("/*")
public class AuthenticateFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		Cookie[] cookies = req.getCookies();
		String nom = "userId";
		boolean auth = false;
        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                if ( cookie != null && nom.equals(cookie.getName()) && !cookie.getValue().equals("") ) {
                    request.setAttribute("currentUser", DaoFactory.getUserDao().findUserById(Long.parseLong(cookie.getValue())));
                    auth = true;
                }
            }
        }
        // pass the request along the filter chain
        if (auth || req.getRequestURI().equals("/Recipe/Login") || req.getRequestURI().contains("/Recipe/css/") || req.getRequestURI().equals("/Recipe/Subscribe")) {
        	chain.doFilter(request, response);
        } else {
        	 // Default : return to login page
            req.getRequestDispatcher("/Login").forward(request, response);
        }
	}

}
