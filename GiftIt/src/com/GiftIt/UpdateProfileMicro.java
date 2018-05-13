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

import com.GiftIt.model.UpdateProfileRequest;
import com.GiftIt.model.UpdateProfileResponse;
import com.google.gson.Gson;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/update")
public class UpdateProfileMicro {

	@POST
	public String assignItem(String profileInfo){
		Connection con = null;
		Gson gson = new Gson();
		UpdateProfileRequest upr = gson.fromJson(profileInfo , UpdateProfileRequest.class);
		UpdateProfileResponse uprp = new UpdateProfileResponse();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery("select token from login where userId='"+upr.getUserId()+"'");
			
			rs.next();
			if(rs.getString(1).equals(upr.getToken())){
                System.out.println("in update profile micro");
				Statement st2 = con.createStatement();
				ResultSet rs1 = st2.executeQuery("SET foreign_key_checks = 0");
				
				Statement st3 = con.createStatement();
				st3.executeUpdate("update customer set firstName='"+upr.getFirstName()+"',lastName='"+upr.getLastName()+"' where userId='"+upr.getUserId()+"'");
				rs1 = st2.executeQuery("SET foreign_key_checks = 1");
				
				uprp.setFirstName(upr.getFirstName());
				uprp.setLastName(upr.getLastName());
				uprp.setStatus(1);
				uprp.setUserId(upr.getUserId());
				
			}
			else{
				uprp.setError("Invalid...");
				uprp.setErrorcode(0);
				uprp.setStatus(0);
			}
		}
		
		catch(Exception e){
			e.printStackTrace();
			uprp.setError("DB Error...");
			uprp.setErrorcode(10);
			uprp.setStatus(0);
		}
              return gson.toJson(uprp);
	}
}