<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/styles/bootstrap4/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/view/plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/checkout.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/styles/checkout_responsive.css">
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

	<div class="checkout">
		<div class="container">
			<div class="row">
				<!-- Register -->
				<div class="col-lg-6">
					<div class="billing checkout_section">
						<div class="section_title">Register</div>
						<div class="section_subtitle">Enter your account info</div>
						<div class="checkout_form_container">
							<form action="" method="post" class="checkout_form" enctype="multipart/form-data">
								<div class="row">
									<div class="col-xl-6">
										<!-- Name -->
										<label for="name">NAME*</label> <input type="text"
											class="checkout_input" required="required" name="name"
											value="${param.name}" autofocus="autofocus" />
									</div>
									<div class="col-xl-6">
										<!-- Address -->
										<label for="address">ADDRESS*</label> <input type="text"
											class="checkout_input" required="required" name="address"
											value="${param.address}" />
									</div>

									<div class="col-xl-6">
										<!-- Username -->
										<label for="login_username">USERNAME*</label> <input
											type="text" class="checkout_input" required="required"
											name="username" value="${param.username}" />
									</div>
									<div class="col-xl-6">
										<!-- Password -->
										<label for="login_password">PASSWORD*</label> <input
											type="password" name="password" class="checkout_input"
											required="required">
									</div>
									<div class="col-xl-6">
										<!-- About You -->
										<label for="info">ABOUT YOU</label>
										<textarea class="contact_input contact_textarea"  
											name="info" placeholder="Tell us something about you">${param.info}</textarea>
									</div>
									<div class="col-xl-6">
									<label for="picture">PICTURE</label>
									<input class="checkout_input" type="file" name="picture_name" required="required"/>
									</div>

									<div align="center">
								
										<button type="submit" class="button contact_button">
											<span>CREATE ACCOUNT</span>
										</button>
					
									</div>
								</div>
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