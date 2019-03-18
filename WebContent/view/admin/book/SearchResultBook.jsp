<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Result</title>
</head>
<body>
	<div>
	<c:import url="../Menu.jsp"></c:import>	
		<div>
			<h1>Search Result</h1>
		</div>
		<div>
			<table>
				<tr>
					<th>ID</th>
					<th>TITLE</th>
					<th>PRICE</th>
					<th>CATEGORY</th>
					<th>AUTHOR</th>
					<th>STOCK</th>
					<th>OPTION</th>
				</tr>
				<c:forEach var="book" items="${bookList}">
					<tr>
						<th>${book.id}</th>
						<th>${book.title}</th>
						<th>${book.price}</th>
						<th>${book.category.name}</th>
						<th>${book.author}</th>
						<th>${book.stock}</th>
						<th><a href="get-info?id=${book.id}" /> Info </a> <a
							href="update?id=${book.id}">Update</a> <a
							href="delete?id=${book.id}">Delete</a></th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>