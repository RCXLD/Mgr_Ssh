package mgr.service;

import javax.annotation.Resource;

import mgr.dao.UserDaoImpl;
import mgr.entity.User;

@Resource(name = "UserDaoImpl")
public class UserServiceImpl {

	private UserDaoImpl userDao;

	public User login(String userid, String userpwd) throws Exception {
		return userDao.verify(userid, userpwd);
	}

	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

}
