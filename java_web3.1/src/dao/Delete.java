package dao;

import java.sql.Connection;
import java.sql.Statement;

import conn.Connect;

public class Delete {
	private Connection con;
	private Statement sql;
	
	public void delete(String id) {
        try{
        	Connect conn = new Connect();
			con = conn.getCon();
			//创建Statement对象
			sql = con.createStatement();
			//执行SQL语句 
			sql.executeUpdate("delete from j_question where id='"+id+"'");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
