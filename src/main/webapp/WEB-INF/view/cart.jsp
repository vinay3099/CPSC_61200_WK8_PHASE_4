<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Cart Page</title>
</head>
<body>

	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Option</th>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
		<!-- 	<th>Quantity</th>  -->
			<th>Sub Total</th>
		</tr>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="item" items="${products}">
			<c:set var="total" value="${total + item.price}"></c:set>
			<tr>
				<td align="center">
					<a href="${pageContext.request.contextPath }/removeFromCart?action=remove&id=${item.id }"
					onclick="return confirm('Are you sure?')">Remove</a>
				</td>
				<td>${item.id }</td>
				<td>${item.name }</td>
				<td>
				<!-- 	<img src="${pageContext.request.contextPath }/assets/images/${item.product.photo }" width="120">  -->
				</td>
				<td>${item.price }</td>
			<!-- 	<td>${item.quantity }</td>  -->
				<td>${item.price }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">Total</td>
			<td>${total }</td>
		</tr>
	</table>
	<br>
	<a href="${pageContext.request.contextPath }/product">Continue Shopping</a>

</body>
</html>