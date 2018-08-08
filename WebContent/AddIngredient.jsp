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
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<title>My Ingredients Manager</title>
</head>
<body>
	<%@include file="./includes/NavBar.jsp"%>
	<div
		class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
		<form method="post" action="/Recipe/MyIngredients">
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							class="form-control" id="name" placeholder="Eggs">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="unit">Unit</label> <input type="text"
							class="form-control" id="unit" placeholder="Unity">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="price">Price</label> <input type="number"
							class="form-control" id="price" placeholder="0.00">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="submit"></label>
						<input type="submit"
							class="form-control btn btn-primary" id="submit" value="Send">
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>