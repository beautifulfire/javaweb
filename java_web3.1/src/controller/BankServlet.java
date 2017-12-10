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

public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String se = request.getParameter("se");
		String up = request.getParameter("up");
		String de = request.getParameter("de");
		String in = request.getParameter("in");
		String out = request.getParameter("out");
		String select = request.getParameter("select");
		String update = request.getParameter("update");
		String delete = request.getParameter("delete");
		HttpSession session = request.getSession();
		if(se!=null&&select!=""){
			session.setAttribute("ses",select);
			response.sendRedirect("/java_web3.1/Select.jsp");
		}
		if(up!=null&&update!=""){
			session.setAttribute("ups",update);
			response.sendRedirect("/java_web3.1/Update.jsp");
		}
		if(de!=null&&delete!=""){
			session.setAttribute("des",delete);
			response.sendRedirect("/java_web3.1/Delete.jsp");
		}
		if(in!=null){
			session.setAttribute("ins",in);
			response.sendRedirect("/java_web3.1/Insert.jsp");	
		}
		if(out!=null){
			session.invalidate();
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
