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
import model.Task;

/**
 * Servlet implementation class SaveTaskServlet
 */
@WebServlet("/SaveTaskServlet")
public class SaveTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaveTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/task.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        
        String name=request.getParameter("name");  
        String description=request.getParameter("description"); 
        
        Task e=new Task();  
        e.setName(name);  
        e.setDescription(description);
        
        int status=TaskDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            response.sendRedirect("ViewTaskServlet");  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
      
	}

}
