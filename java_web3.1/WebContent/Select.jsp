<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="conn.*"%>
<%@ page import="domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询</title>
<style>
.i{background-image:url(image/4.jpg)}
table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black;
}
</style>
</head>
<body class="i">
	<%
		String se = (String)session.getAttribute("ses");
		String id="";
		String question="";
		String answ1="";
		String answ2="";
		String rig_an="";
		if (se != null) {
			Connection con;
			Statement sql;
			ResultSet rs;
			try {
				//连接数据库
				Connect conn = new Connect();
				con = conn.getCon();
				//创建Statement对象
				sql = con.createStatement();
				//执行SQL语句 
				rs = sql.executeQuery("SELECT * FROM j_question");
				while(rs.next()){
					if(se.equals(rs.getString("id"))){
						id=rs.getString("id");
						question=rs.getString("jud_questions");
						answ1=rs.getString("answer1");
						answ2=rs.getString("answer2");
						rig_an=rs.getString("rig_answer");
					}
				}
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
		else {		
			out.println("请您先登陆，谢谢")	;
			out.println("经过3秒之后，将自动返回登录页面");
			response.setHeader("Refresh","3;URL=Login_m.jsp");	
		}
	%>
	<form action="servlet/select" method="POST">
	<h1 align="center">	请查看您查询的信息</h1>
	<table border="1" width="100%">
			<tr>
				<th>题号</th>	
				<th>题目</th>
				<th>答案1</th>
				<th>答案2</th>
				<th>正确答案</th>
			</tr>
			<tr>
				<%out.println("<th>"+id+"</th>");%>
				<%out.println("<th>"+question+"</th>");%>
				<%out.println("<th>"+answ1+"</th>");%>
				<%out.println("<th>"+answ2+"</th>");%>
				<%out.println("<th>"+rig_an+"</th>");%>
	</table>
	<input type="submit" name="back" value="返回"/>
	</form>	
</body>
</html>