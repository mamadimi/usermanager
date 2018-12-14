<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Login</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Login</h1>
	
	<c:if test="${not empty error}"><div>${error}</div></c:if>
	<c:if test="${not empty message}"><div>${message}</div></c:if>
	
	<form:form action="login" method="post" modelAttribute="loginUser">
    <table>

      <tr>
        <th>Email</th>
        <td>
            <form:input type="email" path="email" /> 
            <form:errors path="email" cssClass="error" />
         </td>
      </tr>

      <tr>
        <th>Password</th>
        <td>
            <form:input type="password" path="password" /> 
            <form:errors path="password" cssClass="error" />
         </td>
      </tr>

      
      <tr>
        <td><button type="submit">Login</button></td>
      </tr>
    </table>
  </form:form>

</body>
</html>