<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<div>
		<div>
			<h1>Register</h1>
		</div>
		<div>
			<form method="post" action="">
				<div>
					NAME <input type="text" name="name" value="${param.name}" required="required" autofocus="autofocus" />
				</div>
				<div>
					ADDRESS <input type="text" value="${param.address}" name="address">
				</div>
				<div>
					USERNAME <input type="text" name="username" value="${param.username}" required="required" />
					${checkUserExisted}
				</div>
				<div>
					PASSWORD <input type="text" name="password" required="required" />
				</div>
				<div>
					ABOUT YOU <br />
					<textarea rows="5" cols="20" name="info" placeholder="Tell us something about you" >${param.info}</textarea>
				</div>
				<hr />
				<button type="submit">Submit Information</button>
			</form>
		</div>
	</div>
</body>
</html>