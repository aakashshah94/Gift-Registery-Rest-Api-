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

import org.json.JSONObject;

import com.GiftIt.model.AddProductResponse;
import com.GiftIt.model.CreateRegistryRequest;
import com.GiftIt.model.CreateRegistryResponse;
import com.GiftIt.model.GetRegistryRequest;
import com.GiftIt.model.GetRegistryResponse;
import com.GiftIt.model.Product;
import com.google.gson.Gson;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/getregistry")
public class AllRegistryForOwner {

	
	@POST

	public String getRegistry(String regInfo){
		
		Gson gson = new Gson();
		GetRegistryRequest info = gson.fromJson(regInfo, GetRegistryRequest.class);
		GetRegistryResponse grp = new GetRegistryResponse();
		
		Connection con = null;
		try {
				
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			Statement st1 = con.createStatement();
			Statement st2 = con.createStatement();
			ResultSet rs = st1.executeQuery("select token from login where userId='"+info.getOwnerId()+"'");
			//Checking if the username password match
			rs.next();
			if(rs.getString(1).equals(info.getToken())){
				
				ResultSet rs1 = st2.executeQuery("select registryName from registry where ownerId='"+info.getOwnerId()+"'");
				ArrayList<String> names = new ArrayList<String>();
				while(rs1.next()){
					names.add(rs1.getString(1));
				}
				grp.setStatus(1);
				grp.setRegistryName(names);
				
			}
			else {
				grp.setStatus(0);
				grp.setError("Authentication Error");
				grp.setErrorcode(5); 	
			}
		}
		catch(Exception e){
			grp.setStatus(0);
			grp.setError("DB Error");
			grp.setErrorcode(10);
		}
		
		
		return gson.toJson(grp);
	
		
	}
}