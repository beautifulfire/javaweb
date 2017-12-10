<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="conn.*"%>
<%@ page import="domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>答题</title>
<style>
.a{background-image:url(../image/3.jpg)}
</style>
</head>
<body Class="a">
<%	
		User us = (User)session.getAttribute("user");
		if (us != null) {		
			out.println(us.getName()+" : 欢迎你的到来!请进行答题");
			out.println("<form action=result method=post name=form>");
			Connection con;
			Statement sql;
			ResultSet rs;
			
			Connect conn = new Connect();
			con = conn.getCon();
			//创建Statement对象
			sql = con.createStatement();
			//执行SQL语句 
			rs = sql.executeQuery("SELECT * FROM j_question order by id asc");
			
			int i=1;
			while(rs.next()){
				out.println("<p>");
				out.println(rs.getString("id"));
				out.println(".");
				out.println(rs.getString("jud_questions"));
				out.println("<br />");
				out.println(" <tr><td>"+"<input type=radio name=jud"+i+" value=a>"+rs.getString("answer1")+"</td></tr>");
				out.println(" <tr><td>"+"<input type=radio name=jud"+i+" value=b>"+rs.getString("answer2")+"</td></tr>");
				i++;
			}
			out.println("<p>");
			out.println("<input type=submit name=submit value=提交答案>");
			out.println("</form>");
		}else {		
			out.println("请你先登陆，谢谢");
			out.println("<br>经过3秒之后，将自动返回登录页");
			response.setHeader("Refresh","3;URL=Login.jsp");	
		} 	
	%>
</body>
</html>