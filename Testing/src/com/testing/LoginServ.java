package com.testing;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.testing.model.LoginRequest;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/login")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Client client=ClientBuilder.newClient();
		WebTarget baseTarget = client.target("http://localhost:8080/GiftIt/GiftIt/");
		WebTarget loginTarget=baseTarget.path("loginservice");
		LoginRequest loginRequest=new LoginRequest(request.getParameter("username"),request.getParameter("password"));
		Gson gson=new Gson();
		String ans=gson.toJson(loginRequest);
		Response postResponse=loginTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(ans));
		out.println(postResponse.toString());
	
		//out.write(request.getParameter("password"));
	//	doGet(request, response);
	}

}
