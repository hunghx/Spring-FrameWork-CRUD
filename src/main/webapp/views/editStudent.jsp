<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/5/2023
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chỉnh sửa thông tin sinh viên</h1>
<form action="<%=request.getContextPath()%>/studentController/update" method="post">
  <table border="1"  cellspacing="0" cellpadding="5">
    <tr>
      <td>ID</td>
      <td><input readonly type="text" name="id" value="${student.id}"></td>
    </tr>
    <tr>
      <td>Name</td>
      <td><input type="text" name="name" value="${student.name}"></td>
    </tr>
    <tr>
      <td>Age</td>
      <td><input type="number" name="age" value="${student.age}"></td>
    </tr>
    <tr>
      <td>Gen</td>
      <td><select name="sex">
        <option value="true" ${student.sex?"selected":""} >Male</option>
        <option value="false" ${!student.sex?"selected":""}>Female</option>
      </select></td>
    </tr>
    <tr>
      <td>Address</td>
      <td><input type="text" name="address" value="${student.address}"></td>
    </tr>
    <tr>
      <td colspan="2"><button type="submit">UPDATE</button></td>
    </tr>
  </table>
</form>
</body>
</html>
