package mgr.dao;

import java.sql.SQLException;
import java.util.List;

import mgr.entity.Dept;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("DeptDaoImpl")
public class DeptDaoImpl {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void add(Dept dept) throws SQLException {
		hibernateTemplate.save(dept);
	}

	@SuppressWarnings("unchecked")
	public List<Dept> findAll() throws SQLException {
		String hql = "from Dept";
		return hibernateTemplate.find(hql);
	}

	public void update(Dept dept) throws SQLException {
		hibernateTemplate.update(dept);
	}

	public void delete(Dept dept) throws SQLException {
		hibernateTemplate.delete(dept);
	}

}
