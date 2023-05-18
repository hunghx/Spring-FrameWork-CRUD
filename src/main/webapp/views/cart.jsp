<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/5/2023
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<a href="/">Back to shop</a>
<h1>danh sách giỏ hàng</h1>
<table class="table table-bordered">
  <thead>
  <tr>
    <th scope="col">#</th>
    <th scope="col">Name</th>
    <th scope="col">Image</th>
    <th scope="col">price</th>
    <th scope="col">quantity</th>
    <th scope="col">total amount</th>
    <th scope="col" colspan="2">Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${listCart}" var="item" varStatus="count">
    <form action="/cartController/update">
    <tr>
      <input type="hidden" name="cdId" value="${item.id}"/>
      <td>${count.count}</td>
      <td>${item.name}</td>
      <td><img src="${item.imageUrl}" alt="${item.name}" width="100px"></td>
      <td>${item.price}</td>
      <td><input name="quantity" type="number" value="${item.quantity}"></td>
      <td>${item.price*item.quantity}</td>
      <td><button type="submit" class="btn btn-warning">Update</button></td>
      <td><a href="/cartController/delete/${item.id}" class="btn btn-danger">Delete</a></td>
    </tr>
    </form>
  </c:forEach>

  </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
