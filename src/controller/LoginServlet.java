package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import dao.LoginDoa;

/**
 * Servlet implementation class login
 */
@WebServlet(name = "login", urlPatterns= {"/index.html", "/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private LoginDoa loginDao = new LoginDoa();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		String id;

		try {
			String destPage = "/WEB-INF/views/login.jsp";
			if (loginDao.validate(login)) {
				id = loginDao.validateID(login);
				HttpSession session = request.getSession();
				session.setAttribute("username",username);
				session.setAttribute("id",id);
				//session.setMaxInactiveInterval(30); // 30 seconds
				destPage = "/WEB-INF/views/Home.jsp";
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/registerSuccess.jsp");
				//dispatcher.forward(request, response);
			} else {
				String message = "Invalid email/password";
                request.setAttribute("message", message);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
