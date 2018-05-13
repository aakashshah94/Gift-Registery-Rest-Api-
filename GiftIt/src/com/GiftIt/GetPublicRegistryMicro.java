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

import com.GiftIt.model.GetPublicRegistryRequest;
import com.GiftIt.model.GetPublicRegistryResponse;
import com.google.gson.Gson;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/getpublic")
public class GetPublicRegistryMicro {

	
	@POST

	public String getPublic(String regInfo){
		
		Gson gson = new Gson();
		GetPublicRegistryRequest gprr = gson.fromJson(regInfo, GetPublicRegistryRequest.class);
		GetPublicRegistryResponse gpr = new GetPublicRegistryResponse();
		
		Connection con = null;
		try {
				
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			Statement st1 = con.createStatement();
			Statement st2 = con.createStatement();
			ResultSet rs = st1.executeQuery("select token from login where userId='"+gprr.getUserId()+"'");
			
			rs.next();
			if(rs.getString(1).equals(gprr.getToken())){
				
				
				ArrayList<String> names = new ArrayList<String>();
				ResultSet rs1=st2.executeQuery("select registryName from registry where private_public=0");
				while(rs1.next()){
					names.add(rs1.getString(1));
				}

				
				gpr.setStatus(1);
				gpr.setPublicRegistry(names);
				
			}
			else {
				gpr.setStatus(0);
				gpr.setError("Authentication Error");
				gpr.setErrorcode(5); 	
			}
		}
		catch(Exception e){
			e.printStackTrace();
			gpr.setStatus(0);
			gpr.setError("DB Error");
			gpr.setErrorcode(10);
		}
		
		
		return gson.toJson(gpr);
	
		
	}
}