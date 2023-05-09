<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/5/2023
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sinh viên</h1>
<a href="<%=request.getContextPath()%>/views/createStudent.jsp">Create new Student</a>
<table border="1" cellpadding="10" cellspacing="0">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Sex</th>
        <th>Address</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="st">
        <tr>
            <td>${st.getId()}</td>
            <td>${st.getName()}</td>
            <td>${st.getAge()}</td>
            <td>${st.isSex()?"Male":"Female"}</td>
            <td>${st.getAddress()}</td>
            <td><a href="<%=request.getContextPath()%>/studentController/edit?id=${st.id}">Edit</a></td>
            <td><a href="<%=request.getContextPath()%>/studentController/delete?id=${st.id}">Delete</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
