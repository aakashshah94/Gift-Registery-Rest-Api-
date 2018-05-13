package com.GiftIt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.GiftIt.model.ForgotPasswordRequest;
import com.GiftIt.model.ForgotPasswordResponse;
import com.google.gson.Gson;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/getquestion")
public class ForgotPasswordMicro {
	
	@POST
	public String getQuestion(String userId){
		
		Connection con = null;
		Gson gson = new Gson();
		ForgotPasswordRequest fpreq = gson.fromJson(userId , ForgotPasswordRequest.class);
		
		ForgotPasswordResponse fpr = new ForgotPasswordResponse();
		
		try{
			System.out.println("in micro service");
			
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			Statement st1 = con.createStatement();
			
			ResultSet rs = st1.executeQuery("select question from customer where email = '"+fpreq.getEmail() +"'");
			
			if(rs.next()){
				fpr.setStatus(1);
				fpr.setQuestion(rs.getInt(1));
			}
			
			else{
				fpr.setError("Email is not valid");
				fpr.setStatus(0);
				fpr.setErrorcode(1);
			}
			
			
		}
		catch(Exception e){
			fpr.setError("DB error");
			fpr.setErrorcode(10);
			fpr.setStatus(0);
		}
		
		
		return gson.toJson(fpr);
	
	}
	
}