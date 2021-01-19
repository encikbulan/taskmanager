package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HistoryDao;
import dao.UserDao;
import model.History;
import model.User;

/**
 * Servlet implementation class ViewUserServlet
 */
@WebServlet("/ViewUserServlet")
public class ViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
        PrintWriter out=response.getWriter();
        out.println("<html>");
	        out.println("<head>");
	        	out.println("<title>View Task</title>");
	        	out.println("<link rel='stylesheet' href='css/layout.css' >");
	        	out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
	        	out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
	        	out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
	        out.println("</head>");
	        
	        out.println("<body>");
	        	out.println("<nav class='navbar navbar-inverse'>");
	        		out.println("<div class='container-fluid'>");
	        			out.println("<div class='navbar-header'>");
	        				out.println("<a class='navbar-brand' href='#'>Task Manager</a>");
	        			out.println("</div>");
	        			
	        			out.println("<ul class='nav navbar-nav'>");
	        				out.println("<li><a href='HomeServlet'>Home</a></li>");
	        				out.println("<li class='dropdown'><a class='dropdown-toggle' data-toggle='dropdown' href='#'>Task<span class='caret'></span></a>");
		        				out.println("<ul class='dropdown-menu'>");
		        					out.println("<li><a href='ViewTaskServlet'>List of Task</a></li>");
		        					out.println("<li><a href='SaveTaskServlet'>Add new Task</a></li>");
		        				out.println("</ul>");
	        				out.println("</li>");
	        				out.println("<li><a href='ViewHistoryServlet'>History</a></li>");
	        				out.println("<li class='active'><a href='#'>User</a></li>");
	        			out.println("</ul>");

	        			out.println("<ul class='nav navbar-nav navbar-right'>");
	        				out.println("<li><a></a></li>");
	        				out.println("<li><a href='EditUserServlet'>Profile</a></li>");
	        				out.println("<li><a href='Logout'><span class='glyphicon glyphicon-log-in'></span> logout</a></li>");
	        			out.println("</ul>");
	        			
	        		out.println("</div>");
	        	out.println("</nav>");
	        	
	        	out.println("<div class='container'>");
	        		out.println("<div class='panel panel-body' align='center'>");
	        			out.println("<div class='reg'>");
	        			out.println("<h1>List of User</h1>");
        	        	List<User> list = UserDao.getAllUser();
	        			out.print("<table border='1' width='100%'>");  
	        	        	out.print("<tr><th style='text-align:center'>Id</th><th style='text-align:center'>First Name</th><th style='text-align:center'>Last Name</th><th style='text-align:center'>Username</th><th style='text-align:center'>Address</th><th style='text-align:center'>Contact No</th></tr>");
	        	        	for(User e:list){  
	        	        		 out.print("<tr><td>"+e.getId()+"</td><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+"</td><td>"+e.getUsername()+"</td><td>"+e.getAddress()+"</td><td>"+e.getContact()+"</td></tr>");  
	        	        	}  
	        	        out.print("</table>");
	        			out.println("</div");
	        		out.println("</div");
	        	out.println("</div");
	        out.println("</body>");
        out.println("</html>");    
          
        out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
