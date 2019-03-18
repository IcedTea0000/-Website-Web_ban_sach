<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Category</title>
</head>
<body>
	<div>
	<c:import url="../Menu.jsp"></c:import>	
		<div>
			<h1>Update ${category.name}'s category</h1>
		</div>
		<div>
			<form method="post" action="">
				<div>
					ID <input type="text" name="id" value="${category.id}"
						contenteditable="false" />
				</div>
				<div>
					NAME <input type="text" name="name" value="${category.name}"
						autofocus="autofocus" />
				</div>
				<div>
					DESCRIPTION <br />
					<textarea name="description" cols="50" rows="10">${category.description}</textarea>
				</div>
				<br />
				<button type="submit">Update Category</button>
			</form>
		</div>
	</div>
</body>
</html>