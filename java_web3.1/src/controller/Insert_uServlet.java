package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;
/**
 * Servlet implementation class LoginServlet
 */

public class Insert_uServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert_uServlet() {
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
		String Classes = request.getParameter("Classes");
		String number = request.getParameter("Number");
		
		User user = new User();;
		user.setName(userName);
		user.setPass(userPwd);
		user.setClasses(Classes);
		user.setNum(number);
		
		UserService userService = new UserService();
		
		Boolean bool = userService.registerUser(user);
		
		if(bool ==true){
			response.sendRedirect("/java_web3.1/Login_user.jsp");
		}else{
			response.sendRedirect("/java_web3.1/Login_m.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
