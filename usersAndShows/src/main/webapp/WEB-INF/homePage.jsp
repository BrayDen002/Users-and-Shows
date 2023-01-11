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
	<title>Welcome</title>
	
	<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>	
	
	
	<h1>Welcome,  <c:out value="${show.id}" /> 
	<c:out value="${user.full_name}"/></h1>
	<a href="/logout">Logout</a>
	
	<h1>TV Shows: </h1>
		<table class="table">
			<tr class="table-info">
				<th>Show</th>
				<th>Network</th>
			</tr>
			<c:forEach items="${shows}" var="show">
				<tr>
					<td><a href="/shows/<c:out value="${show.id}"/>"><c:out value="${show.title}" /></a></td>
					<td><c:out value="${show.network}" /></td>
				</tr>
			</c:forEach>
		</table>
	<a href="/shows">Add a Show</a>
</body>
</html>
