<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/06/2024
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/product/addNew">Add Product</a>
<form action="/product/search" method="post">
  <input type="text" name="productName">
  <button type="submit">Search</button>
</form>
<table border="1px solid red">
  <thead>
  <tr>
    <th>STT</th>
    <th>Product Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Color</th>
    <th>Descriptions</th>
    <th>Category</th>
    <th colspan="2">Action</th>
  </tr>
  </thead>
  <tbody>
  <c:set var="i" value="1"></c:set>
  <c:forEach items="${listProduct}" var="prod">
    <tr>
      <td>${i}</td>
      <td>${prod.productName}</td>
      <td>${prod.price}</td>
      <td>${prod.quantity}</td>
      <td>${prod.color}</td>
      <td>${prod.descriptions}</td>
      <td>${prod.category.getCategoryName()}</td>
      <td>
        <a href="/product/initUpdate?productId=${prod.productId}">Edit</a>
        </td>
      <td>
        <a href="/product/delete?productId=${prod.productId}" onclick="return confirm('Bạn có chắc muốn xoá không')">Delete</a>
      </td>
    </tr>
    <c:set var="i" value="${i+1}"></c:set>

  </c:forEach>
  </tbody>
</table>
</body>
</html>
