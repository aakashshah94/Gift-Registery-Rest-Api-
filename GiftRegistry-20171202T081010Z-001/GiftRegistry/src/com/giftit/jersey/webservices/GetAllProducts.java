package com.giftit.jersey.webservices;

import com.giftit.jersey.microservices.AllProductsForAdmin;
import com.giftit.jersey.modal.AllProductResponse;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.giftit.jersey.microservices.*;


@Path("/getallitems")
public class GetAllProducts {
	
	@Context
	HttpHeaders httpHeaders;

	@GET
	public String getProdcuts(){
		if(httpHeaders.getRequestHeader("key").get(0).equals("trusted"))
		{
		HttpClient client =  HttpClientBuilder.create().build();
		HttpGet get = new HttpGet("http://localhost:8080/GiftIt/GiftIt/getallproducts");
		get.setHeader("Content-Type", "application/json");
		get.setHeader("key", "trustedservice");
		String content="";
		try {
			HttpResponse response = client.execute(get);
			StatusLine status = response.getStatusLine();			
			content = EntityUtils.toString(response.getEntity());
	       }
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return content;
		}
		else
		{
			AllProductResponse all=new AllProductResponse();
			all.setStatus(0);
			all.setError("not trusted");
			Gson gson=new Gson();
			return gson.toJson(all);
		}
		
	}
}
