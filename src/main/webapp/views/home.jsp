<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/5/2023
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Đây là trang chủ</h1>
<a href="${userLogin!=null?'/cartController':'/userController/form-login'}">Giỏ hàng</a>
<p>Chào mừng khách hàng ${userLogin.username} đến trang web </p>
<h2>Danh sản phẩm</h2>
<div class="container">
    <div class="row">
        <c:forEach items="${listProduct}" var="pro">
            <div class="col-3">
                <div class="card" >
                    <img src="${pro.image_url}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${pro.name}</h5>
                        <p class="card-text">${pro.description}</p>
                        <p class="text-danger">${pro.price} $</p>
                        <c:set var="cart_url" value="/cartController/add-to-cart/${pro.id}"></c:set>
                        <a href="${userLogin!=null?cart_url:'/userController/form-login'}" class="btn btn-primary">Add to card</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <c:set var="page" value="${pageCurrent!=null?pageCurrent:1}"/>
    <nav aria-label="...">
        <ul class="pagination">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Previous</a>
            </li>
            <c:forEach items="${pageCount}" var="count" varStatus="loop">
                <li class="${page==loop.count?'active':''} page-item"><a class="page-link" href="/page/${loop.count}">${loop.count}</a></li>
            </c:forEach>

            <li class="page-item">
                <a class="page-link" href="#">Next</a>
            </li>
        </ul>
    </nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
