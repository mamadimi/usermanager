<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Profile</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Hello ${user.fullName}</h1>
	
	
    <table>

      <tr>
        <th>Email</th>
        <td>
			${user.email}
         </td>
      </tr>
      
      <tr>
        <th>Phone</th>
        <td>
            ${user.phone}
         </td>
      </tr>
      
      <tr>
        <th>Company</th>
        <td>
            ${user.company}
         </td>
      </tr>


    </table>
	<a href="<c:url value="/logout" />">Log out</a> 

</body>
</html>