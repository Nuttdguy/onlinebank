package com.app.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.app.dao.UserDao;
import com.app.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
//	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.app");
//	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	
//	private SessionFactory sessionFactory;

//	@Query("insert into User ")
//	@Override
//	public void save(User user ) {
////		entityManager.getTransaction().begin();
//		
//	}
	
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
