<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Product Page</title>
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include><br>
	<br>

	<h1>All Product Data</h1>

	<div class="container table-responsive py-5">
		<table class="table table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Pid</th>
					<th scope="col">Product Name</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Category</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="p" items="${products}">
					<tr>
						<th scope="row">${p.pid}</th>
						<td>${p.name}</td>
						<td>${p.price}</td>
						<td>${p.qty}</td>
						<td>${p.category}</td>
						<td> <a href="view-product?pid=${p.pid}" class="btn btn-warning">UPDATE</a>&nbsp 
						
						
						<a href="delete-product?pid=${p.pid}" class="btn btn-danger">DELETE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>