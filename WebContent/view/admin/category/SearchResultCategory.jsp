<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Category Result</title>
</head>
<body>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>CATEGORY NAME</th>
				<th>OPTION</th>
			</tr>
			<c:forEach var="category" items="${categoryList}">
				<tr>
					<th>${category.id}</th>
					<th>${category.name}</th>
					<th><a href="">Info</a> <a href="">Update</a> <a href="">Delete</a>
					</th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>