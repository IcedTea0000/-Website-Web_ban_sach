<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Info</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/styles/bootstrap4/bootstrap.min.css">
<link
	href="${pageContext.request.contextPath}/view/plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/styles/product.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/styles/product_responsive.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/styles/categories.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/styles/categories_responsive.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Menu -->
	<jsp:include page="menu.jsp"></jsp:include>

	<br />
	<br />
	<!-- Product Details -->

	<div class="product_details">
		<div class="container">
			<div class="row details_row">

				<!-- Category Image -->
				<div class="col-lg-6">
					<div class="details_image">
						<div class="details_image_large">
							<img
								src="${pageContext.request.contextPath}/view/images/details_1.jpg"
								alt="">
							<div class="product_extra product_new">
								<a href="categories.html">New</a>
							</div>
						</div>
						<div
							class="details_image_thumbnails d-flex flex-row align-items-start justify-content-between">
							<div class="details_image_thumbnail active"
								data-image="images/details_1.jpg">
								<img
									src="${pageContext.request.contextPath}/view/images/details_1.jpg"
									alt="">
							</div>
							<div class="details_image_thumbnail"
								data-image="images/details_2.jpg">
								<img
									src="${pageContext.request.contextPath}/view/images/details_2.jpg"
									alt="">
							</div>
							<div class="details_image_thumbnail"
								data-image="images/details_3.jpg">
								<img
									src="${pageContext.request.contextPath}/view/images/details_3.jpg"
									alt="">
							</div>
							<div class="details_image_thumbnail"
								data-image="images/details_4.jpg">
								<img
									src="${pageContext.request.contextPath}/view/images/details_4.jpg"
									alt="">
							</div>
						</div>
					</div>
				</div>

				<!-- Category Content -->
				<div class="col-lg-6">
					<div class="details_content">
						<div class="details_name">${category.name}</div>
						<br />

						<div class="details_text">
							<p>${category.description}</p>
						</div>

						<!-- Share -->
						<div class="details_share">
							<span>Share:</span>
							<ul>
								<li><a href="#"><i class="fa fa-pinterest"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-instagram"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-facebook"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"
										aria-hidden="true"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<div class="row description_row">
				<div class="col">
					<div class="description_title_container">
						<div class="reviews_title">
							<a href="#">Reviews <span>(1)</span></a>
						</div>
					</div>
					<div class="description_text">
						<p></p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br />
	<!-- Products -->

	<div class="products">
		<div class="container">
			<div class="row">
				<div class="col">

					<!-- Product List -->
					<div class="product_grid">

						<c:forEach var="book" items="${bookList}">
							<div class="product">
								<div class="product_image">
									<img
										src="${pageContext.request.contextPath}/view/images/product_1.jpg"
										alt="">
								</div>
								<div class="product_extra product_new">
									<a href="">Tag</a>
								</div>
								<div class="product_content">
									<div class="product_title">
										<a href="/GreatBookList/book-info?id=${book.id}">Title: ${book.title}</a>
									</div>
									<div class="product_price">Price: ${book.price}</div>
									<div class="product_price">Stock: ${book.stock}</div>
									<div class="product_price">Option: </div>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Icon Boxes -->

	<div class="icon_boxes">
		<div class="container">
			<div class="row icon_box_row">

				<!-- Icon Box -->
				<div class="col-lg-4 icon_box_col">
					<div class="icon_box">
						<div class="icon_box_image">
							<img
								src="${pageContext.request.contextPath}/view/images/icon_1.svg"
								alt="">
						</div>
						<div class="icon_box_title">Free Shipping Worldwide</div>
						<div class="icon_box_text">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Nullam a ultricies metus. Sed nec molestie.</p>
						</div>
					</div>
				</div>

				<!-- Icon Box -->
				<div class="col-lg-4 icon_box_col">
					<div class="icon_box">
						<div class="icon_box_image">
							<img
								src="${pageContext.request.contextPath}/view/images/icon_2.svg"
								alt="">
						</div>
						<div class="icon_box_title">Free Returns</div>
						<div class="icon_box_text">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Nullam a ultricies metus. Sed nec molestie.</p>
						</div>
					</div>
				</div>

				<!-- Icon Box -->
				<div class="col-lg-4 icon_box_col">
					<div class="icon_box">
						<div class="icon_box_image">
							<img
								src="${pageContext.request.contextPath}/view/images/icon_3.svg"
								alt="">
						</div>
						<div class="icon_box_title">24h Fast Support</div>
						<div class="icon_box_text">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Nullam a ultricies metus. Sed nec molestie.</p>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>


	<br />
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
		src="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
	<script
		src="${pageContext.request.contextPath}/view/plugins/Isotope/isotope.pkgd.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/view/plugins/easing/easing.js"></script>
	<script
		src="${pageContext.request.contextPath}/view/plugins/parallax-js-master/parallax.min.js"></script>
	<script src="${pageContext.request.contextPath}/view/js/product.js"></script>
</body>
</html>