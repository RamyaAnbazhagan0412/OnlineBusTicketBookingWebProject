package com.admin_login;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDisplayDAO {

		public static List<UserRegistrationModel>UserDisplayDAO(UserDisplayDAO userDisplay2)throws SQLException, ClassNotFoundException
		{
			//1. create list 
			List<UserRegistrationModel> userDisplay=new ArrayList<UserRegistrationModel>();

			// 2.get connection
			Connection connection=null;
			PreparedStatement statement=null;
			connection=ConnectionUtil.getConnection();
			
			//3.select  query
			String query="SELECT s_no,full_name,email_id,PASSWORD,phone_number FROM user_registration ";
			statement=connection.prepareStatement(query); 
			 
			     //4.using executeQuery() passing query
				ResultSet rs=statement.executeQuery();
				
				System.err.println("\nUserId     UserName      EmailId       Password      PhoneNumber");
				while(rs.next()) {
		       
					int userId=rs.getInt("s_no");
					String userName=rs.getString("full_name");
					String userEmailId=rs.getString("email_id");
					String userPassword=rs.getString("PASSWORD");
					String userPhoneNumber=rs.getString("phone_number");
					
					UserRegistrationModel obj=new UserRegistrationModel();
					obj.setUserId(userId);
					obj.setUserName(userName);
					obj.setEmailId(userEmailId);
					obj.setPassword(userPassword);
					obj.setPhoneNumber(userPhoneNumber);
					
					userDisplay.add(obj);
				}
				connection.close();
				return userDisplay;
				

			}
		}
