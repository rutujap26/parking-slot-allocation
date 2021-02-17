package com.cg.citipark.main;

import java.util.Scanner;

import com.cg.citipark.utils.AdminMenuUtil;
import com.cg.citipark.utils.UserMenuUtil;

public class AppStartup {

	public static void main(String[] args)
			throws Exception {
			System.out.println("Enter your chooise");
			System.out.println("1.Admin");
			System.out.println("2.User");
			 
			Scanner sc=new Scanner(System.in);
			
			
			int chooise=sc.nextInt();
			
			switch (chooise) {
			case 1:
				AdminMenuUtil adminMenu = new AdminMenuUtil();
				adminMenu.start();
				
				break;
			case 2:
				UserMenuUtil userMenu = new UserMenuUtil();
				userMenu.start();
				break;

			default:
				System.out.println("Invaild choice");
				break;
			}
			
	
			

	}

}
