package mgr.entity;

import java.io.Serializable;

public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String postid;
	private String postname;
	private String postctn;
	private String deptid;

	public Post() {
		super();
	}

	public Post(String postid, String postname, String deptid) {
		super();
		this.postid = postid;
		this.postname = postname;
		this.deptid = deptid;
	}

	public String toString() {
		return "[" + postid + "," + postname + "," + deptid + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPostctn() {
		return postctn;
	}

	public void setPostctn(String postctn) {
		this.postctn = postctn;
	}

	public String getPostid() {
		return postid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
