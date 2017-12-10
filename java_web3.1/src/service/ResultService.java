package service;

import java.util.ArrayList;

import dao.ResultDao;
import dao.Qu_Length;
import domain.User;

public class ResultService {
	private ResultDao res  = new ResultDao();
	private Qu_Length qu  = new Qu_Length();
	
	public int nums (ArrayList<String>  jud) {
		return res.num(jud);
		
	}
	
	public void resultadd(User us,int num) {
		res.add(us, num);
	}
	
	public int length() {
		return qu.Length();
	}
}
