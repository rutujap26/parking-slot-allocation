package com.cg.citipark.daos;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.citipark.models.User;

import com.cg.citipark.utils.JPAUtil;

public class UserDAOImpl implements UserDAO {

	private EntityManager entityManager;

	public UserDAOImpl() {
		entityManager = JPAUtil.getEntityManager();
	}
	@Override
	public boolean registerUser(User user)
	{
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		return true;
	}
	
	@Override
	public User findUserProfileById(long userId) {
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, userId);
		entityManager.getTransaction().commit();
		return user;
	}

	@Override
	public User findUserProfileByEmail(String email) {
		entityManager.getTransaction().begin();
		String queryStr = "SELECT u FROM User u where u.email=:email";
		TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);
		query.setParameter("email",email);
		User uemail = query.getSingleResult();
		entityManager.getTransaction().commit();
		return uemail;
	}
	
	@Override
	public boolean deleteUserById(long userId) {
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class,userId);
		entityManager.remove(user);
		entityManager.getTransaction().commit();
		return true;
	}

	@Override
	public User updateUserProfile(User user) {
		entityManager.getTransaction().begin();
		User updateUser = entityManager.find(User.class, user.getUserId());
		updateUser = entityManager.merge(user);
		entityManager.getTransaction().commit();
		return updateUser;
	}
	
	@Override
	public boolean changePassword(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		return true;
	}
}
