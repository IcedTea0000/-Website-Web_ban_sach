<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search category</title>
</head>
<body>
	<div>
	<c:import url="../Menu.jsp"></c:import>	
		<div>
			<h1>Search for category</h1>
		</div>
		<form method="post" action="">
			<div>
				<input type="text" autofocus="autofocus" name="keyword"
					placeholder="what's on your mind..." />
			</div>
			<br />
			<div>
				<button type="submit">Search</button>
			</div>
		</form>
	</div>
</body>
</html>