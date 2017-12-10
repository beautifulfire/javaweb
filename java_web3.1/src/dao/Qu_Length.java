package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import conn.Connect;

public class Qu_Length {
	private Connection con;
	private Statement sql;
	private ResultSet rs;
	
	public int Length(){
		try{
        	Connect conn = new Connect();
        	con = conn.getCon();
			
	 		sql = con.createStatement();
	 		rs = sql.executeQuery("SELECT * FROM j_question");
	 		int i=1;
			while(rs.next()){
				i++;
			}
            con.close();
            return i;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
}
