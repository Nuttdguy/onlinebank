package com.app.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.UserDao;
import com.app.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends User> S save(S user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(user);
		return null;
	}

	public <S extends User> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<User> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
