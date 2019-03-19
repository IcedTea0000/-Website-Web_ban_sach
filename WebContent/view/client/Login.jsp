<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div>
		<div>
			<h1>Login</h1>
		</div>
		<form method="post" action="">
			<div>
				USERNAME <input type="text" name="username" value="${param.username}"
					autofocus="autofocus" required="required" />
			</div>
			<br/>
			<div>
				PASSWORD <input type="password" name="password" value=""
					required="required" />
			</div>
			<div>${errorMessage}</div>
			<br />
			<button type="submit">Login</button>
		</form>
		<br />
		<div>
			Don't have an account yet? <a href="register">Register</a>
		</div>
	</div>
</body>
</html>