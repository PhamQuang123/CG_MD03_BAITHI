<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/06/2024
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product/doUpdate" method="post">
  <div>
    <lable>Product Id:</lable>
    <input type="text" name="productId" value="${product.productId}">
  </div>
  <div>
    <lable>Product Name:</lable>
    <input type="text" name="productName" value="${product.productName}">
  </div>
  <div>
    <lable>Price:</lable>
    <input type="text" name="price" value="${product.price}">
  </div>
  <div>
    <lable>Quantity:</lable>
    <input type="text" name="quantity" value="${product.quantity}">
  </div>
  <div>
    <lable>Color:</lable>
    <select name="color" >
      <option value="${product.color}">${product.color}</option>
      <option value="Đỏ">Đỏ</option>
      <option value="Xanh">Xanh</option>
      <option value="Đen">Đen</option>
      <option value="Trắng">Trắng</option>
      <option value="Vàng">Vàng</option>
    </select>
  </div>
  <div>
    <lable>Descriptions:</lable>
    <input type="text" name="descriptions" value="${product.descriptions}">
  </div>
  <div>
    <lable>Category:</lable>
    <select name="categoryId" >
      <c:forEach items="${listCategory}" var="c">
        <option value="${c.categoryId}">${c.categoryName}</option>
      </c:forEach>>

    </select>
  </div>

  <button type="submit">Update Product</button>
</form>
</body>
</html>
