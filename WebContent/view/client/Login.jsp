<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

	<h2>Dang Nhap He Thong</h2>
	
	<form action="/GreatBookList/login" method="post">
		<div style="height: 50px">
			<label>Tài khoản</label> 
			<input type="text" name="username" placeholder="Nhập tai khoan">
		</div>
		<div style="height: 50px">
			<label>Mật khẩu</label> 
			<input type="password" name="password" placeholder="Nhập mật khẩu">
		</div>
		<div>${errorMessage}</div>
		<input style="margin-left: 40px" type="submit" value="Đăng nhập">
	</form>
</body>
</html>