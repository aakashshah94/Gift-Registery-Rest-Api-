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
import com.GiftIt.model.GetPasswordRequest;

import com.GiftIt.model.GetPasswordResponse;
import com.google.gson.Gson;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/getpassword")
public class GetPasswordMicro {
	
	@POST
	public String getPass(String qa){
		
		Connection con = null;
		Gson gson = new Gson();
		GetPasswordRequest gpreq = gson.fromJson(qa, GetPasswordRequest.class);
		
		GetPasswordResponse gpr = new GetPasswordResponse();
		
		try{
			System.out.println("in forgot service micro");

			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			Statement st1 = con.createStatement();
			
			ResultSet rs = st1.executeQuery("select password from customer where email = '"+gpreq.getEmail() +"' and answer='"+ gpreq.getAnswer() +"'");
			
			if(rs.next()){
				gpr.setStatus(1);
				gpr.setPassword(rs.getString(1));
			}
			
			else{
				gpr.setError("Email is not valid");
				gpr.setStatus(0);
				gpr.setErrorcode(1);
			}
			
			
		}
		catch(Exception e){
			gpr.setError("DB error");
			gpr.setErrorcode(10);
			gpr.setStatus(0);
		}
		
		
		return gson.toJson(gpr);
	
	}
	
}