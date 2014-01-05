package mgr.entity;

import java.io.Serializable;

public class Emp implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String empid;
	private String empname;
	private String deptid;
	private String icid;
	private String eplace;
	private String empphone;
	private String empbirth;
	private String empsex;
	private String empedu;
	private String empqq;
	private String emptech;
	private String elinkman;
	private String elinkphone;
	private String emppost;
	private String empaddr;
	private String empin;
	private String empout;

	public Emp() {
		super();
	}

	public Emp(String empid, String empname, String deptid, String icid,
			String eplace, String empphone, String empbirth, String empsex,
			String empedu, String empqq, String emptech, String elinkman,
			String elinkphone, String emppost, String empaddr, String empin,
			String empout) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.deptid = deptid;
		this.icid = icid;
		this.eplace = eplace;
		this.empphone = empphone;
		this.empbirth = empbirth;
		this.empsex = empsex;
		this.empedu = empedu;
		this.empqq = empqq;
		this.emptech = emptech;
		this.elinkman = elinkman;
		this.elinkphone = elinkphone;
		this.emppost = emppost;
		this.empaddr = empaddr;
		this.empin = empin;
		this.empout = empout;
	}

	public String toString() {
		return "[" + empid + ", " + empname + ", " + ", " + icid + ", "
				+ deptid + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getEplace() {
		return eplace;
	}

	public void setEplace(String eplace) {
		this.eplace = eplace;
	}

	public String getIcid() {
		return icid;
	}

	public void setIcid(String icid) {
		this.icid = icid;
	}

	public String getEmpphone() {
		return empphone;
	}

	public void setEmpphone(String empphone) {
		this.empphone = empphone;
	}

	public String getEmpbirth() {
		return empbirth;
	}

	public void setEmpbirth(String empbirth) {
		this.empbirth = empbirth;
	}

	public String getEmpsex() {
		return empsex;
	}

	public void setEmpsex(String empsex) {
		this.empsex = empsex;
	}

	public String getEmpedu() {
		return empedu;
	}

	public void setEmpedu(String empedu) {
		this.empedu = empedu;
	}

	public String getEmpqq() {
		return empqq;
	}

	public void setEmpqq(String empqq) {
		this.empqq = empqq;
	}

	public String getEmptech() {
		return emptech;
	}

	public void setEmptech(String emptech) {
		this.emptech = emptech;
	}

	public String getElinkman() {
		return elinkman;
	}

	public void setElinkman(String elinkman) {
		this.elinkman = elinkman;
	}

	public String getElinkphone() {
		return elinkphone;
	}

	public void setElinkphone(String elinkphone) {
		this.elinkphone = elinkphone;
	}

	public String getEmppost() {
		return emppost;
	}

	public void setEmppost(String emppost) {
		this.emppost = emppost;
	}

	public String getEmpaddr() {
		return empaddr;
	}

	public void setEmpaddr(String empaddr) {
		this.empaddr = empaddr;
	}

	public String getEmpin() {
		return empin;
	}

	public void setEmpin(String empin) {
		this.empin = empin;
	}

	public String getEmpout() {
		return empout;
	}

	public void setEmpout(String empout) {
		this.empout = empout;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
