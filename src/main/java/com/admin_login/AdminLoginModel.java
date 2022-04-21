package com.admin_login;
import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

public class AdminLoginModel {
			
			//admin login
			//user login
			public static int adminLogin(String emailId,String password) throws Exception {
				
				//1. Get connection
				Connection connection=null;
				connection=ConnectionUtil.getConnection();
			    PreparedStatement statement=null;
			   
			    		
			   //2. Passing query 
			    String query="SELECT admin_emailId,PASSWORD FROM admin_login1 WHERE admin_emailId=?";
			    statement=connection.prepareStatement(query);
			   statement.setString(1,emailId);
			   
			   //4.storing values from database to rs
			   ResultSet rs=statement.executeQuery();
			  String adminEmailId=null;
			  String adminPassword=null;
			  int a=0;
			  
			  //5.using if condition storing values to adminEmailId,adminpassword
			   if(rs.next())
			   {
				   adminEmailId=rs.getString("admin_emailId");
				  adminPassword=rs.getString("PASSWORD");
				  System.out.print(adminEmailId+adminPassword);
				 }
			   if(adminEmailId==null)
			   {
				  System.out.println("Invalid Login");
				  // AdminLoginDAO.adminLogin(emailId,password);
				  a=0;
				  
			   }
			   else if(adminEmailId.equals(emailId.trim())&&adminPassword.equals(password.trim()))
			   {
				   System.out.println("---------------ADMIN LOGIN SUCCESSFUL-------------");
				   a=1;
				  
			   }
			   else {
					  System.out.println("emailId and password does not match");
					  a=0;
					  
					   
				   }
			return a;
			   
			   
		}

			public static void userLogin(String emailId,String password) throws ClassNotFoundException, SQLException {
				//1. Get connection
				Connection connection=null;
				connection=ConnectionUtil.getConnection();
			    PreparedStatement statement=null;
			   
			    		
			   //2. Passing query 
			    String query="SELECT email_id,PASSWORD FROM user_registration WHERE email_id=?";
			    statement=connection.prepareStatement(query);
			   statement.setString(1,emailId);
			   
			   //4.storing values from database to rs
			   ResultSet rs=statement.executeQuery();
			  String userEmailId=null;
			  String userPassword=null;
			  
			  //5.using if condition storing values to userEmailId,userpassword
			   if(rs.next())
			   {
				  userEmailId=rs.getString("email_id");
				  userPassword=rs.getString("PASSWORD");
			   }
				   if(userEmailId==null)
				   {
					  System.out.println("Invalid Login");
					  // AdminLoginDAO.adminLogin(emailId,password);
				   }
				   else if(userEmailId.equals(emailId.trim())&&userPassword.equals(password.trim()))
				   {
					   System.out.println("---------------USER LOGIN SUCCESSFUL-------------");
					   
				   }
			   
			   else {
				  System.out.println("emailId and password does not match");
				   //AdminLoginDAO.adminLogin(emailId,password);
				   
			   }
			   
			  
			   ConnectionUtil.close(statement,connection);
			   
		}
			}



