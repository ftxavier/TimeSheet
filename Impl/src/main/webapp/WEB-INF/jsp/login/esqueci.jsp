<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Esqueci a senha</title>

<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
</head>
<body>
	<div class="container">

		<form class="form-signin" method="post"
			action="<c:url value="/login/reset" />">
			<h2 class="form-signin-heading">Esqueci a senha</h2>
			<c:if test="${not empty errors}">
				<div class="alert alert-error">
					<c:forEach var="error" items="${errors}">
					    ${error.category} - ${error.message}<br />
					</c:forEach>
				</div>
			</c:if>
			<input type="text" name="email" placeholder="E-Mail" class="input-block-level" />
			<hr/>
			<button type="submit" class="btn btn-large btn-primary">Enviar</button>
		</form>

	</div>
	<script src="http://code.jquery.com/jquery.js" type="text/javascript"></script>
	<script
		src="<c:url value="/resources/bootstrap/js/bootstrap.min.js/" />"
		type="text/javascript"></script>
</body>
</html>