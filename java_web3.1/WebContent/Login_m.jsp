<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<style>
.b{background-image:url(image/2.png)}
</style>
</head>
<body Class="b">
	<div class="shuru">
		<form action="servlet/login_m" method="POST">
			姓名: <input type="text" name="Name" /><br/> 
			密码: <input type="password" name="Password"/><br/> 
			<input type="submit" value="登录"/><br/>
		</form>
		<input type="button" value="返回" onClick="window.location.href='Login_user.jsp'">
	</div>
</body>
</html>