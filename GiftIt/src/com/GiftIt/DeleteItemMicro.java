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

import com.GiftIt.model.DeleteItemRequest;
import com.GiftIt.model.DeleteItemResponse;
import com.google.gson.Gson;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/deleteitem")
public class DeleteItemMicro {

	@POST
	public String deleteItem(String deleteInfo){
		Connection con = null;
		Gson gson = new Gson();
		DeleteItemRequest dr = gson.fromJson(deleteInfo , DeleteItemRequest.class);
		
		DeleteItemResponse drp = new DeleteItemResponse();
		
		try{
			System.out.println("in delte micro");
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			Statement st1 = con.createStatement();
			Statement st2 = con.createStatement();
			ResultSet rs = st1.executeQuery("select token from login where userId='"+dr.getUserId()+"'");
			
			rs.next();
			if(rs.getString(1).equals(dr.getToken())){
				Statement st3 = con.createStatement();
				ResultSet rs1 = st3.executeQuery("SET foreign_key_checks = 0");
				st2.executeUpdate("Delete from product where productId = '"+dr.getProductId()+"'");
				drp.setStatus(1);
				rs1 = st3.executeQuery("SET foreign_key_checks = 1");
			}	
				else{
					drp.setStatus(0);
					drp.setError("Invalid");
					drp.setErrorcode(1);
				}
	
				
			
		}
		catch(Exception e){
			e.printStackTrace();
			drp.setStatus(0);
			drp.setError("DB Error");
			drp.setErrorcode(10);
		}
		return gson.toJson(drp);
	}
}