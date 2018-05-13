package com.GiftIt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.GiftIt.model.SignUpRequest;
import com.GiftIt.model.SignUpResponse;
import com.google.gson.Gson;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/adduser")
public class AddUser {
	
	@POST
	public String addNewUser(String newUser){
			
		Gson gson = new Gson();
		SignUpRequest signupreq = gson.fromJson(newUser, SignUpRequest.class);
		SignUpResponse sp = new SignUpResponse();
		System.out.println(newUser);
			Connection con = null;
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
			 	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			 	
			 	 PreparedStatement ps=con.prepareStatement("insert into customer(firstName, lastName, email, password, question, answer) values(?,?,?,?,?,?)");
		            ps.setString(1,  signupreq.getFirstName());
		            ps.setString(2,  signupreq.getLastName());
		            ps.setString(3,  signupreq.getEmail());
		            ps.setString(4,  signupreq.getPassword());
		            ps.setInt(5,  signupreq.getQuestion());
		            ps.setString(6,  signupreq.getAnswer());
		            
		            int b=0;
		            b=ps.executeUpdate();
		            
		            
		            Statement st1 = con.createStatement();
				 	ResultSet rs = st1.executeQuery("select userId from customer where email='"+signupreq.getEmail()+"'");
		            rs.next();
		            int id = rs.getInt(1);
		            
		            ResultSet rs1 = st1.executeQuery("SET foreign_key_checks = 0");
		            PreparedStatement ps1=con.prepareStatement("insert into login(userId,email,password) values(?,?,?)");
		            ps1.setDouble(1, id);
		            ps1.setString(2, signupreq.getEmail());
		            ps1.setString(3,  signupreq.getPassword());
		            
		            int b1=0;
		            b1 = ps1.executeUpdate();
		            ResultSet rs2 = st1.executeQuery("SET foreign_key_checks = 1");
			 	
			 	if(b>0 && b1>0){
			 		sp.setStatus(1);
			 		sp.setToken("id");
			 	}
			 	
			 	else{
			 		sp.setStatus(0);
			 		sp.setError("Database Error");
			 		sp.setErrorcode("10");
			 	}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return gson.toJson(sp);
	}
}
