package com.GiftIt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.GiftIt.model.CreateRegistryRequest;
import com.GiftIt.model.CreateRegistryResponse;
import com.GiftIt.model.SignUpRequest;
import com.GiftIt.model.SignUpResponse;
import com.google.gson.Gson;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/test")
public class TestMicro {
	
	@POST
	public String addNewUser(String newUser){
		
	Gson gson = new Gson();
	CreateRegistryRequest regRequest = gson.fromJson(newUser, CreateRegistryRequest.class);
	CreateRegistryResponse crp = new CreateRegistryResponse();
	System.out.println("came to micro");
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			Statement st1 = con.createStatement();
			Statement st2 = con.createStatement();
			ResultSet rs = st1.executeQuery("select token from login where userId='"+regRequest.getOwnerId()+"'");
			//Checking if the username password match
			rs.next();
			System.out.println("request token:"+regRequest.getToken()+" db token:"+rs.getString(1));
			if(rs.getString(1).equals(regRequest.getToken())){
				
				ResultSet rs1 = st2.executeQuery("SET foreign_key_checks = 0");
				System.out.println("came to micro");
				PreparedStatement ps=con.prepareStatement("insert into registry(ownerId, registryName, private_public) values(?,?,?)");
	            ps.setInt(1, regRequest.getOwnerId());
	            ps.setString(2, regRequest.getRegistryName());
	            ps.setInt(3, regRequest.getPp());
	            
	            int b=ps.executeUpdate();
	            
	            Statement st3 = con.createStatement();
	            ResultSet rs11 = st3.executeQuery("select idRegistry from registry where ownerId='"+regRequest.getOwnerId()+"' and registryName='"+regRequest.getRegistryName()+"'");
	            
	            int regId = 0;
	            if (rs11.next()){
	            	regId = rs11.getInt(1);
	            	List<Integer> prods = new ArrayList<Integer>();
	            	prods = regRequest.getProductId();
	            	for(int i : prods){
	            		PreparedStatement ps1 = con.prepareStatement("insert into registrydetails(idRegistry,productId) values(?,?)");
	            		ps1.setInt(1,regId);
	            		ps1.setInt(2, i);
			            int c=ps1.executeUpdate();		            		
	            	}
	            	
	            	List<String> sId = new ArrayList<String>();
	            	sId = regRequest.getSharedId();
	            	for(String i : sId){
	            		PreparedStatement ps1 = con.prepareStatement("insert into sharedwith(idRegistry,sharedWithId) values(?,?)");
	            		ps1.setInt(1,regId);
	            		ps1.setString(2, i);
			            int c=ps1.executeUpdate();
	            	}
	            }
	            
	            if(b>0){
	            	crp.setStatus(1);
	            }
			
			else{
				crp.setStatus(0);
				crp.setError("Database Error");
				crp.setErrorcode("10");
			}
				
				
				ResultSet rs2 = st2.executeQuery("SET foreign_key_checks = 1");	
			}
			
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gson.toJson(crp);
		
		}
}
