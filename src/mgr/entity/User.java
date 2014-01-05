package mgr.entity;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String userid;
	private String userpwd;
	private String username;
	private long userphone;
	private String userdesc;

	public User() {
		super();
	}

	public User(String userid, String userpwd, String username, long userphone,
			String userdesc) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.userphone = userphone;
		this.userdesc = userdesc;
	}

	public String toString() {
		return "[" + userid + ", " + username + "," + userphone + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getUserphone() {
		return userphone;
	}

	public void setUserphone(long userphone) {
		this.userphone = userphone;
	}

	public String getUserdesc() {
		return userdesc;
	}

	public void setUserdesc(String userdesc) {
		this.userdesc = userdesc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
