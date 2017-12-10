package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import conn.Connect;
import domain.User;

public class Fn_grade {
	private Connection con;
	private Statement sql;
	private ResultSet rs;
	
    public User find(String name) {
        try{
        	User user = null;
        	Connect conn = new Connect();
        	con = conn.getCon();
			
	 		sql = con.createStatement();
	 		
			rs = sql.executeQuery("SELECT * FROM s_grade WHERE username='"+name+"'");
			
			if (rs.next()) {
				user = new User();
				user.setName(name);
				user.setGrade(rs.getString("grade"));
			}
            con.close();
            return user;
        
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
