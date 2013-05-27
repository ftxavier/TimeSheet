<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta charset="utf-8">
		<title>TimeSheet [<decorator:title default="Home" />]</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
	    <link href="<c:url value="/resources/bootstrap/css/bootstrap-responsive.css" />" rel="stylesheet">
	    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
		<decorator:head />
	</head>
	<body>
		<div class="navbar navbar-inverse navbar-fixed-top">
	      <div class="navbar-inner">
	        <div class="container">
	          <button data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar" type="button">
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a href="#" class="brand">TimeSheet</a>
	          <div class="nav-collapse collapse">
	          	<sec:authorize access="isAuthenticated()">
		            <ul class="nav">
		              <li class="active"><a href="<c:url value="/" />">Home</a></li>
		              <li><a href="<c:url value="/usuario/" />">Usuários</a></li>
		              <li><a href="<c:url value="/registro/" />">Registros</a></li>
		              <li><a href="<c:url value="/logout" />">Logout</a></li>
		            </ul>
	            </sec:authorize>
	          </div><!--/.nav-collapse -->
	        </div>
	      </div>
	    </div>
    	<decorator:body />
    	<script src="<c:url value="/resources/js/jquery-1.10.0.min.js" />" type="text/javascript"></script>
    	<script src="<c:url value="/resources/js/jquery.maskedinput.min.js" />" type="text/javascript"></script>
    	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
    	<script src="<c:url value="/resources/js/main.js" />" type="text/javascript"></script>
	</body>
</html>