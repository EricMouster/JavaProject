<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/custom.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<title>My Ingredients Manager</title>
</head>
<body>
	<%@include file="./includes/NavBar.jsp"%>
	<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col"><i class="fas fa-plus-square" id="add"></i></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${ingredients}">
					<tr>
						<th scope="row">${i.id}</th>
						<td>${i.name}</td>
						<td>${i.price}</td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
	document.getElementById("add").addEventListener("click", () => {
		window.location = "http://localhost:8080/Recipe/AddIngredient";
	}); 
	</script>
</body>
</html>