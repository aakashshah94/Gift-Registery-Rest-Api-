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

import com.GiftIt.model.AssignmentRequest;
import com.GiftIt.model.AssignmentResponse;
import com.google.gson.Gson;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/assignme")
public class AssignmentMicro {

	@POST
	public String assignItem(String assignInfo){
		Connection con = null;
		Gson gson = new Gson();
		System.out.println("in assign service micro");
		
		AssignmentRequest ar = gson.fromJson(assignInfo , AssignmentRequest.class);
		
		AssignmentResponse arp = new AssignmentResponse();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			Statement st1 = con.createStatement();
			Statement st2 = con.createStatement();
		
			ResultSet rs = st1.executeQuery("select token from login where userId='"+ar.getUserId()+"'");
			
			rs.next();
			if(rs.getString(1).equals(ar.getToken())){
				Statement st3 = con.createStatement();
				System.out.println("hm"+ar.getRegistryName().trim());
				ResultSet rs1 = st3.executeQuery("SET foreign_key_checks = 0");
				ResultSet rs2 = st2.executeQuery("select idRegistry from registry where registryName = '"+ar.getRegistryName().trim()+"'");
				System.out.println();
				if (rs2.next()){
					Statement st4 = con.createStatement();
					st4.executeUpdate("update registrydetails set assigned=1,assignedBy='"+ar.getUserId()+"' where  idRegistry='"+rs2.getInt(1)+"' and productId = '"+ar.getProductId()+"'");
					rs1 = st3.executeQuery("SET foreign_key_checks = 1");
					
					arp.setStatus(1);
				}
				else{
					arp.setStatus(0);
					arp.setError("Invalid");
					arp.setErrorcode(1);
				}
	
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
			arp.setStatus(0);
			arp.setError("DB Error");
 			arp.setErrorcode(10);
 			
		}
		return gson.toJson(arp);
		
	}
}