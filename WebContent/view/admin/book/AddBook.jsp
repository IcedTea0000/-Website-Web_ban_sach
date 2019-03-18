<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
</head>
<body>
	<div>
		<c:import url="../Menu.jsp"></c:import>	
		<div>
			<h1>Add new book</h1>
		</div>
		<div>
			<form method="post" action="">
				<div>
					TITLE <input type="text" name="title" value=""
						autofocus="autofocus" required="required" />
				</div>
				<div>
					DESCRIPTION <textarea type="text" name="description" cols="40" rows="10"
						required="required" ></textarea>
				</div>
				<div>
					PRICE <input type="text" name="price"
						placeholder="ex: 15.20; 5.70;..." value="" required="required" />
				</div>
				<div>
					AUTHOR <input type="text" name="author" value=""
						required="required" />
				</div>
				<div>
					STOCK <input type="text" name="stock" value="" required="required" />
				</div>
				<div>
					CATEGORY <br />
					<div>
						<select name="categoryName" required="required">
							<c:forEach var="category" items="${categoryList}">
								<option value="${category.name}">${category.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<br />
				<button type="submit">Add Book</button>
			</form>
		</div>
	</div>
</body>
</html>