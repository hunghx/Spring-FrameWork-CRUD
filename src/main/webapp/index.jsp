<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="<%=request.getContextPath()%>/userController/form-register">Đăng kí</a><br>
<a href="<%=request.getContextPath()%>/userController/form-login">Đăng nhập</a><br>
<a href="<%=request.getContextPath()%>/studentController/GetAll">Hello Servlet</a>
</body>
</html>