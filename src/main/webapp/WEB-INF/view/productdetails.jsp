<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Product Page</title>
</head>
<body>

<a href="${pageContext.request.contextPath }/loadCart?&action=loadCart">
	<img src="${pageContext.request.contextPath }/assets/images/shopping-cart.png" width="120"/>
</a>

	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Buy</th>
		</tr>
		<c:forEach var="product" items="${products }">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>
			<!-- 		<img src="${pageContext.request.contextPath }/assets/images/${product.photo }" width="120"/>  -->
				</td>
				<td>${product.price }</td>
				<td align="center">
					<a href="${pageContext.request.contextPath }/addTocart?&action=addToCart&id=${product.id}">Add To Cart</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>