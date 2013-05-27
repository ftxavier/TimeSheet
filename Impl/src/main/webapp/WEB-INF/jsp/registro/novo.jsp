<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar Registro</title>
</head>
<body>
	<div class="container">
		<form action="<c:url value="/registro/add"/>" method="post">
			<fieldset>
				<legend>Adicionar Registro</legend>
				<jsp:include page="form.jsp" />
			</fieldset>
		</form>
	</div>
</body>
</html>