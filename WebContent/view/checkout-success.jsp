<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Checkout</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="description" content="Sublime project">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/bootstrap4/bootstrap.min.css">
	<link href="${pageContext.request.contextPath}/view/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/checkout.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/checkout_responsive.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<jsp:include page="menu.jsp"></jsp:include>

		<br/>
		<br/>
		<br/>

	<div class="checkout">
		<div class="container">
			<div class="row">

				<!-- Checkout success -->
				<div class="col-lg-6">
					<div class="billing checkout_section">
						<div class="section_title">Congratulation! Your order is
							processing.</div>

						<div class="button order_button">
							<a href="${pageContext.request.contextPath}/book-list">Continue Shopping</a>
							<button type="submit" />
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
<script src="${pageContext.request.contextPath}/view/plugins/greensock/TweenMax.min.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/greensock/TimelineMax.min.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/greensock/animation.gsap.min.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/easing/easing.js"></script>
<script src="${pageContext.request.contextPath}/view/plugins/parallax-js-master/parallax.min.js"></script>
<script src="${pageContext.request.contextPath}/view/js/checkout.js"></script>
</body>
</html>