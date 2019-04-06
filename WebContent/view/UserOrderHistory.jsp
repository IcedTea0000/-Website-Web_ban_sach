<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Order History</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/styles/bootstrap4/bootstrap.min.css">
<link
	href="${pageContext.request.contextPath}/view/plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/styles/cart.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/styles/cart_responsive.css">
</head>
<body>

	<div class="super_container">
		<jsp:include page="header.jsp"></jsp:include>


		<!-- Menu -->

		<jsp:include page="menu.jsp"></jsp:include>

		<br /> <br /> <br />

		<!-- Cart Order Info -->

		<div class="cart_info">
			<div class="container">
				<div>
					<c:forEach var="cartOrder" items="${cartOrderList}"
					<div class="row">
						<div class="col">
							<!-- Column Titles -->
							<div class="cart_info_columns clearfix">
								<div class="cart_info_col cart_info_col_product">Cart Order #${cartOrder.id}</div>
								<div class="cart_info_col cart_info_col_price">Day Purchased ${cartOrder.day_buy}</div>
								<div class="cart_info_col cart_info_col_quantity">Status ${cartOrder.status}</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col">
							<!-- Column Titles -->
							<div class="cart_info_columns clearfix">
								<div class="cart_info_col cart_info_col_product">Book</div>
								<div class="cart_info_col cart_info_col_price">Price</div>
								<div class="cart_info_col cart_info_col_quantity">Quantity</div>
								<div class="cart_info_col cart_info_col_total">Total</div>
							</div>
						</div>
					</div>

					<!-- Cart Item -->
					<c:forEach var="item" items="${allCartItemMap}">
					<c:if test="${cartOrder.id eq item.key}">
					<c:forEach var="cartItemList" items="${allCartItemMap.value.cartItemList }"
						<div class="row cart_items_row">
							<div class="col">
								<div
									class="cart_item d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">
									<!-- Name -->
									<div
										class="cart_item_product d-flex flex-row align-items-center justify-content-start">
										<div class="cart_item_image">
											<div>
												<img width="100"
													src="${pageContext.request.contextPath}/view/images/book/${cartItemList.value.book.picture_name}"
													alt="">
											</div>
										</div>
										<div class="cart_item_name_container">
											<div class="cart_item_name">
												<a
													href="${pageContext.request.contextPath}/book-info?id=${cartItemList.value.book.id}">${cartItemList.value.book.title}
													- ${cartItemList.value.book.author}</a>
											</div>

										</div>
									</div>
									<!-- Price -->
									<div class="cart_item_price">${cartItemList.value.book.price}</div>
									<!-- Quantity -->
									<div class="cart_item_quantity">
										<div class="product_quantity_container">
											<div class="product_quantity clearfix">
												<span>Qty</span> <input id="quantity_input" type="text"
													pattern="[0-9]*" value="${cartItemList.value.quantityInCart}">
												<div class="quantity_buttons">
													<div id="quantity_inc_button"
														class="quantity_inc quantity_control">
														<i class="fa fa-chevron-up" aria-hidden="true"></i>
													</div>
													<div id="quantity_dec_button"
														class="quantity_dec quantity_control">
														<i class="fa fa-chevron-down" aria-hidden="true"></i>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- Total -->
									<div class="cart_item_total">${cartItemList.value.book.price*cartItemList.value.quantityInCart}</div>
								</div>
							</div>
						</div>
						</c:forEach>
						</c:if>
					</c:forEach>
				</div>
				</c:forEach>
				
				
				<div class="row row_cart_buttons">
					<div class="col">
						<div
							class="cart_buttons d-flex flex-lg-row flex-column align-items-start justify-content-start">
							<div class="button continue_shopping_button">
								<a
									href="${pageContext.request.contextPath}/book-list?categoryName=all&keyword=">Continue
									shopping</a>
							</div>
						</div>
					</div>
				</div>
				<div class="row row_extra">
					<div class="col-lg-4"></div>


				</div>
			</div>
		</div>


		<jsp:include page="footer.jsp"></jsp:include>
		<script
			src="${pageContext.request.contextPath}/view/js/jquery-3.2.1.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/view/styles/bootstrap4/popper.js"></script>
		<script
			src="${pageContext.request.contextPath}/view/styles/bootstrap4/bootstrap.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/view/plugins/greensock/TweenMax.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/view/plugins/greensock/TimelineMax.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/view/plugins/scrollmagic/ScrollMagic.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/view/plugins/greensock/animation.gsap.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/view/plugins/greensock/ScrollToPlugin.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/view/plugins/easing/easing.js"></script>
		<script
			src="${pageContext.request.contextPath}/view/plugins/parallax-js-master/parallax.min.js"></script>
		<script src="${pageContext.request.contextPath}/view/js/cart.js"></script>
</body>
</html>