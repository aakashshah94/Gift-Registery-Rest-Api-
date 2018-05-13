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

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.giftit.jersey.modal.LoginRequest;
import com.giftit.jersey.modal.SignupResponse;
import com.google.gson.Gson;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/createregistry")
public class CreateRegitsryService {
		
		@POST
		public String newRegistry(String registryData) throws UnsupportedEncodingException{
			HttpClient client =  HttpClientBuilder.create().build();
			HttpPost post = new HttpPost("http://localhost:8080/GiftIt/GiftIt/test");
			post.setHeader("Content-Type", "application/json");
			StringEntity entity=new StringEntity(registryData); 
			post.setEntity(entity);
			String content="";
			try {
				System.out.println("service create");
				
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