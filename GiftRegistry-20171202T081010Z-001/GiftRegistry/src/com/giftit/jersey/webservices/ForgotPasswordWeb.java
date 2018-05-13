package com.giftit.jersey.webservices;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;



@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/forgot")
public class ForgotPasswordWeb {
	
		@POST
		public String getQuestion(String userId) throws UnsupportedEncodingException{
			HttpClient client =  HttpClientBuilder.create().build();
			HttpPost post = new HttpPost("http://localhost:8080/GiftIt/GiftIt/getquestion");
			post.setHeader("Content-Type", "application/json");
			StringEntity entity=new StringEntity(userId); 
			post.setEntity(entity);
			String content="";
			System.out.println("in service");
			
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