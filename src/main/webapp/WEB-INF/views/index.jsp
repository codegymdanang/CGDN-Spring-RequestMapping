<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/8/2019
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Products List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Students</h1>
    <p>
        <c:if test='${requestScope["success"] != null}'>
            <span class="message">${requestScope["success"]}</span>
        </c:if>
    </p>
    <p>
        <a href="Student/create">Create new student</a>
    </p>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>ClassRoom</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.address}</td>
                <td>${student.classRoom}</td>
                <td><a href="Student/edit/${student.id}">edit</a></td>
                <td><a href="Student/delete/${student.id}">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>

