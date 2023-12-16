<html>
<head>
<title>Cart Page</title>
</head>
<body>
<h1>Cart Page</h1>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Option</th>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Sub Total</th>
		</tr>
		
		  <tr th:each="product : ${products}">
		  <td>
		  
		  <a th:href="@{/removeFromCart?id={id}(id=${product.id})}" class="btn btn-primary"
		  onclick="return confirm('Are you sure?')">Remove</a>
		  </td>
		  
                    <td th:text="${product.id}"></td>
                    <td th:text="${product.name}"></td>
                    <td> 
                    </td>
                    <td th:text="${product.price}"></td>
                    <td th:text="${product.price}"></td>
                </tr>
		<!-- 
		<tr>
			<td colspan="6" align="right">Total</td>
			<td>${total }</td>
		</tr>
		 -->
		
	</table>
	<br>
	
	 <a th:href="@{/getproducts}" class="btn btn-primary">Continue Shopping</a>

</body>
</html>