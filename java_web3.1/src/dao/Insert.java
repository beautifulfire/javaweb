package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import conn.Connect;

public class Insert {
	private Connection con;
	private Statement sql;
	
	public void add(String qu,String an1,String an2,String ran,String id) {
        try{
        	Connect conn = new Connect();
			con = conn.getCon();
			//创建Statement对象
			sql = con.createStatement();
			//执行SQL语句 
			sql.executeUpdate("insert into j_question values('"+qu+"','"+an1+"','"+an2+"','"+ran+"','"+id+"')");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
