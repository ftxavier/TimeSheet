<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
		
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
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>		
	</head>
	<body>
		<div class="container">
			<c:if test="${error}">
			    <h3><fmt:message key="login.invalido"/></h3>
			</c:if>
		
	      <form class="form-signin" method="post" action="<c:url value="j_spring_security_check" />">
	        <h2 class="form-signin-heading">Login</h2>
	        <input type="text" name="j_username"  placeholder="Usuário" class="input-block-level"/>
	        
	        <input type="password" name="j_password" placeholder="Senha" class="input-block-level">
	        <button type="submit" class="btn btn-large btn-primary">Login</button>
	      </form>
	
	    </div>
       	<script src="http://code.jquery.com/jquery.js" type="text/javascript"></script>
    	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js/" />" type="text/javascript"></script>
	</body>
</html>