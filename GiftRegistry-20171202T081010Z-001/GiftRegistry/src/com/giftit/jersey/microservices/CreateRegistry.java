package com.giftit.jersey.microservices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.giftit.jersey.modal.CreateRegistryRequest;
import com.giftit.jersey.modal.CreateRegistryResponse;
import com.giftit.jersey.modal.SignupRequest;
import com.giftit.jersey.modal.SignupResponse;
import com.google.gson.Gson;


@Consumes("MediaType.APPLICATION_JSON")
@Produces("MediaType.APPLICATION_JSON")
public class CreateRegistry {
	
	public String addNewRegistry(String registryData){
			
		Gson gson = new Gson();
		CreateRegistryRequest regRequest = gson.fromJson(registryData, CreateRegistryRequest.class);
		CreateRegistryResponse crp = new CreateRegistryResponse();
		
			Connection con = null;
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
			 	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			 	
			 	 PreparedStatement ps=con.prepareStatement("insert into registry(ownerID, registryName, private_public) values(?,?,?,?,?,?)");
		            ps.setInt(1,  regRequest.getOwnerID());
		            ps.setString(2,  regRequest.getRegistryName());
		            ps.setBoolean(3,  regRequest.getPrivate());
		            
		            
		            int b=ps.executeUpdate();
		            
		            if(b>0){
		            	crp.setStatus(0);
		            }
			 	
			 	else{
			 		crp.setStatus(0);
			 		crp.setError("Database Error");
			 		crp.setErrorcode("10");
			 	}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return gson.toJson(crp);
	}
}
