<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/5/2023
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Register</h1>
<form action="<%=request.getContextPath()%>/userController/register" method="post">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td>username</td>
            <td><input type="text" name="username"></td>
                        <span>${username}</span>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="text" name="password"></td>
            <span>${password}</span>
        </tr>
        <tr>
            <td>confirm password</td>
            <td><input type="text" name="confirm-password"></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">Register</button></td>
        </tr>
    </table>
</form>
</body>
</html>
