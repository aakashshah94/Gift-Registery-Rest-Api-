package com.testing;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.testing.model.AssignmentRequest;
import com.testing.model.AssignmentResponse;
import com.testing.model.GetRegistryRequest;
import com.testing.model.GetRegistryResponse;
import com.testing.model.GetSharedRegistryRequest;
import com.testing.model.GetSharedRegistryResponse;
import com.testing.model.RegistryDetailsRequest;
import com.testing.model.RegistryDetailsResponse;
import com.testing.model.SharedRegistryInfoRequest;
import com.testing.model.SharedRegistryInfoResponse;

/**
 * Servlet implementation class HandleShared
 */
@WebServlet("/HandleShared")
public class HandleShared extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Gson gson;
	Client client=ClientBuilder.newClient();
	WebTarget baseTarget = client.target("http://localhost:8080/GiftRegistry");
	WebTarget sharedTarget=baseTarget.path("getsharedregistry");
	WebTarget dataTarget=baseTarget.path("shared");
    WebTarget assignTarget=baseTarget.path("assign");
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleShared() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("called");
		GetSharedRegistryRequest regRequest=new GetSharedRegistryRequest(String.valueOf(request.getSession().getAttribute("token")),
				Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId")))
				,String.valueOf(request.getSession().getAttribute("email")));
		Gson gson=new Gson();
		String ans=gson.toJson(regRequest);
		Response postResponse=sharedTarget.request().post(Entity.json(ans));
		
		String data=postResponse.readEntity(String.class);
		System.out.println(data);
		GetSharedRegistryResponse obj=gson.fromJson(data, GetSharedRegistryResponse.class);
        if(obj.getStatus()==1)
        {
		    List<String> names=obj.getSharedRegistry();
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
		if(service.equals("regSharedDetail"))
		{
		 SharedRegistryInfoRequest req=new SharedRegistryInfoRequest(String.valueOf(request.getSession().getAttribute("token")),
				 Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId"))),String.valueOf(request.getSession().getAttribute("email")),
				 request.getParameter("regname"));
		 System.out.println("called details");
		 Gson gson=new Gson();
		 String ans=gson.toJson(req);
	     Response postResponse=dataTarget.request().header("key","trusted").post(Entity.json(ans));
	   	String data=postResponse.readEntity(String.class);
		System.out.println("this"+data);
		SharedRegistryInfoResponse obj=gson.fromJson(data, SharedRegistryInfoResponse.class);
         
		if(obj.getStatus()==1)
        {
		 request.setAttribute("jsonstring", new Gson().toJson(obj.getProdDetails()));
		 request.setAttribute("regname",request.getParameter("regname") );
		 request.getRequestDispatcher("/viewshared.jsp").forward(request, response);
      	}
		
      }
		if(service.equals("assignme"))
		{
			System.out.println("here");
			int id=Integer.parseInt(request.getParameter("data"));
			String regname=request.getParameter("rname");
			System.out.println(id+ " in assign"+ regname);
		    AssignmentRequest req=new AssignmentRequest(Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId"))),
		    		String.valueOf(request.getSession().getAttribute("token")),regname,id,regname);
		    Gson gson=new Gson();
			String ans=gson.toJson(req);
		    Response postResponse=assignTarget.request().header("key","trusted").post(Entity.json(ans));
		   	String data=postResponse.readEntity(String.class);
			System.out.println("assign:"+data);
			AssignmentResponse obj=gson.fromJson(data, AssignmentResponse.class);
	        if(obj.getStatus()==0)
	        {
	        	System.out.println("some error");
	        	
	        }
	    
		    
		}
	}

}
