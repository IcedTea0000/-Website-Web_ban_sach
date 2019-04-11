<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Cart</title>
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

		<!-- Cart Info -->

		<div class="cart_info">
			<div class="container">
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
				
				<c:forEach var="item" items="${cartItemMap}">
				<form action="${pageContext.request.contextPath}/cart/update-quantity" method="post">
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
												src="${pageContext.request.contextPath}/view/images/book/${item.value.book.picture_name}"
												alt="">
										</div>
									</div>
									<div class="cart_item_name_container">
										<div class="cart_item_name">
											<a
												href="${pageContext.request.contextPath}/book-info?id=${item.value.book.id}">${item.value.book.title}
												- ${item.value.book.author}</a>
										</div>
										<div>
											<a
												href="${pageContext.request.contextPath}/cart/delete?cart-item-id=${item.value.id}">Delete
												Item</a>
											<span> - </span>
											<form method="get" action="${pageContext.request.contextPath}/cart/update">	
											<button type="submit">Update Quantity</button>
											<input hidden="true" name="bookId" value=${item.value.book.id} />
											
										</div>

									</div>
								</div>
								<!-- Price -->
								<div class="cart_item_price">${item.value.book.price}</div>
								<!-- Quantity -->
								<div class="cart_item_quantity">
									<div class="product_quantity_container">
										<div class="product_quantity clearfix">
											<span>Qty</span> <input id="quantity_input" name="quantity_input" type="text"
												pattern="[0-9]*" value="${item.value.quantityInCart}">
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
								</form>
								
								<!-- Total -->
								<div class="cart_item_total">${item.value.book.price*item.value.quantityInCart}</div>



							</div>
						</div>
					</div>
					</form>
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
							<div class="cart_buttons_right ml-lg-auto">
								<div class="button clear_cart_button">
									<a href="#">Clear cart</a>
								</div>
								<div class="button update_cart_button">
									<a href="#">Update cart</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row row_extra">
					<div class="col-lg-4">

						<!-- Delivery -->
						<div class="delivery">
							<div class="section_title">Shipping method</div>
							<div class="delivery_options">
								<label class="delivery_option clearfix">Standard
									delivery <input type="radio" name="radio" checked="checked">
									<span class="checkmark"></span> <span class="delivery_price">Free</span>
								</label>
							</div>
						</div>

						<!-- Coupon Code -->
						<div class="coupon">
							<div class="section_title">Coupon code</div>
							<div class="section_subtitle">Enter your coupon code</div>
							<div class="coupon_form_container">
								<form action="#" id="coupon_form" class="coupon_form">
									<input type="text" class="coupon_input" required="required">
									<button class="button coupon_button">
										<span>Apply</span>
									</button>
								</form>
							</div>
						</div>
					</div>

					<div class="col-lg-6 offset-lg-2">
						<div class="cart_total">
							<div class="section_title">Cart total</div>
							<div class="section_subtitle">Final info</div>
							<div class="cart_total_container">
								<ul>
									<li
										class="d-flex flex-row align-items-center justify-content-start">
										<div class="cart_total_title">Subtotal</div>
										<div class="cart_total_value ml-auto">${sessionScope.totalPrice}</div>
									</li>
									<li
										class="d-flex flex-row align-items-center justify-content-start">
										<div class="cart_total_title">Shipping</div>
										<div class="cart_total_value ml-auto">Free</div>
									</li>
									<li
										class="d-flex flex-row align-items-center justify-content-start">
										<div class="cart_total_title">Total</div>
										<div class="cart_total_value ml-auto">${sessionScope.totalPrice}</div>
									</li>
								</ul>
							</div>
							<div class="button checkout_button">
								<a href="${pageContext.request.contextPath}/cart/checkout">Proceed
									to checkout</a>
							</div>
						</div>
					</div>
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