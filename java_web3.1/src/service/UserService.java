package service;

import dao.Fn_grade;
import dao.UserDao;
import domain.User;

public class UserService{
	private UserDao userDao = new UserDao();
	private Fn_grade fngrade = new Fn_grade();
	public Boolean registerUser(User user) {
		if (userDao.find(user.getName(),user.getPass())==null&&user.getName()!=""&&user.getPass()!="") {
			userDao.add(user);
			return true;
		}
		else{
			return false;
		}
	}

	public User loginUser(String userName, String userPwd) {
		return userDao.find(userName, userPwd);
	}
	
	public User Usergrade(String name){
		return fngrade.find(name);
	}
}
