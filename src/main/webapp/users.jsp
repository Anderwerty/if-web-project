<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=US-ASCII">
<title>Users</title>
</head>


<body>
<table>
 <tr>
   <th>id</th>
   <th>name</th>
   <th>email<th>
 </tr>
 <c:forEach items="${users}" var="user">
   <tr>
      <td> User id: <c:out value="${user.id}"/> </td>
      <td> User name: <c:out value="${user.name}"/> </td>
      <td> User email: <c:out value="${user.email}"/> </td>
   </tr>
 </c:forEach>


</table>

</body>
</html>