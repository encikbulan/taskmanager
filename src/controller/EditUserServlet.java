package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaskDao;
import dao.UserDao;
import model.Task;
import model.User;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
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
	        				out.println("<li><a href='ViewUserServlet'>User</a></li>");
	        			out.println("</ul>");

	        			out.println("<ul class='nav navbar-nav navbar-right'>");
        					out.println("<li class='active' ><a href='EditUserServlet'>Profile</a></li>");
	        				out.println("<li><a href='Logout'><span class='glyphicon glyphicon-log-in'></span> logout</a></li>");
	        			out.println("</ul>");
	        			
	        		out.println("</div>");
	        	out.println("</nav>");
	        	
	        	out.println("<div class='container'>");
	        		out.println("<div class='panel panel-body' align='center'>");
	        			out.println("<div class='reg'>");
	        				HttpSession session = request.getSession();  
		        	        int id=Integer.parseInt((String) session.getAttribute("id"));
		        	        User e=UserDao.getUserById(id);
	        			 	out.println("<h1>Update Profile</h1>");
	        			 	out.print("<form action='EditUserServlet2' method='post'>");  
			        			out.print("<table>");  
				        			out.print("<tr><th></td><th><input type='hidden' name='id' value='"+e.getId()+"'/></td><td></td><p></tr>");  
				        	        out.print("<tr><th>First Name:</th><td><p><input type='text' name='firstName' value='"+e.getFirstName()+"'/></td><td></td><p></tr>");  
				        	        out.print("<tr><th>Last Name:</th><p><td><input type='Text' name='lastName' value='"+e.getLastName()+"'/></td><td></td><p></tr>");
				        	        out.print("<tr><th>Username:</th><p><td><input type='Text' DISABLED name='username' value='"+e.getUsername()+"'/></td><td></td><p></tr>");
				        	        out.print("<tr><th>Password:</th><p><td><input type='password' name='password' value='"+e.getPassword()+"'/></td><td></td><p></tr>");
				        	        out.print("<tr><th>Address:</th><p><td><input type='Text' name='address' value='"+e.getAddress()+"'/></td><td></td><p></tr>");
				        	        out.print("<tr><th>Contact:</th><p><td><input type='Text' name='contact' value='"+e.getContact()+"'/></td><td></td><p></tr>");
				        	        out.print("<tr><td colspan='2 style='text-align:right;><br><p class='submit'><input type='submit' value='Update Task'/></p></td></tr>");  
			        	        out.print("</table>"); 
			        	    out.print("</form>"); 
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
