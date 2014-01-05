package mgr.action;

import mgr.entity.User;
import mgr.service.UserServiceImpl;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

@Component
public class UserAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private UserServiceImpl userService;

	private User user;

	private String loginInfo;

	public String login() {
		System.out.println("login...");
		System.out.println("userid=" + user.getUserid() + ", pwd="
				+ user.getUserpwd());
		if (hasMessage) {
			return "Error";
		}
		try {
			User u = userService.login(user.getUserid(), user.getUserpwd());
			if (u != null) {
				user = u;
				session.put("user", user);
				loginInfo = "LoginSuccess";
			} else {
				loginInfo = "用户名或密码错误";
			}
		} catch (Exception e) {
			loginInfo = "Error";
			e.printStackTrace();
			return "Error";
		}
		System.out.println("loginInfo=" + loginInfo);
		return "LoginInfo";
	}

	public String exit() {
		System.out.println("exit...");
		session.put("user", null);
		session.clear();
		return "ExitInfo";
	}

	public User getUser() {
		return user;
	}

	@JSON(serialize = false)
	public UserServiceImpl getUserService() {
		return userService;
	}

	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(String loginInfo) {
		this.loginInfo = loginInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
