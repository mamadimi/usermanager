<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>User Manager</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
<h1>Welcome to User Manager</h1>
<a href="<c:url value="/login" />">Log In</a> |
<a href="<c:url value="/register" />">Register</a>
</body>
</html>