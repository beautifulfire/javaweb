package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import conn.Connect;
import domain.User;

public class ManDao {
	private Connection con;
	private Statement sql;
	private ResultSet rs;
	
    public User find(String name, String password) {
        try{
        	User user = null;
        	Connect conn = new Connect();
        	con = conn.getCon();
			
	 		sql = con.createStatement();
	 		//不能防止SQL注入
			/*rs = sql.executeQuery("SELECT * FROM manager WHERE username='"+name+"' and password='"+password+"'");*/
			//可以防止SQL注入
	 		rs = sql.executeQuery("SELECT * FROM manager");
	 		while(rs.next()){
	 			if (name.equals(rs.getString("username"))&&password.equals(rs.getString("password"))) {
					user = new User();
					user.setName(name);
					user.setPass(rs.getString("password"));
	 			}
			}
            con.close();
            return user;
        
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
