<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Account</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/styles/bootstrap4/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/view/plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/contact.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/styles/contact_responsive.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Menu -->
	<jsp:include page="menu.jsp"></jsp:include>
<br/>
<br/>
		<!-- User info -->

	<div class="contact">
		<div class="container">
			<div class="row">

				<!-- Get in touch -->
				<div class="col-lg-8 contact_col">
					<div class="get_in_touch">
						<div class="section_title">${sessionScope.userAccount.username} 's Account</div>
						<div class="section_subtitle"></div>
								<div class="row">
									<div class="col-xl-6 last_name_col">
										<!-- Last Name -->
										<a href="${pageContext.request.contextPath}/user-update?id=${sessionScope.userAccount.id}">Update your info</a>
								</div>
									<div class="col-xl-6 last_name_col">
										<!-- Last Name -->
										<a href="${pageContext.request.contextPath}/order-history?userId=${sessionScope.userAccount.id}">Your order history</a>
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
	<script
		src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyCIwF204lFZg1y4kPSIhKaHEXMLYxxuMhA"></script>
	<script src="${pageContext.request.contextPath}/view/js/contact.js"></script>
</body>
</html>