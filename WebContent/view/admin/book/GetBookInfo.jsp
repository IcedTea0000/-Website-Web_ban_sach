<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Info</title>
</head>
<body>
<div>
<c:import url="../Menu.jsp"></c:import>	
<div><h1>${book.title}'s information</h1></div>
<div>ID: ${book.id}</div>
<div>TITLE: ${book.title}</div>
<div>DESCRIPTION: ${book.description}</div>
<div>AUTHOR: ${book.author}</div>
<div>PRICE:$ ${book.price}</div>
<div>CATEGORY: ${book.category.name}</div>
<div>STOCK: ${book.stock}</div>
</div>
</body>
</html>