package dao;

import java.sql.Connection;
import java.sql.Statement;

import conn.Connect;

public class Update {
	private Connection con;
	private Statement sql;
	
	public void update(String qu,String an1,String an2,String ran,String id) {
        try{
        	Connect conn = new Connect();
			con = conn.getCon();
			//创建Statement对象
			sql = con.createStatement();
			//执行SQL语句 
			sql.executeUpdate("update j_question set Jud_questions='"+qu+"',answer1='"+an1+"',answer2='"+an2+"',rig_answer='"+ran+"' where id='"+id+"'");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
