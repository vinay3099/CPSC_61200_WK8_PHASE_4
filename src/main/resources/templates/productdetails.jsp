<html>
<head>
<title>Product Page</title>
<meta name="ctx" content="/" />
</head>
<body>

<h1>Product Details</h1>

<a th:href="@{/loadCart}" class="btn btn-primary">
	<img th:src="@{/images/shopping-cart.png}" style="width:2%"/>
</a>

	
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Add To Cart</th>
		</tr>
		
		        <tr th:each="product : ${products}">
                    <td th:text="${product.id}"></td>
                    <td th:text="${product.name}"></td>
                    <td> 
                    </td>
                    <td th:text="${product.price}"></td>
                    <td>
					<a th:href="@{/addToCart?id={id}(id=${product.id})}" class="btn btn-primary">Add To Cart</a>
                    </td>
                </tr>
		
	</table>

</body>
</html>