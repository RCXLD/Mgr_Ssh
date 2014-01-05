package mgr.dao;

import java.sql.SQLException;
import java.util.List;

import mgr.entity.User;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("UserDaoImpl")
public class UserDaoImpl {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	public User verify(String userid, String userpwd) throws SQLException {
		String hql = "from User where userid = '" + userid
				+ "' and userpwd = '" + userpwd + "'";
		List<User> list = hibernateTemplate.find(hql);
		if (list.size() != 0) {
			return list.get(0);
		}
		return null;
	}

}
