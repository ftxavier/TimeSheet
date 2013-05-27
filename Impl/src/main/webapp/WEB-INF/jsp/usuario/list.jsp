<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usu&aacute;rios</title>
</head>
<body>
<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>Login</th>
			<th>Nome</th>
		</tr>
		<c:forEach items="${usuarioList}" var="usuario">
			<tr>
		    	<td><a href="${linkTo[UsuarioController].edit[usuario]}">${usuario.login}</a></td><td>${usuario.name} </td>
		    </tr>
		</c:forEach>
		<tfoot><tr><td colspan="2"><a href="${linkTo[UsuarioController].novo}" class="btn btn-primary">Novo</a></td></tr></tfoot>
	</table>
</div>
</body>
</html>