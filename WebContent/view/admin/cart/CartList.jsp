<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Client Cart</title>
</head>
<body>
	<c:import url="../Menu.jsp"></c:import>
	<div>
		<table>
			<tr>
				<td>BOOK TITLE</td>
				<td>PRICE</td>
				<td>QUANTITY</td>
			</tr>
			<c:forEach var="item" items="${sessionScope.cartItemMap}">
				<tr>
					<td>${item.value.book.title} - ${item.value.book.author}</td>
					<td>${item.value.book.price}</td>
					<td>${item.value.quantityInCart}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<label>TOTAL PRICE</label>
		<span>$ ${sessionScope.totalPrice}</span>
	</div>
</body>
</html>