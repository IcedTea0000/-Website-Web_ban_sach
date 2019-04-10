<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>All Book List</title>
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
	href="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/animate.css">
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
	<!-- Products -->

	<div class="products">
		<div class="container">
			<div class="row">
				<div class="col">

					<!-- Product Sorting -->
					<div
						class="sorting_bar d-flex flex-md-row flex-column align-items-md-center justify-content-md-start">
						<div class="results">
							Showing <span>12</span> results
						</div>
						<div class="sorting_container ml-md-auto">
							<div class="sorting">
								<ul class="item_sorting">
									<li><span class="sorting_text">Sort by</span> <i
										class="fa fa-chevron-down" aria-hidden="true"></i>
										<ul>
											<li class="product_sorting_btn"
												data-isotope-option='{ "sortBy": "original-order" }'><span>Default</span></li>
											<li class="product_sorting_btn"
												data-isotope-option='{ "sortBy": "price" }'><span>Price</span></li>
											<li class="product_sorting_btn"
												data-isotope-option='{ "sortBy": "stars" }'><span>Name</span></li>
										</ul></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">

					<div class="product_grid">
						<!-- Product -->
						<c:forEach var="category" items="${categoryList}">

							<div class="product">
								<div class="product_image">
									<img
										src="${pageContext.request.contextPath}/download?folder=category&filename=${category.picture_name}"
										alt="">
								</div>
								<div class="product_extra product_new">
									<a href="categories.html">Tag</a>
								</div>
								<div class="product_content">
									<div class="product_title">
										<a href="/GreatBookList/category-info?id=${category.id}">Category ${category.name}</a>
									</div>
								</div>
							</div>
							
						</c:forEach>

					</div>
					<div class="product_pagination">
						<ul>
							<li class="active"><a href="#">01.</a></li>
							<li><a href="#">02.</a></li>
							<li><a href="#">03.</a></li>
						</ul>
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
							<img src="${pageContext.request.contextPath}/view/images/icon_1.svg" alt="">
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
							<img src="${pageContext.request.contextPath}/view/images/icon_2.svg" alt="">
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
							<img src="${pageContext.request.contextPath}/view/images/icon_3.svg" alt="">
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
	<script src="${pageContext.request.contextPath}/view/js/categories.js"></script>
</body>
</html>