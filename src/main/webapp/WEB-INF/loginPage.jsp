<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="ISO-8859-1">
<title>Login Here</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class="col-sm-5 offset-sm-2">
                <h2>Login</h2>
    			<p><c:out value="${error}" /></p>
                <form action="/login" method="post">
                    <div class="row mb-4">
                    	<p>
                        	<label for="email" class="col-sm-4">Email:</label>
                        	<input type="text" name="email" id="email" class="border border-3 border-dark form-control"/>
                        </p>
                        </div>
                    
                    <div class=" row mb-4">
                    	<p>
                        	<label for="password" class="col-sm-4">Password:</label>
                            <input type="password" name="password" id="password" class="border border-3 border-dark form-control">
						</p>
                        </div>
                    <input type="submit" value="Login" class="col-sm-4 offset-sm-8 btn btn-primary ">
                </form>
                <a href="/registration">Don't have an account? Register here</a>
			</div>
</body>
</html>