package com.GiftIt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.GiftIt.model.ProdDetail;
import com.GiftIt.model.SharedRegistryInfoRequest;
import com.GiftIt.model.SharedRegistryInfoResponse;
import com.google.gson.Gson;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/regshared")
public class SharedRegistryInfoMicro {

	@POST
	public String getRegistryInfo(String info){
		Gson gson = new Gson();
		SharedRegistryInfoRequest sr = gson.fromJson(info, SharedRegistryInfoRequest.class);
		SharedRegistryInfoResponse srp = new SharedRegistryInfoResponse();
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery("select token from login where userId='"+sr.getUserId()+"'");
			//Checking if the username password match
			System.out.println("token"+sr.getToken()+" id"+sr.getUserId());
			rs.next();
			ArrayList<ProdDetail> prods = new ArrayList<ProdDetail>();
			if(rs.getString(1).equals(sr.getToken())){
				srp.setRegistryName(sr.getRegistry());
				Statement st2 = con.createStatement();
				ResultSet rs1 = st2.executeQuery("select ownerId,idRegistry from registry where registryName= '"+sr.getRegistry()+"'");
				if(rs1.next()){
					Statement st3 = con.createStatement();
					ResultSet rs2 = st3.executeQuery("select firstName from customer where userId= '"+rs1.getInt(1)+"'");
					if(rs2.next()){
						srp.setOwner(rs2.getString(1));
					}
					
					Statement st4 = con.createStatement();
					ResultSet rs3=st4.executeQuery("select productId,assigned,assignedBy from registrydetails where idRegistry='"+rs1.getInt(2)+"'");
					while(rs3.next()){
						ProdDetail pd = new ProdDetail();
						pd.setAssignment(rs3.getInt(2));

						pd.setProductId(rs3.getInt(1));
						
						Statement st5 = con.createStatement();
						ResultSet rs4 = st5.executeQuery("select * from product where productId = '"+rs3.getInt(1)+"' ");
						
						if(rs4.next()){
							pd.setProductName(rs4.getString(2));
							pd.setProductDescription(rs4.getString(3));
							pd.setComapny(rs4.getString(4));
							pd.setPrice(rs4.getDouble(5));
						}
						
						Statement st6 = con.createStatement();
						ResultSet rs5 = st6.executeQuery("select firstName from customer where userId = '"+rs3.getInt(3)+"' ");
						if(rs5.next()){
						pd.setAssignedby(rs5.getString(1));
						}
						else{
							pd.setAssignedby("");
						}
						prods.add(pd);
					}
					srp.setProdDetails(prods);
					srp.setStatus(1);
				}
			}
			else {
				srp.setStatus(0);
				srp.setError("Authentication Error");
				srp.setErrorcode(5); 	
			}
		}
		catch(Exception e){
			e.printStackTrace();
			srp.setStatus(0);
			srp.setError("DB Error");
			srp.setErrorcode(10);
		}
		
		
		return gson.toJson(srp);
	
	}
}