<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/5/2023
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới sinh viên</h1>
<form action="<%=request.getContextPath()%>/studentController/create" method="post">
<table border="1"  cellspacing="0" cellpadding="5">
    <tr>
        <td>Name</td>
        <td><input type="text" name="name" placeholder="enter new name ..."></td>
    </tr>
    <tr>
        <td>Age</td>
        <td><input type="number" name="age"></td>
    </tr>
    <tr>
        <td>Gen</td>
        <td><select name="sex" >
            <option value="1">Male</option>
            <option value="0">Female</option>
        </select></td>
    </tr>
    <tr>
        <td>Address</td>
        <td><input type="text" name="address" placeholder="enter address"></td>
    </tr>
    <tr>
        <td colspan="2"><button type="submit">ADD</button></td>
    </tr>
</table>
</form>
</body>
</html>
