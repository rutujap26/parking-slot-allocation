package com.cg.citipark.daos;

import java.sql.SQLException;

import com.cg.citipark.models.User;

/**
 * This UserDAO interface will perform CRUD Operations on User
 *
 */
public interface UserDAO {

	/**
	 * This registerUser method will register the user object in users table
	 * @param user object to be saved
	 */
	public boolean registerUser(User user);
	/**
	 * This findUserProfileById method will find the user profile from the users table
	 * @param userId of the user to be found
	 */
	public User findUserProfileById(long userId);
	/**
	 * This findUserProfileByEmail method will find the user profile from the users table
	 * @param email of the user to be found
	 */
	public User findUserProfileByEmail(String email);
	/**
	 * This updateUserProfile method will update the user in the users table 
	 * @param user to be updated
	 */
	public User updateUserProfile(User user);
	/**
	 * This deleteUserById method will delete the user object from users table
	 * @param userId of the user to be deleted
	 */
	public boolean deleteUserById(long userId) ;
	/**
	 * This changePassword method will change the password of the user
	 * @param user object whose password to be changed
	 */
	public boolean changePassword(User user);
	
}
