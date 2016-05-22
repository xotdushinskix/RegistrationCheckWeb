<%--
  Created by IntelliJ IDEA.
  User: FromxSoul
  Date: 22.05.2016
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Companies</title>
</head>
<body>
  <h3>All companies list:</h3>
  <table border="2">
    <thead>
    <tr>
      <th>Company Name</th>
      <th>Company Specific</th>
      <th>City Location</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${companies}" var="company1">
      <tr>
        <td>${company1.compName}</td>
        <td>${company1.compSpecific}</td>
        <td>${company1.cityLocation}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</body>
</html>
