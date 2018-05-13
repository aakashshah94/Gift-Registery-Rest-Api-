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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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

@Produces("application/json")
@Consumes("application/json")
@Path("/signupservice")
public class SignupUser {
	@Context
	HttpHeaders httpHeaders;

	
	@POST
	public String signupNewUser(String signupData) throws UnsupportedEncodingException{
		if(httpHeaders.getRequestHeader("key").get(0).equals("trusted"))
	   {
		HttpClient client =  HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("http://localhost:8080/GiftIt/GiftIt/check");
		post.setHeader("Content-Type", "application/json");
		StringEntity entity=new StringEntity(signupData); 
		post.setEntity(entity);
		String content="";
		try {
			HttpResponse response = client.execute(post);
			StatusLine status = response.getStatusLine();			
			content = EntityUtils.toString(response.getEntity());
			System.out.println(content);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		System.out.println("username Checked");
		System.out.print(content);
		Gson gson = new Gson();
		SignupResponse sp1 = gson.fromJson(content, SignupResponse.class);
		
		System.out.println(sp1.getStatus());
		
		if(sp1.getStatus() == 0){
			return content;
		}
		
		else{
			System.out.println("came here");
			client =  HttpClientBuilder.create().build();
			post = new HttpPost("http://localhost:8080/GiftIt/GiftIt/adduser");
			post.setHeader("Content-Type", "application/json");
			StringEntity entity1=new StringEntity(signupData); 
			post.setEntity(entity1);
			String contentAns="";
			try {
				HttpResponse response = client.execute(post);
				StatusLine status = response.getStatusLine();			
				contentAns = EntityUtils.toString(response.getEntity());
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		  return contentAns;
		}
	   }
		else
		{
			SignupResponse signup=new SignupResponse();
			signup.setError("not trusted");
			signup.setStatus(0);
			return new Gson().toJson(signup);
		}
	}

}
