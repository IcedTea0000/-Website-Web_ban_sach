<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Order History</title>
</head>
<body>

					<c:forEach var="cartOrder" items="${cartOrderList}">
					<div>
						<div>
							<!-- Column Titles -->
							<div>
								<div >Cart Order #${cartOrder.id}</div>
								<div >Day Purchased ${cartOrder.dayBuy}</div>
								<div >Status ${cartOrder.status}</div>
							</div>
						</div>
					</div>
					
					<div>
						<div>
							<!-- Column Titles -->
							<div>
								<div>Book</div>
								<div>Price</div>
								<div>Quantity</div>
								<div>Total</div>
							</div>
						</div>
					</div>
					
					
					<!-- Cart Item -->
					<c:forEach var="item" items="${allCartItemMap}">
											<c:if test="${cartOrder.id eq item.key}">
						<c:forEach var="cartItem" items="${item.value}">

											<div>
												${cartItem.value.book.title}
											</div>

						</c:forEach>
					</c:if>
						
					</c:forEach>


				</c:forEach>
			
</body>
</html>