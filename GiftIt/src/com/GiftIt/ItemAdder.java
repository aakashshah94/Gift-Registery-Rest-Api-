package com.GiftIt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.GiftIt.model.AddProductRequest;
import com.GiftIt.model.AddProductResponse;
import com.google.gson.Gson;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/itemadd")
public class ItemAdder {
	
	
	@POST
	public String addItemByAdmin(String itemData){
		
		Gson gson = new Gson();
		AddProductRequest ap  = gson.fromJson(itemData, AddProductRequest.class);
		AddProductResponse apr = new AddProductResponse();
		System.out.println("in micro service");
		
			Connection con = null;
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
			 	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			 	
			 	 PreparedStatement ps=con.prepareStatement("insert into product(productName, productDescription, company, price, productLink) values(?,?,?,?,?)");
		            ps.setString(1,  ap.getProductName());
		            ps.setString(2,  ap.getProdctDesc());
		            ps.setString(3,  ap.getCommpany());
		            ps.setDouble(4,  ap.getPrice());
		            ps.setString(5, ap.getProductLink());
		            
		            
		            int b=0;
		            b=ps.executeUpdate();
		    
		           
			 	
			 	if(b>0){
			 		apr.setStatus(1);
			 		
			 	}
			 	
			 	else{
			 		apr.setStatus(0);
			 		apr.setError("Database Error");
			 		apr.setErrorcode("10");
			 	}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return gson.toJson(apr);
	}
}
