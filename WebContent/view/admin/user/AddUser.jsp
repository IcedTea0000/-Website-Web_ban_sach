<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New User</title>
</head>
<body>
	<div>
	<c:import url="../Menu.jsp"></c:import>	
		<div>
			<h1>Add new user</h1>
		</div>
		<div>
			<form method="post" action="add">
				<div>
					NAME <input type="text" name="name" value="${param.name}" required="required" autofocus="autofocus" />
				</div>
				<div>
					ADDRESS <input type="text" value="${param.address}" name="address">
				</div>
				<div>
					USERNAME <input type="text" name="username" value="${param.username}" required="required" />
					${checkUserExisted}
				</div>
				<div>
					PASSWORD <input type="text" name="password" required="required" />
				</div>
				<div>
					ROLE <br /> ADMIN <input type="radio" name="role" value="admin">
					MEMBER <input type="radio" name="role" value="member"
						checked="checked">
				</div>
				<div>
					ABOUT YOU <br />
					<textarea rows="5" cols="20" name="info" placeholder="Tell us something about you" >${param.info}</textarea>
				</div>
				<hr />
				<button type="submit">Submit Information</button>
			</form>
		</div>
	</div>
</body>
</html>