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
					<!-- Product Counting -->
					<div class="sorting_bar d-flex flex-md-row flex-column align-items-md-center justify-content-md-start">
						<div class="results">Showing <span>${resultCount}</span> results</div>

					</div>
					<!-- Product List -->
					<div class="product_grid">
					
						<c:forEach var="book" items="${bookList}">
							<div class="product">
								<div class="product_image">
									<img
										src="${pageContext.request.contextPath}/view/images/book/${book.picture_name}"
										alt="" height="393" width="262">
								</div>
								<div class="product_extra product_new">
									<a href="#">${book.status}</a>
								</div>
								<div class="product_content">
									<div class="product_title">
										<a href="/GreatBookList/book-info?id=${book.id}">Title: ${book.title}</a>
									</div>
									<div class="product_price">Category:
										${book.category.name}</div>
									<div class="product_price">Price:${book.price}</div>
									<div class="product_price">Stock:${book.stock}</div>
									<div class="product_price">
									<a href="/GreatBookList/cart/add?book_id=${book.id}">Add to Cart</a>
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

<jsp:include page="icon.jsp"></jsp:include>

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


