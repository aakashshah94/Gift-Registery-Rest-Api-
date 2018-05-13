package com.testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.testing.model.AllProductResponse;
import com.testing.model.DeleteItemRequest;
import com.testing.model.DeleteItemResponse;
import com.testing.model.ForgotPasswordRequest;
import com.testing.model.ForgotPasswordResponse;
import com.testing.model.GetPasswordRequest;
import com.testing.model.GetPasswordResponse;
import com.testing.model.GetRegistryRequest;
import com.testing.model.GetRegistryResponse;
import com.testing.model.Product;
import com.testing.model.RegistryDetailsRequest;
import com.testing.model.RegistryDetailsResponse;
import com.testing.model.SignUpRequest;
import com.testing.model.SignUpResponse;
import com.testing.model.UpdateProfileRequest;
import com.testing.model.UpdateProfileResponse;

/**
 * Servlet implementation class GetRegi
 */
@WebServlet("/reg")
public class GetRegi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Gson gson;
	Client client=ClientBuilder.newClient();
	WebTarget baseTarget = client.target("http://localhost:8080/GiftRegistry");
	WebTarget getRegistries=baseTarget.path("ownregistry");
    WebTarget getDetails=baseTarget.path("registrydetails");
    WebTarget getQue=baseTarget.path("forgot");
    WebTarget getPass=baseTarget.path("getpassword");
    WebTarget updateProf=baseTarget.path("updateprofile");
    WebTarget delete=baseTarget.path("delete");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRegi() {
        super();
        gson=new Gson();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GetRegistryRequest regRequest=new GetRegistryRequest(String.valueOf(request.getSession().getAttribute("token")),
				Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId"))));
		Gson gson=new Gson();
		String ans=gson.toJson(regRequest);
		Response postResponse=getRegistries.request().post(Entity.json(ans));
		
		String data=postResponse.readEntity(String.class);
		System.out.println(data);
		GetRegistryResponse obj=gson.fromJson(data, GetRegistryResponse.class);
        if(obj.getStatus()==1)
        {
		    List<String> names=obj.getRegistryName();
        	String json = new Gson().toJson(names);
		    System.out.println(json);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json); 
        }
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    String service=request.getParameter("service");	
			if(service.equals("regDetail"))
			{
			 RegistryDetailsRequest req=new RegistryDetailsRequest(String.valueOf(request.getSession().getAttribute("token")),
					 Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId"))),
							request.getParameter("regname"));
			 System.out.println("called details");
			 Gson gson=new Gson();
			 String ans=gson.toJson(req);
		     Response postResponse=getDetails.request().header("key","trusted").post(Entity.json(ans));
		   	String data=postResponse.readEntity(String.class);
			System.out.println(data);
			RegistryDetailsResponse obj=gson.fromJson(data, RegistryDetailsResponse.class);
	         
			if(obj.getStatus()==1)
	        {
			 request.setAttribute("jsonstring", new Gson().toJson(obj.getProductsDetails()));
			 request.setAttribute("regname",request.getParameter("regname") );
			 request.getRequestDispatcher("/viewown.jsp").forward(request, response);
	      	}
	      }
			else if(service.equals("check"))
			{
			    System.out.println(request.getParameter("name"));
			    
			    JsonObject  one=new JsonObject();
			    one.addProperty("one", "top");
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(one.toString());
			 
			}
			else if(service.equals("deleteproduct"))
			{
				String json=request.getParameter("data");
				DeleteItemRequest req=new DeleteItemRequest(request.getSession().getAttribute("token").toString(),
						Integer.parseInt(request.getSession().getAttribute("userId").toString()),Integer.parseInt(json));
				
				 System.out.println("called details");
				 Gson gson=new Gson();
				 String ans=gson.toJson(req);
			     Response postResponse=delete.request().post(Entity.json(ans));
			     String data=postResponse.readEntity(String.class);
				 System.out.println(data);
				 DeleteItemResponse obj=gson.fromJson(data, DeleteItemResponse.class);
		         
			}
			else if(service.equals("getquestion"))
			{
				System.out.println(request.getParameter("username"));
				ForgotPasswordRequest req=new ForgotPasswordRequest(request.getParameter("username"));;
				Gson gson=new Gson();
				String ans=gson.toJson(req);
			    Response postResponse=getQue.request().header("key","trusted").post(Entity.json(ans));
			   	String data=postResponse.readEntity(String.class);
				System.out.println(data);
				ForgotPasswordResponse obj=gson.fromJson(data, ForgotPasswordResponse.class);
		        if(obj.getStatus()==1)
		        {
		        	String question="";
		        	if(obj.getQuestion()==1)
		        	{
		        		question="What was you first school?";
		        	}
		        	else if(obj.getQuestion()==2)
		        	{
		        		question="What was your first pet?";
		        	}
		        	else if(obj.getQuestion()==3)
		        	{
		        		question="What is you mother's given name?";
		        	}
		        	else if(obj.getQuestion()==4)
		        	{
		        		question="what is youe best friend's name?";
		        	}
		        request.setAttribute("user",request.getParameter("username"));
				request.setAttribute("question",question);
				request.getSession().setAttribute("fuser",request.getParameter("username") );
				request.getRequestDispatcher("/forgetpass.jsp").forward(request, response);
			    }
		    	
		  }
			else if(service.equals("forgotpass"))
			{
	    	   GetPasswordRequest req=new GetPasswordRequest(String.valueOf(request.getSession().getAttribute("fuser")),request.getParameter("answer"));
	    		Gson gson=new Gson();
				String ans=gson.toJson(req);
			    Response postResponse=getPass.request().header("key","trusted").post(Entity.json(ans));
			   	String data=postResponse.readEntity(String.class);
				System.out.println(data);
				GetPasswordResponse obj=gson.fromJson(data, GetPasswordResponse.class);
				
				if(obj.getStatus()==1)
				{
				       System.out.println("pass is"+obj.getPassword());    
					   request.setAttribute("pass",obj.getPassword());
						request.getRequestDispatcher("/forgetpass.jsp").forward(request, response);
				}
		    
			}
			else if(service.equals("editprofile"))
		    {
				 HttpSession session=request.getSession();
				   
				UpdateProfileRequest req=new UpdateProfileRequest(session.getAttribute("token").toString(),
						Integer.parseInt(session.getAttribute("userId").toString()),request.getParameter("fname"),
						request.getParameter("lname"),"email");
				Gson gson=new Gson();
				String ans=gson.toJson(req);
			    Response postResponse=updateProf.request().post(Entity.json(ans));
			   	String data=postResponse.readEntity(String.class);
				System.out.println("here:"+data);
				UpdateProfileResponse obj=gson.fromJson(data, UpdateProfileResponse.class);
				if(obj.getStatus()==1)
				{
					session.setAttribute("fname", obj.getFirstName());
					session.setAttribute("lname", obj.getLastName());
					response.sendRedirect("https://localhost:8443/Testing");
					
				}
				else
				{
					 request.setAttribute("error",obj.getError());
						request.getRequestDispatcher("/viewprofile.jsp").forward(request, response);
				}
				
				
				
	       }
	        

	}

}
