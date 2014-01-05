package mgr.service;

import java.util.List;

import javax.annotation.Resource;

import mgr.dao.EmpDaoImpl;
import mgr.entity.Emp;

@Resource(name = "EmpDaoImpl")
public class EmpServiceImpl {

	private EmpDaoImpl empDao;

	public EmpDaoImpl getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpDaoImpl empDao) {
		this.empDao = empDao;
	}

	public void add(Emp emp) throws Exception {
		empDao.add(emp);
	}

	public List<Emp> findAll() throws Exception {
		return empDao.findAll();
	}

	public void modify(Emp emp) throws Exception {
		empDao.update(emp);
	}

	public void delete(Emp emp) throws Exception {
		empDao.delete(emp);
	}

}
