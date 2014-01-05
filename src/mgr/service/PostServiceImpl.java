package mgr.service;

import java.util.List;

import mgr.dao.PostDaoImpl;
import mgr.entity.Post;

public class PostServiceImpl {

	private PostDaoImpl postDao;

	public PostDaoImpl getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDaoImpl postDao) {
		this.postDao = postDao;
	}
	
	public void add(Post post) throws Exception{
		postDao.add(post)
		;
	}
	
	public void delete(Post post) throws Exception {
		postDao.delete(post);
	}
	
	public void update(Post post ) throws Exception {
		postDao.update(post);
	}
	
	public List<Post> findAll() throws Exception{
		return postDao.findAll();
	}

}
