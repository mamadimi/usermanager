<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>User Register</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>User Register</h1>
	
	<form:form action="register" method="post" modelAttribute="user">
    <table>
      <tr>
        <th>Full name</th>
        <td>
          <form:input type="text" path="fullName" /> 
          <form:errors path="fullName" cssClass="error" />
         </td>
      </tr>
      
      <tr>
        <th>Email</th>
        <td>
            <form:input type="email" path="email" /> 
            <form:errors path="email" cssClass="error" />
         </td>
      </tr>
      
      <tr>
        <th>Phone</th>
        <td>
            <form:input type = "text" path="phone" /> 
         </td>
      </tr>
      
      <tr>
        <th>Company</th>
        <td>
            <form:input type="text" path="company" /> 
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
        <th>Password Confirmation</th>
        <td>
            <form:input type="password" path="passConfirm" /> 
            <form:errors path="passConfirm" cssClass="error" />
         </td>
      </tr>
      
      <tr>
        <td><button type="submit">Register</button></td>
      </tr>
    </table>
  </form:form>

</body>
</html>