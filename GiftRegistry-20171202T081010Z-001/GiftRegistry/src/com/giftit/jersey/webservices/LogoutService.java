package com.giftit.jersey.webservices;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.giftit.jersey.microservices.*;
import com.giftit.jersey.modal.LoginRequest;
import com.giftit.jersey.modal.SignupResponse;
import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/logout")
public class LogoutService {
	
	@POST
	public String logout(String token) throws UnsupportedEncodingException{
		
		HttpClient client =  HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("http://localhost:8080/GiftIt/GiftIt/logout");
		post.setHeader("Content-Type", "application/json");
		StringEntity entity=new StringEntity(token); 
		post.setEntity(entity);
		String content="";
		
		try {
			HttpResponse response = client.execute(post);
			StatusLine status = response.getStatusLine();			
			content = EntityUtils.toString(response.getEntity());
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return content;

	}

}