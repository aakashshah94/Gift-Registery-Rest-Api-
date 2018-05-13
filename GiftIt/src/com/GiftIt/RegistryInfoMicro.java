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

import com.GiftIt.model.Product;
import com.GiftIt.model.ProductsDetail;
import com.GiftIt.model.RegistryDetailsRequest;
import com.GiftIt.model.RegistryDetailsResponse;
import com.google.gson.Gson;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/registrydetailsmicro")
public class RegistryInfoMicro {

	@POST
	public String getRegistryInfo(String info){
		Gson gson = new Gson();
		RegistryDetailsRequest rd = gson.fromJson(info, RegistryDetailsRequest.class);
		RegistryDetailsResponse rdp = new RegistryDetailsResponse();
		System.out.println("token:"+rd.getToken()+" userid:"+rd.getOwnerId());
		Connection con = null;
		try {
				
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			Statement st1 = con.createStatement();
			Statement st2 = con.createStatement();
			ResultSet rs = st1.executeQuery("select token from login where userId='"+rd.getOwnerId()+"'");
			//Checking if the username password match
			rs.next();
			if(rs.getString(1).equals(rd.getToken())){
				
				ResultSet rs1 = st2.executeQuery("select idRegistry from registry where ownerId='"+rd.getOwnerId()+"' and registryName='"+rd.getRegistryName()+"'");
				if(rs1.next()){
					Statement st3=con.createStatement();
					ResultSet rs2 = st3.executeQuery("select sharedWithId from sharedwith where idRegistry = '"+rs1.getInt(1)+"'");
					ArrayList<String> shared = new ArrayList<String>();
					while(rs2.next()){
						shared.add(rs2.getString(1));
					}
					rdp.setSharedWith(shared);
					
					ArrayList<ProductsDetail> listProducts = new ArrayList<ProductsDetail>();
					ResultSet rs3 = st3.executeQuery("select productId,assignedby from registrydetails where idRegistry = '"+rs1.getInt(1)+"'");
					while(rs3.next()){
						Statement st4= con.createStatement();
						ResultSet rs4=st4.executeQuery("select * from product where productId="+rs3.getInt(1)+"");
						rs4.next();
						ProductsDetail pd = new ProductsDetail(rs4.getInt(1), rs4.getString(2), rs4.getString(3), rs4.getString(4), rs4.getDouble(5),"");
						if(rs3.getString(2)!=null){
							pd.setAssignedBy(rs3.getString(2));
						}
						listProducts.add(pd);
					}
					rdp.setProductsDetails(listProducts);
				}
				rdp.setStatus(1);
				
			}
			else {
				rdp.setStatus(0);
				rdp.setError("Authentication Error");
				rdp.setErrorcode(5); 	
			}
		}
		catch(Exception e){
			e.printStackTrace();
			rdp.setStatus(0);
			rdp.setError("DB Error");
			rdp.setErrorcode(10);
		}
		
		
		return gson.toJson(rdp);
	
	}
}