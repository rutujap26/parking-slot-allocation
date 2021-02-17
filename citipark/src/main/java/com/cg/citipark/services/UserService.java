package com.cg.citipark.services;

import com.cg.citipark.exceptions.DuplicateUserException;
import com.cg.citipark.exceptions.InvalidLoginCredentialException;
import com.cg.citipark.exceptions.NoSuchUserException;
import com.cg.citipark.models.User;

/**
 * This UserService will perform all the User related services
 *
 */
public interface UserService {

	/**
	 * This registerUser Method will register the user in system
	 * @param user to be registered
	 */
	public boolean registerUser(User user) throws DuplicateUserException;
	/**
	 * This login Method will allow the user to login in system
	 * @param user object
	 */
	public boolean login(User user) throws InvalidLoginCredentialException;
	/**
	 * This getUserProfileById method will find the user profile from the users table
	 * @param userId of the user to be found
	 */
	public User getUserProfileById(long userId) throws NoSuchUserException;
	/**
	 * This getUserProfileByEmail method will find the user profile from the users table
	 * @param email of the user to be found
	 */
	public User getUserProfileByEmail(String email) throws NoSuchUserException;
	/**
	 * This modifyUserProfile method will modify the user in the users table 
	 * @param user to be modified
	 */
	public User modifyUserProfile(User user);
	/**
	 * This deleteUserById method will delete the user object from users table
	 * @param userId of the user to be deleted
	 */
	public boolean deleteUserById(long userId) throws NoSuchUserException;
	/**
	 * This changePassword method will change the password of the user
	 * @param user object and old password of the user
	 */
	public boolean changePassword(User user, String oldPassword)throws NoSuchUserException;
	/**
	 * This forgotPassword method will allow user to set new password
	 * @param user object
	 */
	public boolean forgotPassword(User user) throws NoSuchUserException;
	/**
	 * This forgotLoginId method will display user login credentials
	 * @param user email
	 */
	public User forgotLoginId(String email)throws NoSuchUserException;
}
