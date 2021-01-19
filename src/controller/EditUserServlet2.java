package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDao;
import dao.UserDao;
import model.Task;
import model.User;

/**
 * Servlet implementation class EditUserServlet2
 */
@WebServlet("/EditUserServlet2")
public class EditUserServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String firstName=request.getParameter("firstName");  
        String lastName=request.getParameter("lastName");
        String username=request.getParameter("username");  
        String password=request.getParameter("password");
        String address=request.getParameter("address"); 
        String contact=request.getParameter("contact");
          
        User e=new User();  
        e.setId(id);  
        e.setFirstName(firstName);  
        e.setLastName(lastName);
        e.setUsername(username);
        e.setPassword(password);  
        e.setAddress(address);
        e.setContact(contact);
        
        int status=UserDao.update(e);
        
        if(status>0){  
        	String message = "Successfully Update";
            request.setAttribute("message", message);
            response.sendRedirect("EditUserServlet"); 
        }else{  
        	String message = "Unable to Update Record";
            request.setAttribute("message", message);  
        }
          
        out.close();  
	}

}
