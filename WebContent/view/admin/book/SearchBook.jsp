<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Book</title>
</head>
<body>
	<div>
		<div>
			<h1>Search book</h1>
		</div>
		<div>
			<form method="post" action="">
				<div>
					<input type="text" name="keyword" value=""
						placeholder="what's on your mind..." autofocus="autofocus" />
				</div>
				<div>
					<div>CATEGORY</div>
					<div>
						<br /> <select name="categoryName">
							<c:forEach var="category" items="${categoryList}">
								<option value="${category.name}">${category.name}</option>
							</c:forEach>
							<option value="all">All</option>
						</select>
					</div>
					<div>
						<button type="submit">Search</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>