package com.cg.citipark.services;

import java.sql.SQLException;

import com.cg.citipark.daos.UserDAO;
import com.cg.citipark.daos.UserDAOImpl;
import com.cg.citipark.exceptions.DuplicateUserException;
import com.cg.citipark.exceptions.InvalidLoginCredentialException;
import com.cg.citipark.exceptions.NoSuchUserException;
import com.cg.citipark.models.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}

	@Override
	public boolean registerUser(User user) throws DuplicateUserException {
		User userRegister=userDAO.findUserProfileById(user.getUserId());
		if(userRegister==null)
		{
			boolean b=userDAO.registerUser(user);
		}
		else
			throw new DuplicateUserException("Duplicate User");

		return true;
	}
	@Override
	public boolean login (User user) throws InvalidLoginCredentialException {

		User userLogin = userDAO.findUserProfileById(user.getUserId());
		if(userLogin==null)
			throw new InvalidLoginCredentialException("Invalid User Login Credentials");
		if(user.getPassword().equals(userLogin.getPassword()))
			return true;
		else return false;
	}
	@Override
	public User getUserProfileById(long userId)throws NoSuchUserException{

		User user = userDAO.findUserProfileById(userId);
		if(user==null)
			throw new NoSuchUserException("User not found");
		else
			return user;

	}
	@Override
	public User getUserProfileByEmail(String email) throws NoSuchUserException {
		User user = userDAO.findUserProfileByEmail(email); 
		System.out.println(user);
		if(user==null)
			throw new NoSuchUserException("User not found");
		else
			return user;

	}
	@Override
	public boolean deleteUserById(long userId) throws NoSuchUserException {
		User user = userDAO.findUserProfileById(userId);
		if(user==null)
			throw new NoSuchUserException("User not found");
		else
			return	userDAO.deleteUserById(userId);

	}


	@Override
	public User modifyUserProfile(User user){

		User result = userDAO.updateUserProfile(user);
		return result;
	}

	@Override
	public boolean changePassword(User user, String oldPassword) throws NoSuchUserException{

		if (!oldPassword.equals(user.getPassword()))
		{
			User updated = userDAO.updateUserProfile(user);
			return true;
		}
		else 
			throw new NoSuchUserException("User not found");  

	}

	@Override
	public boolean forgotPassword(User user) throws NoSuchUserException{

		User updated = userDAO.updateUserProfile(user);
		return true;

	}

	@Override
	public User forgotLoginId(String email) throws NoSuchUserException{

		User user = userDAO.findUserProfileByEmail(email);
		if(user==null)
			throw new NoSuchUserException("User not found");
		else
			return user;

	}


}
