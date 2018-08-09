<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/custom.css">
<title>Recipe Manager</title>
</head>
<body>
	<%@include file="./includes/NavBar.jsp"%>
	<div
		class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
		<c:if test="${error == 'error'}">
			<div class="alert alert-danger" role="alert">
				Connection failed, please check the information you send.
			</div>
		</c:if>
			<form method="post"
				id="form-login">
					<div class="form-group">
						<label for="name">Login</label> <input type="text"
							class="form-control" name="name">
					</div>
					<div class="form-group">
						<label for="unit">Password</label> <input type="password"
							class="form-control" name="password">
					</div>
					<div class="form-group">
						<label for="price">Mail</label> <input type="mail"
							class="form-control" name="mail">
					</div>
					<button type="button" class="btn btn-primary" onclick="send('Login')">Connect</button>
					<button type="button" class="btn btn-primary" onclick="send('Subscribe')">Subscribe</button>
			</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<script type="text/javascript">
		function send(page) {
			$('#form-login')[0].action = '/Recipe/'+page;
			$('#form-login').submit();
		}
	</script>
</body>
</html>