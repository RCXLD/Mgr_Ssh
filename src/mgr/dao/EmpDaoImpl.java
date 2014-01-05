package mgr.dao;

import java.sql.SQLException;
import java.util.List;

import mgr.entity.Emp;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("EmpDaoImpl")
public class EmpDaoImpl {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void add(Emp emp) throws SQLException {
		hibernateTemplate.save(emp);
	}

	@SuppressWarnings("unchecked")
	public List<Emp> findAll() throws SQLException {
		String hql = "from Emp";
		return hibernateTemplate.find(hql);
	}

	public void update(Emp emp) throws SQLException {
		hibernateTemplate.update(emp);
	}

	public void delete(Emp emp) throws SQLException {
		hibernateTemplate.delete(emp);
	}

}
