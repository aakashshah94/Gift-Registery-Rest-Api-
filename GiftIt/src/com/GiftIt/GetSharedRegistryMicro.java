package com.GiftIt;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.text.GapContent;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.GiftIt.model.GetSharedRegistryRequest;
import com.GiftIt.model.GetSharedRegistryResponse;
import com.google.gson.Gson;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/shared")
public class GetSharedRegistryMicro {

	
	@POST

	public String getShared(String regInfo){
		
		Gson gson = new Gson();
		GetSharedRegistryRequest gsrr = gson.fromJson(regInfo, GetSharedRegistryRequest.class);
		GetSharedRegistryResponse gsr = new GetSharedRegistryResponse();
		
		Connection con = null;
		try {
			System.out.println("Shared registry micro service");
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			Statement st1 = con.createStatement();
			Statement st2 = con.createStatement();
			ResultSet rs = st1.executeQuery("select token from login where userId='"+gsrr.getUserId()+"'");
			
			rs.next();
			if(rs.getString(1).equals(gsrr.getToken())){
				
				ResultSet rs1 = st2.executeQuery("select idRegistry from sharedWith where sharedWithId='"+gsrr.getEmail()+"'");
				ArrayList<String> names = new ArrayList<String>();
				
				while(rs1.next()){
					Statement st3 = con.createStatement();
					ResultSet rs2 = st3.executeQuery("select registryName from registry where idRegistry = '"+rs1.getInt(1)+"'");
					if(rs2.next()){
						names.add(rs2.getString(1));
					}
				}
				
				gsr.setStatus(1);
				gsr.setSharedRegistry(names);
				
			}
			else {
				gsr.setStatus(0);
				gsr.setError("Authentication Error");
				gsr.setErrorcode(5); 	
			}
		}
		catch(Exception e){
			e.printStackTrace();
			gsr.setStatus(0);
			gsr.setError("DB Error");
			gsr.setErrorcode(10);
		}
		
		
		return gson.toJson(gsr);
	
		
	}
}