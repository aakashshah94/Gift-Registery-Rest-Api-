package com.testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
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
import com.testing.model.AddProductRequest;
import com.testing.model.AddProductResponse;
import com.testing.model.AllProductResponse;
import com.testing.model.CreateRegistryRequest;
import com.testing.model.CreateRegistryResponse;
import com.testing.model.LoginRequest;
import com.testing.model.LoginResponse;
import com.testing.model.LogoutRequest;
import com.testing.model.LogoutResponse;
import com.testing.model.Product;
import com.testing.model.SignUpRequest;
import com.testing.model.SignUpResponse;
import com.testing.model.UpdateProfileRequest;
import com.testing.model.UpdateProfileResponse;

import net.spy.memcached.MemcachedClient;

public class NewClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Gson gson;
	Client client=ClientBuilder.newClient();
	WebTarget baseTarget = client.target("http://localhost:8080/GiftRegistry");
	WebTarget loginTarget=baseTarget.path("loginservice");
    WebTarget  signUpTarget=baseTarget.path("signupservice");
	WebTarget  addProductTarget=baseTarget.path("additem");
	WebTarget getProductList=baseTarget.path("getallitems");
	WebTarget logoutTarget=baseTarget.path("logout");
	WebTarget createTarget=baseTarget.path("createregistry");
	MemcachedClient mcc;
    public NewClass() throws IOException {
        super();
        mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
        System.out.println("Connection to server sucessfully");
	      
		   
        gson=new Gson();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		      
		      // Connecting to Memcached server on localhost
		      
		      //not set data into memcached server
		      
		      //Get value from cache
		    if(mcc.get("pro")!=null)
		    {
		    	  String json = (String)mcc.get("products");
		    	  System.out.println("getting cached data");
		    	  response.setContentType("application/json");
				  response.setCharacterEncoding("UTF-8");
				  response.getWriter().write(json);
				  mcc.delete("product");
		    }
		    else{
		    	
		    
		    Response getResponse=getProductList.request().header("key", "trusted").get();
		    String ans=getResponse.readEntity(String.class);
		    System.out.println("ans:"+ans);
		    AllProductResponse allProductResponse = gson.fromJson(ans, AllProductResponse.class);
		    
		    List<Product> products=allProductResponse.getProducts();
		    String json = new Gson().toJson(products);
		    System.out.println("set to Cache:"+mcc.set("pro",10,json));
		    
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
		PrintWriter out=response.getWriter();
        String service=request.getParameter("service");	
		if(service.equals("register"))
		{
			SignUpRequest signupRequest=new SignUpRequest(request.getParameter("fname"),request.getParameter("lname"),
					request.getParameter("username"),request.getParameter("password"),Integer.parseInt(request.getParameter("security_que")),
					request.getParameter("security_answer"));
			Gson gson=new Gson();
			String ans=gson.toJson(signupRequest);
			Response postResponse=signUpTarget.request().header("key", "trusted").post(Entity.json(ans));
			
			String data=postResponse.readEntity(String.class);
			out.print(data);
			SignUpResponse obj=gson.fromJson(data, SignUpResponse.class);
	
			if(obj.getStatus()==1)
			{
				response.sendRedirect("https://localhost:8443/Testing"); 
			}
			else
			{
			    out.println(obj.getError());	
			}

			
	}
		else if(service.equals("addProduct"))
		{
			AddProductRequest addProductRequest=new AddProductRequest(request.getParameter("productName"),
					request.getParameter("productDescription"),
					request.getParameter("company"),
					Double.parseDouble(request.getParameter("price")),request.getParameter("image"));
			Gson gson=new Gson();
			String ans=gson.toJson(addProductRequest);
			Response postResponse=addProductTarget.request().post(Entity.json(ans));
			String data=postResponse.readEntity(String.class);
			AddProductResponse obj=gson.fromJson(data, AddProductResponse.class);
			if(obj.getStatus()==1)
			{
				response.sendRedirect("https://localhost:8443/Testing/admin"); 
			}
			else
			{
			    out.println(obj.getError());	
			}

			
	}

		else if(service.equals("login"))
		{
		LoginRequest loginRequest=new LoginRequest(request.getParameter("username"),request.getParameter("password"));
		Gson gson=new Gson();
		String ans=gson.toJson(loginRequest);
		Response postResponse=loginTarget.request().header("key", "user").post(Entity.json(ans));
		String data=postResponse.readEntity(String.class);
		out.print(data);
		LoginResponse obj=gson.fromJson(data, LoginResponse.class);
		if(obj.getStatus()==1)
		{
			HttpSession session=request.getSession();
		    System.out.println(obj.getUserId() );
			session.setAttribute("fname",obj.getFirstName());
			session.setAttribute("token", obj.getToken());
			session.setAttribute("username",obj.getEmail());
			session.setAttribute("userId",obj.getUserId() );
			session.setAttribute("email",obj.getEmail() );
			session.setAttribute("lname",obj.getLastName());
			
			response.sendRedirect("https://localhost:8443/Testing"); 
			out.print(obj);
		}
		else if(obj.getStatus()==2)
		{
			HttpSession session=request.getSession();
			session.setAttribute("usertype", "admin");
			session.setAttribute("userId",obj.getUserId() );
			session.setAttribute("fname",obj.getFirstName());
			session.setAttribute("token", obj.getToken());	
			response.sendRedirect("https://localhost:8443/Testing/admin/"); 
		
			out.print(obj);
		
		}
		else
		{
			String message = "Username or password invalid ";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		}
		else if(service.equals("logout"))
		{
			HttpSession session=request.getSession();
		     
			LogoutRequest logoutRequest=new LogoutRequest(Integer.parseInt(session.getAttribute("token").toString()),Integer.parseInt(session.getAttribute("userId").toString()));
			Gson gson=new Gson();
			String ans=gson.toJson(logoutRequest);
			Response postResponse=logoutTarget.request().post(Entity.json(ans));
			String data=postResponse.readEntity(String.class);
			LogoutResponse obj=gson.fromJson(data, LogoutResponse.class);
		    System.out.println(data);    
	        request.getSession().invalidate();
			response.sendRedirect("https://localhost:8443/Testing");
		}
		else if(service.equals("createregistry"))
		{
		   CreateRegistryRequest req=new CreateRegistryRequest();
		   req.setOwnerId(Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId"))));
		   req.setRegistryName(request.getParameter("registryName"));
		   req.setPp(Integer.parseInt(request.getParameter("privacy")));
		   req.setToken(String.valueOf(request.getSession().getAttribute("token")));
		   List<Integer> productId=new ArrayList<>();
		   List<String> shared=new ArrayList<>();
		   
		   if(req.getPp()==1)
		   {
			   String [] users=request.getParameterValues("username");
			   for(int i=0;i<users.length;++i)
			   {
				   shared.add(users[i]);
				}
			   
		   }
		   String [] names=request.getParameterValues("items");
		   for(int i=0;i<names.length;++i)
		   {
			   productId.add(Integer.parseInt(names[i]));
		   }
		   req.setProductId(productId);
		   req.setSharedId(shared);
		    String ans=gson.toJson(req);
			
		   Response postResponse=createTarget.request().post(Entity.json(ans));
			String data=postResponse.readEntity(String.class);
			CreateRegistryResponse obj=gson.fromJson(data, CreateRegistryResponse.class);
			response.sendRedirect("https://localhost:8443/Testing");
			
		   
		   
		}
		if(service.equals("getprofile"))
		{
			    HttpSession session=request.getSession();
			    JsonObject ob=new JsonObject();
			    ob.addProperty("name",session.getAttribute("fname").toString());
			    ob.addProperty("lname", session.getAttribute("lname").toString());
			    String json=gson.toJson(ob);
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json); 

		}
}

}
