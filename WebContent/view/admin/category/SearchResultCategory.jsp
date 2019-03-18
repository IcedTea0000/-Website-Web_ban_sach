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
	<c:import url="../Menu.jsp"></c:import>	
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
					<th><a href="get-info?id=${category.id}" /> Info
					</a> <a href="update?id=${category.id}">Update</a>
						<a href="delete?id=${category.id}">Delete</a></th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>