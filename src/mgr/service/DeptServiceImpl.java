package mgr.service;

import java.util.List;

import javax.annotation.Resource;

import mgr.dao.DeptDaoImpl;
import mgr.entity.Dept;

@Resource(name = "DeptServiceImpl")
public class DeptServiceImpl {

	private DeptDaoImpl deptDao;

	public DeptDaoImpl getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDaoImpl deptDao) {
		this.deptDao = deptDao;
	}

	public void add(Dept dept) throws Exception {
		deptDao.add(dept);
	}

	public void delete(Dept dept) throws Exception {
		deptDao.delete(dept);
	}

	public void update(Dept dept) throws Exception {
		deptDao.update(dept);
	}

	public List<Dept> findAll() throws Exception {
		return deptDao.findAll();

	}

}
