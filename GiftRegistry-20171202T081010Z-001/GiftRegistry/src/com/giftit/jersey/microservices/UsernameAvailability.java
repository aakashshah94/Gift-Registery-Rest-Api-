package com.giftit.jersey.microservices;



import java.sql.Connection;
import java.sql.DriverManager;
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

import com.giftit.jersey.modal.LoginRequest;
import com.giftit.jersey.modal.SignupRequest;
import com.giftit.jersey.modal.SignupResponse;
import com.google.gson.Gson;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/check")
public class UsernameAvailability {

	
	
	@POST
	public String checkUsername(String newUser){
		
		Gson gson = new Gson();
		SignupRequest signupreq = gson.fromJson(newUser, SignupRequest.class);
		String userN = signupreq.getEmail();
		SignupResponse sp = new SignupResponse();
	
		//Query to check available username or not
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		 	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
		 	Statement st1 = con.createStatement();
		 	
		 	ResultSet rs = st1.executeQuery("select email from login where email='"+userN+"'");
		 	
		 	
		 	if(rs.next()){
		 		sp.setStatus(0);
		 		sp.setError("Email has already been used ");
		 		sp.setErrorcode("0");
		 	}
		 	
		 	else{
		 		System.out.println("Available........");
		 		sp.setStatus(1);
		 	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return  gson.toJson(sp);
	}
	
}

