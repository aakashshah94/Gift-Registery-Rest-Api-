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
import com.testing.model.GetPublicRegistryRequest;
import com.testing.model.GetPublicRegistryResponse;
import com.testing.model.GetSharedRegistryRequest;
import com.testing.model.GetSharedRegistryResponse;

/**
 * Servlet implementation class HandlePublic
 */
@WebServlet("/HandlePublic")
public class HandlePublic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   
		Gson gson;
		Client client=ClientBuilder.newClient();
		WebTarget baseTarget = client.target("http://localhost:8080/GiftRegistry");
		WebTarget pubTarget=baseTarget.path("public");
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandlePublic() {
        super();
        
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("called");
		GetPublicRegistryRequest regRequest=new GetPublicRegistryRequest(String.valueOf(request.getSession().getAttribute("token")),
				Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId"))));
		Gson gson=new Gson();
		String ans=gson.toJson(regRequest);
		Response postResponse=pubTarget.request().post(Entity.json(ans));
		
		String data=postResponse.readEntity(String.class);
		System.out.println(data);
		GetPublicRegistryResponse obj=gson.fromJson(data, GetPublicRegistryResponse.class);
        if(obj.getStatus()==1)
        {
		    List<String> names=obj.getPublicRegistry();
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
		doGet(request, response);
	}

}
