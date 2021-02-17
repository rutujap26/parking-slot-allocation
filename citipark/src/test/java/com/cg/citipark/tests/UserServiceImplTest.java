package com.cg.citipark.tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.citipark.daos.UserDAO;
import com.cg.citipark.daos.UserDAOImpl;
import com.cg.citipark.exceptions.DuplicateUserException;
import com.cg.citipark.exceptions.InvalidLoginCredentialException;
import com.cg.citipark.exceptions.NoSuchUserException;
import com.cg.citipark.models.User;
import com.cg.citipark.services.UserService;
import com.cg.citipark.services.UserServiceImpl;

public class UserServiceImplTest {
	private static UserService userService;
	private User user1,user2,user3,user4,user5;
	private static UserDAO userDAO;
	@BeforeClass
	public static  void setUp() {
		userDAO= new UserDAOImpl();
		userService = new UserServiceImpl();

	}
	/*
	 * Mock data setup
	 */
	@Before
	public void setUpTestMockData() throws SQLException {
		user1 = new User(102,"viren","sharma","viren@gmail.com","9090909090","viren12");
		user2 = new User(104,"unnati","sharma","unnati@gmail.com","9090876890","un1234");
		user3 = new User(109,"Vidhi","Sanghi","vidhi@gmail.com","9080876543","vidhi12");
		user4 = new User(110,"Aakash","Patel","aakash@gmail.com","9087666789","aakash12");
		user5 = new User(111,"Riya","Garg","riya@gmail.com","9087600009","riya12");

	}
	/*
	 * Test registerUser method
	 */
	@Test (expected = DuplicateUserException.class)
	public void testRegisterUser() throws DuplicateUserException
	{
		userService.registerUser(user2);
	}
	/*
	 * Test user details for invalid user id
	 */
	@Test(expected = NoSuchUserException.class)
	public void testUserDetailsForInValidId() throws NoSuchUserException
	{
		userService.getUserProfileById(9080);
	}
	/*
	 * Test user details for valid user id
	 */

	@Test
	public void testUserDetailsForValidId() throws NoSuchUserException {
		User userActual =userService.getUserProfileById(104);
		assertEquals(user2.toString(), userActual.toString());
	}
	/*
	 * Test login method
	 */
	@Test 
	public void testLogin() throws Exception
	{
		boolean expected = true;
		boolean result = userService.login(user2);
		assertEquals(expected,result);
	}
	/*
	 * Test user login for invalid login credentials
	 */

	@Test (expected = InvalidLoginCredentialException.class)
	public void testLoginForInValidCredentials() throws InvalidLoginCredentialException{
		User user = new User(1000,"Som","Verma","som@gmail.com","9012312312","som12");
		boolean result = userService.login(user);
	}
	/*
	 * Test find user profile by user id
	 */
	@Test
	public void testFindUserProfileById() throws NoSuchUserException{
		User result = userService.getUserProfileById(104);
		assertEquals(user2.toString(), result.toString());
	}
	/*
	 * Test find user profile by user email id
	 */
	@Test
	public void testFindUserProfileByEmailId() throws NoSuchUserException
	{
		User userActual = userService.getUserProfileByEmail("unnati@gmail.com");
		assertEquals(user2.toString(),userActual.toString());
	}
	/*
	 * Test delete user profile by user id
	 */

	@Test(expected=NoSuchUserException.class)
	public void testdeleteUserProfileById() throws NoSuchUserException
	{
		boolean b = userService.deleteUserById(90);

		assertEquals(b,false);
	}
	/*
	 * Test modify user profile
	 */
	@Test
	public void testModifyUserProfile()
	{
		User result = userService.modifyUserProfile(user3);
		assertEquals(user3.toString(),result.toString());
	}
	/*
	 * Test user validation
	 */
	@Test
	public void testValidate() throws InvalidLoginCredentialException
	{
		boolean b=userService.login(user2);
		assertEquals(true,b);	
	}
	/*
	 * Test change password method for same old and new password
	 */
	
	@Test(expected=NoSuchUserException.class)
	public void testChangePasswordForSameOldAndNewPassword() throws NoSuchUserException{
		userService.changePassword(user4,"aakash12");  
	}
	/*
	 * Test change password method for different old and new password
	 */
	
	@Test
	public void testChangePasswordForDifferentPassword()throws NoSuchUserException{
		boolean b = userService.changePassword(user5,"riyagarg"); 
		assertEquals(b,true);
	}
	

	@AfterClass
	public static  void tearDownTestEnv() {
		userService = null;
		userDAO= null;
	}

}

