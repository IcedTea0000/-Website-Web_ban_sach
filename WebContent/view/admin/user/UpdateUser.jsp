<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
</head>
<body>
	<div>
	<c:import url="../Menu.jsp"></c:import>	
		<div>
			<h1>Update ${userToEdit.name} information</h1>
		</div>
		<div>
			<form method="post" action="update">
				<div>
					ID <input type="text" name="id" value="${userToEdit.id}"
						 contenteditable="false" />
				</div>
				<div>
					NAME <input type="text" name="name" value="${userToEdit.name}"
						required="required" autofocus="autofocus" />
				</div>
				<div>
					ADDRESS <input type="text" value="${userToEdit.address}"
						name="address">
				</div>
				<div>
					USERNAME <input type="text" name="username"
						value="${userToEdit.username}" required="required" />
				</div>
				<div>
					PASSWORD <input type="text" name="password"
						value="${userToEdit.password}" required="required" />
				</div>
				<div>
					ROLE <input type="text" name="role" value="${userToEdit.role}"
						contenteditable="false" />
				</div>
				<div>
					ABOUT YOU <br />
					<textarea rows="5" cols="20" name="info"
						placeholder="Tell us something about you">${userToEdit.info}</textarea>
				</div>
				<hr />
				<button type="submit">Update Information</button>
			</form>
		</div>
	</div>
</body>
</html>