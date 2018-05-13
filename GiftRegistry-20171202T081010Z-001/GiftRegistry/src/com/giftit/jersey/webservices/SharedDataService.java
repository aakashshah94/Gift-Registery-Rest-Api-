package com.giftit.jersey.webservices;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/shared")

public class SharedDataService {

    @Context
    HttpHeaders httpHeaders;

	
	@POST
	public String loginMethod(String loginData) throws UnsupportedEncodingException{
		System.out.println(httpHeaders.getRequestHeader("key").get(0));
		HttpClient client =  HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("http://localhost:8080/GiftIt/GiftIt/regshared");
		post.setHeader("Content-Type", "application/json");
		StringEntity entity=new StringEntity(loginData); 
		post.setEntity(entity);
		String content="";
		try {
			System.out.println("share info service");
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
