<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Info</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="description" content="Sublime project">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/bootstrap4/bootstrap.min.css">
	<link href="${pageContext.request.contextPath}/view/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/animate.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/product.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/product_responsive.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

<!-- Menu -->
	<jsp:include page="menu.jsp"></jsp:include>

<br/>
<br/>
<!-- Product Details -->

<div class="product_details">
	<div class="container">
		<div class="row details_row">

			<!-- Product Image -->
			<div class="col-lg-6">
				<div class="details_image">
					<div class="details_image_large"><img src="${pageContext.request.contextPath}/view/images/book/${book.picture_name}" alt=""><div class="product_extra product_new"><a href="categories.html">New</a></div></div>
					<div class="details_image_thumbnails d-flex flex-row align-items-start justify-content-between">
						<div class="details_image_thumbnail active" data-image="${pageContext.request.contextPath}/view/images/book/${book.picture_name}"><img src="${pageContext.request.contextPath}/view/images/book/${book.picture_name}" alt=""></div>
					</div>
				</div>
			</div>

			<!-- Product Content -->
			<div class="col-lg-6">
				<div class="details_content">
					<div class="details_name">${book.title}</div>
					<br/>
	
					<div class="details_price">Genre: ${book.category.name}</div>
					<br/>
					<div class="details_price">Author: ${book.author}</div>
					<br/>
					<div class="details_price">$ ${book.price}</div>

					<!-- In Stock -->
					<div class="in_stock_container">
						<div class="availability">Availability:</div>
						<span>${book.stock} left</span>
					</div>
					<div class="details_text">
						<p>${book.description}</p>
					</div>

					<!-- Product Quantity -->
					<div class="product_quantity_container">
						<div class="product_quantity clearfix">
							<span>Qty</span>
							<input id="quantity_input" type="text" pattern="[0-9]*" value="1">
							<div class="quantity_buttons">
								<div id="quantity_inc_button" class="quantity_inc quantity_control"><i class="fa fa-chevron-up" aria-hidden="true"></i></div>
								<div id="quantity_dec_button" class="quantity_dec quantity_control"><i class="fa fa-chevron-down" aria-hidden="true"></i></div>
							</div>
						</div>
						<div class="button cart_button"><a href="/GreatBookList/cart/add?book_id=${book.id}">Add to cart</a></div>
					</div>

					<!-- Share -->
					<div class="details_share">
						<span>Share:</span>
						<ul>
							<li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="row description_row">
			<div class="col">
				<div class="description_title_container">
					<div class="description_title">Description</div>
					<div class="reviews_title"><a href="#">Reviews <span>(1)</span></a></div>
				</div>
				<div class="description_text">
					<p>${book.description}</p>
				</div>
			</div>
		</div>
	</div>
</div>

<br/>

<jsp:include page="footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/view/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/view/styles/bootstrap4/popper.js"></script>
<script src="${pageContext.request.contextPath}/view/styles/bootstrap4/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/greensock/TweenMax.min.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/greensock/TimelineMax.min.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/greensock/animation.gsap.min.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/easing/easing.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/parallax-js-master/parallax.min.js"></script>
<script src="${pageContext.request.contextPath}/view/js/product.js"></script>
</body>
</html>