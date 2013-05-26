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
		<decorator:head />
	</head>
	<body>
		<decorator:body />
       	<script src="http://code.jquery.com/jquery.js" type="text/javascript"></script>
    	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js/" />" type="text/javascript"></script>
	</body>
</html>