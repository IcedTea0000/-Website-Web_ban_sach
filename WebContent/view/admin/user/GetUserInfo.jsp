<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
</head>
<body>
	<div>
		<c:import url="../Menu.jsp"></c:import>
		<div>
			<h1>${user.name}'sinfo</h1>
		</div>
		<div>ID: ${user.id}</div>
		<div>NAME: ${user.name}</div>
		<div>ADDRESS: ${user.address}</div>
		<div>USERNAME: ${user.username}</div>
		<div>PASSWORD: ${user.password}</div>
		<div>Role: ${user.role}</div>
		<div>INFO: ${user.info}</div>

	</div>
</body>
</html>