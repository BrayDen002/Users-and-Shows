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
<meta charset="ISO-8859-1">
<title>Editing A Show</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		
		<h1>Editing Title: <c:out value="${shows.title} " /></h1>
		
		<form:form class="form" action="/shows/${showObj.id}/edit"  method="post" modelAttribute="showObj">
			<form:input value="${user_id}" path="user" type="hidden"/>
			<div class="form-group row">	
				<form:label path="title" type="text">Title</form:label>
				<form:input path="title" />
				<form:errors path="title" />
			</div>
			<div class="form-group row">	
				<form:label path="network" type="text">Network</form:label>
				<form:input path="network" />
				<form:errors path="network" />
			</div>
			<div class="form-group row">	
				<form:label path="description" type="text">Description</form:label>
				<form:input path="description" />
				<form:errors path="description" />
			</div>
			<a href="/home">Cancel</a>
			<input type="submit" value="Submit" class="btn btn-primary" />
			
		</form:form>
		
			<a href="/shows/${showObj.id}/delete">DELETE</a>
			
	</div>
</body>
</html>