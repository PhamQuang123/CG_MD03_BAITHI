<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/06/2024
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product/doAddNew" method="post">
    <div>
        <lable>Product Name:</lable>
        <input type="text" name="productName">
    </div>
    <div>
        <lable>Price:</lable>
        <input type="text" name="price">
    </div>
    <div>
        <lable>Quantity:</lable>
        <input type="text" name="quantity">
    </div>
    <div>
        <lable>Color:</lable>
        <select name="color" >
            <option value="Đỏ">Đỏ</option>
            <option value="Xanh">Xanh</option>
            <option value="Đen">Đen</option>
            <option value="Trắng">Trắng</option>
            <option value="Vàng">Vàng</option>
        </select>
    </div>
    <div>
        <lable>Descriptions:</lable>
        <input type="text" name="descriptions">
    </div>
    <div>
        <lable>Category:</lable>
            <select name="categoryId" >
                <c:forEach items="${listCategory}" var="c">

                <option value="${c.categoryId}">${c.categoryName}</option>
                </c:forEach>

            </select>
    </div>

    <button type="submit">Add New Product</button>
</form>
</body>
</html>
