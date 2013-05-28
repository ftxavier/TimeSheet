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
			<th>Data</th>
			<th>Entrada</th>
			<th>Sa&iacute;da</th>
			<th>Horas</th>
			<th>A&ccedil;&otilde;es</th>
		</tr>
		<c:forEach items="${registroList}" var="registro">
			<tr>
		    	<td><fmt:formatDate value="${registro.entrada.time}" pattern="dd/MM/yyyy"/></td>
		    	<td><fmt:formatDate value="${registro.entrada.time}" pattern="HH:mm:ss"/></td>
		    	<td><fmt:formatDate value="${registro.saida.time}" pattern="HH:mm:ss"/></td>
		    	<td>${registro.totalHorasTrabalhadas}</td>
		    	<td><a href="${linkTo[RegistroController].edit[registro]}" class="btn btn-primary">Editar</a></td>
		    </tr>
		</c:forEach>
		<tfoot><tr><td colspan="5"><a href="${linkTo[RegistroController].novo}" class="btn btn-primary">Novo</a></td></tr></tfoot>
	</table>
</div>
</body>
</html>