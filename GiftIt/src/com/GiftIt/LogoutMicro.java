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

import com.GiftIt.model.LogoutRequest;
import com.GiftIt.model.LogoutResponse;
import com.google.gson.Gson;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/logout")
public class LogoutMicro {
	@POST
	public String signout(String logOutData){
		
		Connection con = null;
		Gson gson = new Gson();
		LogoutRequest outReq = gson.fromJson(logOutData, LogoutRequest.class);
		
		int token = outReq.getToken();
		int id = outReq.getUserId();
		
		System.out.println(" logout micro called with "+id);
		
		LogoutResponse op = new LogoutResponse();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			Statement st1 = con.createStatement();
			Statement st2 = con.createStatement();
			ResultSet rs = st1.executeQuery("select token from login where userId='"+id+"'");
			//Checking if the username password match
			rs.next();
			System.out.print(rs.getString(1));
			if(rs.getString(1).equals(String.valueOf(token))){
				st2.executeUpdate("Update login set token=NULL where userId='"+id+"'");
				op.setStatus(1);
				
			}
			
		
			//if username password don't match, return failure.
			else{
				System.out.println("Invalid........");
				op.setStatus(0);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gson.toJson(op);
		
	}

}
