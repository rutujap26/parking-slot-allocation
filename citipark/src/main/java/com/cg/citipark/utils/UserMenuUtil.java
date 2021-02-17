package com.cg.citipark.utils;

import java.security.Provider.Service;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import com.cg.citipark.exceptions.DuplicateUserException;
import com.cg.citipark.exceptions.InvalidLoginCredentialException;
import com.cg.citipark.exceptions.NoSuchUserException;
import com.cg.citipark.models.User;
import com.cg.citipark.services.UserService;
import com.cg.citipark.services.UserServiceImpl;

public class UserMenuUtil {
	User user = new User();
	UserService userService = new UserServiceImpl(); 
	Scanner sc = new Scanner(System.in);
	public void start()
	{   
		System.out.println("1.Register User");
		System.out.println("2.Login");
		System.out.println("3.Find User Profile By ID");
		System.out.println("4.Find User Profile By Email");
		System.out.println("5.Delete User By Id");
		System.out.println("6.Modify User Profile");
		System.out.println("7.Forgot password");
		System.out.println("8.Change password");
		System.out.println("9.Forgot Login ID");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:register();
		break;
		case 2:login();
		break;
		case 3:System.out.println("Enter user id");
		long uid = sc.nextLong();
		try
		{
			User user=userService.getUserProfileById(uid);
			System.out.println(user.getUserId()+"  "+user.getFirstName()+"  "+user.getLastName()+"  "
					+user.getEmail()+"  "+user.getMobile()+"  "+user.getPassword());

		}
		catch(NoSuchUserException e)
		{
			System.out.println(e.getMessage());
		}
		break;
		case 4: System.out.println("Enter user email");
		String email = sc.next();
		try
		{
			User user = userService.getUserProfileByEmail(email);
			System.out.println(user.getUserId()+"  "+user.getFirstName()+"  "+user.getLastName()+"  "
					+user.getEmail()+"  "+user.getMobile()+"  "+user.getPassword());
		}
		catch(NoSuchUserException e) 
		{
			System.out.println(e.getMessage());
		}
		break;
		case 5:System.out.println("Enter user id");
		long userid = sc.nextLong();
		try
		{
			boolean b=userService.deleteUserById(userid);
			if(b)
			{
				System.out.println("User deleted");
			}
			else
				throw new NoSuchUserException();

		}
		catch(NoSuchUserException e)
		{
			System.out.println(e.getMessage());
		}
		break;
		case 6:System.out.println("Enter user id");
		long id=sc.nextLong();
		try {
			User user = userService.getUserProfileById(id); 
			if(user!=null)
				userService.modifyUserProfile(user);    
		}
		catch (NoSuchUserException e1) 
		{
			e1.printStackTrace();
		}
		break;
		case 7: System.out.println("User Id");
		try
		{
			User user  = userService.getUserProfileById(sc.nextLong());
			if(user!=null)
			{
				System.out.println("Enter password");
				String password = sc.next();
				user.setPassword(password);
				boolean b =  userService.forgotPassword(user);
				if(b)
					System.out.println("Updated successfully");
				else
					throw new NoSuchUserException();
			}
		}
		catch(NoSuchUserException e)
		{
			System.out.println(e.getMessage());
		}
		break;
		case 8:System.out.println("UserId");
		long userId = sc.nextLong();
		try
		{
			User user = userService.getUserProfileById(userId);
			if(user!=null)
			{ 
				String oldPassword = user.getPassword();
				System.out.println("Enter new password");
				String newPassword = sc.next();
				user.setPassword(newPassword);
				boolean check = userService.changePassword(user,oldPassword);
				if(check)
					System.out.println("Password updated successfully");
			}
			else
				throw new NoSuchUserException();
		}
		catch(NoSuchUserException e)
		{
			System.out.println(e.getMessage());
		}
		break;
		case 9:System.out.println("Enter email id");
		String emailId = sc.next();
		try
		{
			User user = userService.getUserProfileByEmail(emailId);
			if(user!=null)
			{
				System.out.println("User id -"+user.getUserId()+" "+"Password - "+user.getPassword());
			}
			else
				throw new NoSuchUserException("No user found");
		}
		catch(NoSuchUserException e)
		{
			System.out.println(e.getMessage());
		}
		break;
		default: System.out.println("Please enter valid choice");
		break;   
		}
	}
	public void login()
	{
		System.out.println("Enter login id");
		user.setUserId(sc.nextLong());
		System.out.println("Enter password");
		user.setPassword(sc.next());
		try
		{
			boolean b=userService.login(user);
			if(b)
			{
				System.out.println("User logged in ");
			}
			else
				throw new InvalidLoginCredentialException();
		}
		catch(InvalidLoginCredentialException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void register()
	{
		System.out.println("------Register a user--------");
		System.out.println("UserId");
		user.setUserId(sc.nextLong());
		System.out.println("FirstName");
		user.setFirstName(sc.next());
		System.out.println("LastName");
		user.setLastName(sc.next());
		System.out.println("Email");
		user.setEmail(sc.next());
		System.out.println("Mobile");
		user.setMobile(sc.next());
		System.out.println("Password");
		user.setPassword(sc.next());
		try
		{
			boolean b=userService.registerUser(user);
			if(b)
			{
				System.out.println("User registered successfully");
			}
			else
				throw new DuplicateUserException();

		}
		catch(DuplicateUserException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
