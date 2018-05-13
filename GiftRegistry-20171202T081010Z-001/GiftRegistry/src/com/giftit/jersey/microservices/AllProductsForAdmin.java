package com.giftit.jersey.microservices;

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

import com.giftit.jersey.modal.AddProductResponse;
import com.giftit.jersey.modal.LoginRequest;
import com.giftit.jersey.modal.Product;
import com.google.gson.Gson;
import com.giftit.jersey.modal.*;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AllProductsForAdmin {

	
	@GET

	public String getProducts(){
	
		Gson gson = new Gson();
		AllProductResponse apr = new AllProductResponse();
		
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		 	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
		 	
		 	Statement st1 = con.createStatement();
		 	ResultSet rs = st1.executeQuery("select * from product");
		 	
		 	ArrayList<Product> listProducts = new ArrayList<Product>();
		 	
  		 	while(rs.next()){
  		 		apr.setStatus(1);
		 		int i=0;
  		 		Product pro = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getString("productDescription"), rs.getString("company"), rs.getDouble("price"), rs.getString("productLink"));
		 		System.out.println(i++);
		 		listProducts.add(pro);
		 	}
  		 	System.out.println("Executed...");
  		 	apr.setProducts(listProducts);
  		 	
	
		} catch (Exception e) {
			apr.setStatus(0);
			apr.setError("Query not Executed");
			apr.setErrorCode("10");
		}
		return gson.toJson(apr);
	}
}