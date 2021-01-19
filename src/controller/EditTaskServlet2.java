package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDao;
import model.Task;

/**
 * Servlet implementation class EditTaskServlet2
 */
@WebServlet("/EditTaskServlet2")
public class EditTaskServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*
    public EditTaskServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
        String name=request.getParameter("name");  
        String description=request.getParameter("description");
          
        Task e=new Task();  
        e.setId(id);  
        e.setName(name);  
        e.setDescription(description);
          
        int status=TaskDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewTaskServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
	}

}
