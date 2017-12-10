package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.UserService;
/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		String userName = request.getParameter("Name");
		String userPwd = request.getParameter("Password");

		UserService userService = new UserService();
		
		User user = userService.loginUser(userName, userPwd);
		User usgrade = userService.Usergrade(userName);
		HttpSession session = request.getSession(); 
		if (user!=null){
			if(usgrade==null){
				session.setAttribute("user", user);
				request.getRequestDispatcher("/Question.jsp").forward(request, response);
			}else{
				session.setAttribute("usgrade", usgrade);
				request.getRequestDispatcher("/User_result.jsp").forward(request, response);
			}
		}
		else
			response.sendRedirect("/java_web3.1/Login_i.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
