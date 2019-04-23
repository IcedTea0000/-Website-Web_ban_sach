<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Great Book List</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/bootstrap4/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/view/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/responsive.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>




	<!-- Home -->

	<div class="home">
		<div class="home_slider_container">

			<!-- Home Slider -->
			<div class="owl-carousel owl-theme home_slider">

			<!-- Slider Item -->
			<div class="owl-item home_slider_item">
				<div class="home_slider_background" style="background-image:url(${pageContext.request.contextPath}/view/images/ads/home_slider_1.jpg)"></div>
				<div class="home_slider_content_container">
					<div class="container">
						<div class="row">
							<div class="col">
								<div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- Slider Item -->
			<div class="owl-item home_slider_item">
				<div class="home_slider_background" style="background-image:url(${pageContext.request.contextPath}/view/images/ads/home_slider_3.jpg)"></div>
				<div class="home_slider_content_container">
					<div class="container">
						<div class="row">
							<div class="col">
								<div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
									<div class="home_slider_title">A new Online Shop experience.</div>
									<div class="home_slider_subtitle">Over 10,000+ headings in different genres.</div>
									<div class="button button_light home_button"><a href="#">Shop Now</a></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>	
		
				<!-- Home Slider Dots -->

				<div class="home_slider_dots_container">
					<div class="container">
						<div class="row">
							<div class="col">
								<div class="home_slider_dots">
									<ul id="home_slider_custom_dots"
										class="home_slider_custom_dots">
										<li class="home_slider_custom_dot active">01.</li>
										<li class="home_slider_custom_dot">02.</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		</div>

		<!-- Ads -->

		<div class="avds">
			<div
				class="avds_container d-flex flex-lg-row flex-column align-items-start justify-content-between">
				<div class="avds_small">
				<div class="avds_background" style="background-image:url(${pageContext.request.contextPath}/view/images/ads/ad-small.jpg)"></div>
			<div class="avds_small_inner">
				<div class="avds_discount_container">
					<img src="images/discount.png" alt="">
					<div>
						<div class="avds_discount">
							<div>20<span>%</span></div>
							<div>Discount</div>
						</div>
					</div>
				</div>
				<div class="avds_small_content">
					<div class="avds_title">On Sale</div>
					<div class="avds_link"><a href="${pageContext.request.contextPath}/offers">See More</a></div>
				</div>
			</div>
		</div>
				<div class="avds_large">
					<div class="avds_background"
						style="background-image: url(${pageContext.request.contextPath}/view/images/ads/ad-large.jpg)"></div>
					<div class="avds_large_container">
						<div class="avds_large_content">
							<div class="avds_title">Ship anywhere</div>
							<div class="avds_text">We will ship the good shit to you no
								matter where you are on the earth.</div>
							<div class="avds_link avds_link_large">
								<a href="categories.html">See More</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Products -->

		<div class="products">
			<div class="container">
				<div class="row">
					<div class="col">

						<div class="product_grid">
							<c:forEach var="book" items="${bookListFeatured}">
								<!-- Product -->
								<div class="product">
									<div class="product_image">
										<img
											src="${pageContext.request.contextPath}/download?folder=book&filename=${book.picture_name}"
											alt="" height="294.75" width="196.5">
									</div>
									<div class="product_extra product_new">
										<a href="#">${book.status}</a>
									</div>
									<div class="product_content">
										<div class="product_title">
											<a href="/GreatBookList/book-info?id=${book.id}">${book.title}</a>
										</div>
										<div class="product_price">$ ${book.price}</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>


		<jsp:include page="icon.jsp"></jsp:include>

		<!-- Newsletter -->

		<div class="newsletter">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="newsletter_border"></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-8 offset-lg-2">
						<div class="newsletter_content text-center">
							<div class="newsletter_title">Subscribe to our newsletter</div>
							<div class="newsletter_text">
								<p>This text really doesn't mean anything. So you should not
									take time reading it. However, if you make it here, you are an
									idiot.</p>
							</div>
							<div class="newsletter_form_container">
								<form action="#" id="newsletter_form" class="newsletter_form">
									<input type="email" class="newsletter_input"
										required="required">
									<button class="newsletter_button trans_200">
										<span>Subscribe</span>
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
		<script src="${pageContext.request.contextPath}/view/js/jquery-3.2.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/view/styles/bootstrap4/popper.js"></script>
		<script src="${pageContext.request.contextPath}/view/styles/bootstrap4/bootstrap.min.js"></script>
		<script	src="${pageContext.request.contextPath}/view/plugins/greensock/TweenMax.min.js"></script>
		<script	src="${pageContext.request.contextPath}/view/plugins/greensock/TimelineMax.min.js"></script>
		<script	src="${pageContext.request.contextPath}/view/plugins/scrollmagic/ScrollMagic.min.js"></script>
		<script	src="${pageContext.request.contextPath}/view/plugins/greensock/animation.gsap.min.js"></script>
		<script	src="${pageContext.request.contextPath}/view/plugins/greensock/ScrollToPlugin.min.js"></script>
		<script	src="${pageContext.request.contextPath}/view/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
		<script	src="${pageContext.request.contextPath}/view/plugins/Isotope/isotope.pkgd.min.js"></script>
		<script	src="${pageContext.request.contextPath}/view/plugins/easing/easing.js"></script>
		<script	src="${pageContext.request.contextPath}/view/plugins/parallax-js-master/parallax.min.js"></script>
		<script src="${pageContext.request.contextPath}/view/js/custom.js"></script>
</body>
</html>
