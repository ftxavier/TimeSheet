<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Usu&aacute;rio ${usuario.name}</title>
</head>
<body>
	<div class="container">

		<form action="<c:url value="/usuario/save"/>" method="post">
			<input type="hidden" name="usuario.id" value="${usuario.id}">
			<fieldset>
				<legend>Alterar Usu&aacute;rio ${usuario.name}</legend>
				<jsp:include page="form.jsp" />
			</fieldset>
		</form>
	</div>
</body>
</html>