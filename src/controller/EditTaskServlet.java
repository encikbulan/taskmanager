package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDao;
import model.Task;

/**
 * Servlet implementation class EditTaskServlet
 */
@WebServlet("/EditTaskServlet")
public class EditTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

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
	        				out.println("<li class='dropdown active'><a class='dropdown-toggle' data-toggle='dropdown' href='#'>Task<span class='caret'></span></a>");
		        				out.println("<ul class='dropdown-menu'>");
		        					out.println("<li><a href='ViewTaskServlet'>List of Task</a></li>");
		        					out.println("<li><a href='SaveTaskServlet'>Add new Task</a></li>");
		        				out.println("</ul>");
	        				out.println("</li>");
	        				out.println("<li><a href='ViewHistoryServlet'>History</a></li>");
	        				out.println("<li><a href='ViewUserServlet'>User</a></li>");
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
		        			String sid=request.getParameter("id");  
		        	        int id=Integer.parseInt(sid);
		        	        Task e=TaskDao.getTaskById(id);
		        	        
	        			 	out.println("<h1>Update Task</h1>");
	        			 	out.print("<form action='EditTaskServlet2' method='post'>"); 
			        			out.print("<table>");  
				        			out.print("<tr><th></td><th><input type='hidden' name='id' value='"+e.getId()+"'/></td><td></td><p></tr>");  
				        	        out.print("<tr><th>Name:</th><td><p><input type='text' name='name' value='"+e.getName()+"'/></td><td></td><p></tr>");  
				        	        out.print("<tr><th>Description:</th><p><td><input type='Text' name='description' value='"+e.getDescription()+"'/></td><td></td><p></tr>");
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

	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
