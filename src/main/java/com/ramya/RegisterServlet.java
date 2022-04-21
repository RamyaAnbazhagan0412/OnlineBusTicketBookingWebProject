package com.ramya;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		User name=new User(1,"ramya");
		User name1=new User(2,"selva");
		User name2=new User(3,"praveen");
		User name3=new User(4,"gopi");
		User name4=new User(5,"kiruthika");
		User name5=new User(6,"anusha");
		List<User> list=new ArrayList<User>();
        System.out.println(name);
        
		Gson gson=new Gson();
		String userJson=gson.toJson(name);
		System.out.println(userJson);
		PrintWriter out=response.getWriter();
		out.println(userJson);
		
		out.flush();
	}

}
