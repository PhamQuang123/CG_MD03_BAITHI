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
<table>
  <thead>
  <tr>
    <th>STT</th>
    <th>Product Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Color</th>
    <th>Category</th>
    <th>Action</th>
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
        <a href="">Edit</a>
        </td>
      <td>
        <a href="">Delete</a>
      </td>
    </tr>
    <c:set var="i" value="${i+1}"></c:set>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
