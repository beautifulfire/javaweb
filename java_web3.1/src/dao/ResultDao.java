package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import conn.Connect;
import domain.User;

public class ResultDao {
	private Connection con;
	private Statement sql;
	private ResultSet rs;
	
	public int num(ArrayList<String>  jud){
		try{
        	Connect conn = new Connect();
        	con = conn.getCon();
			
	 		sql = con.createStatement();
	 		rs = sql.executeQuery("SELECT * FROM j_question");
	 		int nums=0;
	 		int i=0;
			while(rs.next()){
				String s = jud.get(i);
				if(s == null){
					s="";
				}
				if(s.equals("a")){
					String x=rs.getString("answer1");
					String y=rs.getString("rig_answer");
					if(x.equals(y)) nums++;
				}else if(s.equals("b")){
					String x=rs.getString("answer2");
					String y=rs.getString("rig_answer");
					if(x.equals(y)) nums++;
				}
				i++;
			}
            con.close();
            return nums;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	
	public void add(User us,int num) {
        try{
        	Connect conn = new Connect();
        	con = conn.getCon();
			sql = con.createStatement();
			rs = sql.executeQuery("SELECT * FROM s_grade WHERE username='"+us.getName()+"'");
			if(!rs.next()){
				sql.executeUpdate("insert into s_grade values('"+us.getName()+"','"+num+"')");
			}
			con.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
