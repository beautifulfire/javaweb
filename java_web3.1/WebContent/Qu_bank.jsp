<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="conn.*"%>
<%@ page import="domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>题库</title>
<style>
.d{background-image:url(../image/4.jpg)}
table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black;
}
</style>
</head>
<body class="d">
	<%
		User man = (User)session.getAttribute("Qu_user");
		if (man != null) {		
			out.println(man.getName()+" : 欢迎您的到来!");
		}else {		
			out.println("请您先登陆，谢谢");
			out.println("<br>经过3秒之后，将自动返回登陆页");
			response.setHeader("Refresh","3;URL=Login_m.jsp");	
		} 
	%>
	<% 
		Connection con;
		Statement sql;
		ResultSet rs;
	
		//连接数据库
		Connect conn = new Connect();
		con = conn.getCon();
		//创建Statement对象
		sql = con.createStatement();
		//执行SQL语句 
		rs = sql.executeQuery("SELECT * FROM j_question order by id asc");
	%>
		
	<form action="bank" method="POST">
	<h1 align="center">
		<input type="text" name="select" value=""/> 
		<input type="submit" name="se" value="查询"/>
		<input type="text" name="update" value=""/> 
		<input type="submit" name="up" value="修改"/>
		<input type="text" name="delete" value=""/>
		<input type="submit" name="de" value="删除"/>
		<input type="submit" name="in" value="增添"/>
		<input type="submit" name="out" value="退出"/>
	</h1>
	</form>

		<table border="1" width="100%">
			<tr>
				<th>题号</th>
				<th>题目</th>
				<th>答案1</th>
				<th>答案2</th>
				<th>正确答案</th>
			</tr>
			<%	
				String ids="1";
				while(rs.next())
				{
			%>		
				<tr>
					<% 
						out.println("<th>"+rs.getString("id")+"</th>");
						if(ids.equals(rs.getString("id"))){
							ids=rs.getString("id");
							int id=Integer.parseInt(ids)+1;
							ids =Integer.toString(id);
						}
			   			out.println("<th>"+rs.getString("jud_questions")+"</th>");
						out.println("<th>"+rs.getString("answer1")+"</th>");
						out.println("<th>"+rs.getString("answer2")+"</th>");
						out.println("<th>"+rs.getString("rig_answer")+"</th>");
					%>
				</tr>
			<%
				session.setAttribute("ids", ids);
				}
			%>	
		</table>
		
</body>
</html>