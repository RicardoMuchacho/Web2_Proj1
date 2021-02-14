package servlets;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import helpers.DB;
import helpers.User;

/**
 * Servlet implementation class Register
 */
@MultipartConfig()
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	DB db = DB.getInstances();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register.html");
		dispatcher.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
    HttpServletResponse response) 
    throws ServletException, IOException {
		// TODO Auto-generated method stub
		DB db = DB.getInstances();

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		Boolean sub = Boolean.parseBoolean(request.getParameter("sub"));
		
		System.out.println(name);
		System.out.println(pass);
		System.out.println(email);
		System.out.println(age);
		System.out.println(address);
		System.out.println(sub);
		
		
		Object[] obj = {name, pass, age, address, sub, email};
		db.dbPrepareStatement("insert into users(name, password, age, address, subscribed, email) values( ?, ?, ?, ?, ?, ? )", obj);
		
		//String htmlResp = "<html> <h1> Register Succesfully!</h1></html>";
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register_success.html");
		dispatcher.forward(request,  response);

	}
	
	
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}

/* un paquete exclusivo para todos los servlets /
endpoints del proyecto, dentro de estos no habrá ninguna
logica, pues la misma se encuentra en los controllers, es
decir que cada servlet solo tiene una instancia del
controller pertinente para el acceso de los recursos*/
