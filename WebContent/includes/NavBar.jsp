<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib	prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="site-header sticky-top py-1">
  <div class="container d-flex flex-column flex-md-row justify-content-between">
    <a class="py-2 d-none d-md-inline-block" href="/Recipe">Home</a>
    <c:if test="${currentUser != null}">
	    <a class="py-2 d-none d-md-inline-block" href="/Recipe/MyRecipes">My Recipes</a>
	    <a class="py-2 d-none d-md-inline-block" href="/Recipe/MyIngredients">My Ingredients</a>
	    <a class="py-2 d-none d-md-inline-block" href="/Recipe/Disconnect">Disconnect</a>
    </c:if>
  </div>
</nav>