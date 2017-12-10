package service;

import dao.ManDao;
import domain.User;

public class ManService {
	private ManDao mandao = new ManDao();

	public User loginman(String userName, String userPwd) {
		return mandao.find(userName, userPwd);
	}
}
