package mgr.dao;

import java.sql.SQLException;
import java.util.List;

import mgr.entity.Post;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class PostDaoImpl {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void add(Post post) throws SQLException {
		hibernateTemplate.save(post);
	}

	@SuppressWarnings("unchecked")
	public List<Post> findAll() throws SQLException {
		String hql = "from Post";
		return hibernateTemplate.find(hql);
	}

	public void update(Post post) throws SQLException {
		hibernateTemplate.update(post);
	}

	public void delete(Post post) throws SQLException {
		hibernateTemplate.delete(post);
	}

}
