<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成绩</title>
<style>
.h{background-image:url(../image/3.jpg)}
</style>
</head>
<body>
<body class="h">
<%	
		User usgrade = (User)session.getAttribute("usgrade");
		if (usgrade != null) {		
			out.println(usgrade.getName()+" : 欢迎你的到来!");
			String num = usgrade.getGrade();
			out.println("<p>");
			out.println("你的成绩为"+num+"分");
		}
		else {		
			out.println("请你先登陆，谢谢");
			out.println("<br>经过3秒之后，将自动返回登录界面");
			response.setHeader("Refresh","3;URL=Login.jsp");	
		}
		
	%>
	<p>
		<form action="User_result.jsp" method="POST">
			<input type="submit" name="out" value="退出"/><br/>
		</form>
		<%
			request.setCharacterEncoding("UTF-8");
			String del = request.getParameter("out");
			if(del!=null){
				session.invalidate();
				response.sendRedirect("Login_user.jsp");
			}
		%>
</body>
</html>