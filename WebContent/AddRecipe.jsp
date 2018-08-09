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
		<form method="post" action="/Recipe/AddRecipe">
			<table class="table" id="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Ingredient</th>
					<th scope="col">Quantity</th>
					<th scope="col"><i class="fas fa-plus-square" id="newIngredient"></i></th>
				</tr>
			</thead>
			<tbody>
					<tr id="0">
						<td>
							<select id="ingredient" name="ingredient">
								<c:forEach var="i" items="${ingredients}">
									<option value="${i}">${i.name}</option>
								</c:forEach>
							</select>
						</td>
						<td><input type="number"
							class="form-control" id="count" name="count" placeholder="0"></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" id="rowCount" name="rowCount" value="33" />
			<div class="row">
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
	<script type="text/javascript">
	alert("test");
	var i = 0;
	document.getElementById("newIngredient").addEventListener("click", () => {
		i++;
		var table = document.getElementById("myTable");
	    var row = table.insertRow(0);
	    row.id = "" + i;

	    var cell1 = row.insertCell(0);
	    var cell2 = row.insertCell(1);
	    cell1.innerHTML = "<select id='ingredient' name='ingredient"+i+"'><c:forEach var='i' items='${ingredients}'><option value='${i}'>${i.name}</option></c:forEach></select>";
	    cell1.id= 'ingredient' + i;
	    cell2.innerHTML = "<input type='number'class='form-control' id='count"+i+"' name='count"+i+"'placeholder='0'>";
	    cell2.id= 'count' + i;
	    
	    document.getElementById('rowCount').value=i;
	});
	
	</script>
</body>
</html>