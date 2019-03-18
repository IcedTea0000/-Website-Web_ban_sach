<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Book</title>
</head>
<body>
	<div>
	<c:import url="../Menu.jsp"></c:import>	
		<div>
			<h1>Update Book Info</h1>
		</div>
		<div>
			<form method="post" action="">
				<div>
					ID <input name="id" value="${oldBook.id}" type="text"
						readonly="readonly" />
				</div>
				<div>
					TITLE <input name="title" value="${oldBook.title}" type="text" />
				</div>
				<div>
					DESCRIPTION
					<br/>
					<textarea rows="10" cols="40" name="description">${oldBook.description}</textarea>
				</div>
				<div>
					AUTHOR <input name="author" value="${oldBook.author}" type="text" />
				</div>
				<div>
					PRICE <input name="price" value="${oldBook.price}" type="text" />
				</div>
				<div>
					OLD CATEGORY: ${oldBook.category.name} <br /> 
					NEW CATEGORY <br/>
					<select name="categoryId" required="required">
						<c:forEach var="category" items="${categoryList}">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
					</select>
				</div>
				<div>
					STOCK <input name="stock" value="${oldBook.stock}" type="text" />
				</div>
				<br />
				<button type="submit">Update Book</button>
			</form>
		</div>


	</div>
</body>
</html>