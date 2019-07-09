<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/8/2019
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="col-md-5 col-lg-5">
        <h1>Create new student</h1>
        <p>
            <a href="/">Back to student list</a>
        </p>
        <form:form method="post" modelAttribute="student" action="create">
            <fieldset>
                <legend>New student information</legend>
                <div class="form-group">
                    <label>Name: </label>
                    <form:input path="name" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Email: </label>
                    <form:input path="email" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Address: </label>
                    <form:input path="address" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>ClassRoom: </label>
                    <form:input path="classRoom" class="form-control"/>
                </div>
                <input type="submit" value="Create student" class="btn btn-default">
            </fieldset>
        </form:form>

    </div>
</div>

</body>
</html>

