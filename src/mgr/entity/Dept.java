package mgr.entity;

import java.io.Serializable;

public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String deptid;
	private String deptparent;
	private String deptname;
	private String deptmgr;

	public Dept() {
		super();
	}

	public Dept(String deptid, String deptparent, String deptname,
			String deptmgr) {
		super();
		this.deptid = deptid;
		this.deptparent = deptparent;
		this.deptname = deptname;
		this.deptmgr = deptmgr;
	}

	public String toString() {
		return "[" + deptid + "," + deptparent + "," + deptname + "," + deptmgr
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDeptparent() {
		return deptparent;
	}

	public void setDeptparent(String deptparent) {
		this.deptparent = deptparent;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptmgr() {
		return deptmgr;
	}

	public void setDeptmgr(String deptmgr) {
		this.deptmgr = deptmgr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
