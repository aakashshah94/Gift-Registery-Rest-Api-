
package com.GiftIt;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.text.GapContent;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.json.JSONObject;

import com.GiftIt.model.LoginRequest;
import com.google.gson.Gson;
import com.GiftIt.model.LoginResponse;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/checkpassword")
public class ValidUser {

	@POST
	public String checkUserValidiy(String obj1){
		
		Connection con = null;
		Gson gson = new Gson();
		LoginRequest logreq = gson.fromJson(obj1, LoginRequest.class);
		
		String userN = logreq.getUserName();
		String pass = logreq.getPassword();
		LoginResponse logrep = new LoginResponse();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_registry","root","root");
			Statement st1 = con.createStatement();
			Statement st2 = con.createStatement();
			ResultSet rs = st1.executeQuery("select userId,type from login where email='"+userN+"' and password='"+pass+"'");
			//Checking if the username password match
			if(rs.next()){
				System.out.println(rs.getInt(1));
				logrep.setStatus(rs.getInt(2));
				logrep.setUserId(rs.getInt(1));
				
				
				int hashCode = String.valueOf(rs.getInt(1)).hashCode();
				st2.executeUpdate("update login SET token='"+hashCode+"' where userId = '"+rs.getInt(1)+"'");
				
				logrep.setToken(String.valueOf(hashCode));
				System.out.println("Valid User Called");
				
				ResultSet rs1 = st1.executeQuery("select firstName,lastName,email from customer where userId='"+rs.getInt(1)+"'");
				
				rs1.next();
				logrep.setFirstName(rs1.getString(1));
				logrep.setEmail(rs1.getString(3));
				logrep.setLastName(rs1.getString(2));
			}
		
			//if username password don't match, return failure.
			else{
				System.out.println("Invalid........");
				logrep.setStatus(0);
				logrep.setError("Email and Passwords don't matches");
				logrep.setErrorcode("1");
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return  gson.toJson(logrep);
	}	
}