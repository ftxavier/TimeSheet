<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registros</title>
</head>
<body>
<div class="container">
	<c:set value="${registroMensal.registros}" var="registros"/>
	<table class="table table-bordered">
		<tr>
			<th>Data</th>
			<th>Entrada</th>
			<th>Sa&iacute;da</th>
			<th>Horas</th>
			<th>A&ccedil;&otilde;es</th>
		</tr>
		<c:forEach items="${registros}" var="registro">
			<tr>
		    	<td><fmt:formatDate value="${registro.entrada.time}" pattern="dd/MM/yyyy"/></td>
		    	<td><fmt:formatDate value="${registro.entrada.time}" pattern="HH:mm:ss"/></td>
		    	<td><fmt:formatDate value="${registro.saida.time}" pattern="HH:mm:ss"/></td>
		    	<td>${registro.horasTrabalhadas}</td>
		    	<td>
		    		<a href="${linkTo[RegistroController].edit[registro]}" class="btn btn-primary">Editar</a>
		    		<a href="${linkTo[RegistroController].delete[registro]}" class="btn btn-primary">Remover</a>
		    	</td>
		    </tr>
		</c:forEach>
			<tr>
		    	<td>&nbsp;</td>
		    	<td></td>
		    	<th>Total do Mês <fmt:formatDate value="${registroMensal.mesReferencia.time}" pattern="MM/yyyy"/>:</th>
		    	<td>${registroMensal}</td>
		    	<td></td>
		    </tr>
		<tfoot><tr><td colspan="5"><a href="${linkTo[RegistroController].novo}" class="btn btn-primary">Novo</a></td></tr></tfoot>
	</table>
</div>
</body>
</html>