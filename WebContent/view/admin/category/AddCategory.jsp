<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add category</title>
</head>
<body>
<div>
<c:import url="../Menu.jsp"></c:import>	
<h1>Add category</h1>
<div>
<form method="post" action="add">
<div>
NAME <input type="text" name="name" placeholder="new category" value="${category.name}" /> ${categoryNameExisted}
</div>
<div>
Description 
<br/>
<textarea name="description" cols="20" rows="8" placeholder="Category Description">${category.description}</textarea>
</div>
<hr/>
<button type="submit">Create Category</button>
</div>
</form>
</div>
</body>
</html>