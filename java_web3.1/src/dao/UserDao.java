package dao;

import domain.User;
import md5.Md5JdkUtil;

import java.sql.*;
import conn.Connect;

public class UserDao {

	private Connection con;
	private Statement sql;
	private ResultSet rs;
	
    public User find(String name, String password) {
        try{
        	Md5JdkUtil md5 =new Md5JdkUtil();
			String pws= md5.md5jdk(password);
			
        	User user = null;
        	Connect conn = new Connect();
        	con = conn.getCon();
			
	 		sql = con.createStatement();
	 		//不能防止SQL注入
			/*rs = sql.executeQuery("SELECT * FROM t_users WHERE username='"+name+"' and passwords='"+pws+"'");*/
			//可以防止SQL注入
	 		rs = sql.executeQuery("SELECT * FROM t_users");
	 		while(rs.next()){
	 			if (name.equals(rs.getString("username"))&&pws.equals(rs.getString("passwords"))) {
					user = new User();
					user.setName(name);
					user.setPass(rs.getString("passwords"));
					user.setClasses(rs.getString("class"));
					user.setNum(rs.getString("stu_number"));
	 			}
			}
            con.close();
            return user;
        
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void add(User user) {
        try{
        	Md5JdkUtil md5 =new Md5JdkUtil();
			String pws= md5.md5jdk(user.getPass());
        	Connect conn = new Connect();
        	con = conn.getCon();
			String strSQL =  "INSERT INTO t_users VALUES ('"+user.getName()+"','"+pws+"','"+user.getClasses()+"','"+user.getNum()+"')";
			sql = con.createStatement();
			sql.executeUpdate(strSQL);
			con.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



