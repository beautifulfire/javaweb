<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增添</title>
<style>
.f{background-image:url(image/4.jpg)}
table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black;
}
</style>
</head>
<body class="f">
	<%
		String in = (String)session.getAttribute("ins");
		String ids = (String)session.getAttribute("ids");
		if (in != null) {
			out.println("请输入你要添加的信息");
		}	
		else {		
			out.println("请您先登陆，谢谢")	;
			out.println("经过3秒之后，将自动返回登录页面");
			response.setHeader("Refresh","3;URL=Login_m.jsp");	
		}
	%>
	<form action="servlet/insert" method="POST">
	<h1 align="center">	请输入你要添加的试题</h1>
	<table border="1" width="100%">
			<tr>
				<th>题号</th>	
				<th>题目</th>
				<th>答案1</th>
				<th>答案2</th>
				<th>正确答案</th>
			</tr>
			<tr>
				<%out.println("<th>"+ids+"</th>");%>
				<th><input type="text" name="jud_question" value=""/></th>
				<th><input type="text" name="answer1" value=""/></th>
				<th><input type="text" name="answer2" value=""/></th>
				<th><input type="text" name="rig_answer" value=""/></th>
		</table>
		<input type="submit" name="send" value="提交"/>
	</form>	
</body>
</html>