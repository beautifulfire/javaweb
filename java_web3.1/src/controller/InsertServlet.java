package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Insert;


/**
 * Servlet implementation class LoginServlet
 */

public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String qu = request.getParameter("jud_question");
		String an1 = request.getParameter("answer1");
		String an2 = request.getParameter("answer2");
		String ran = request.getParameter("rig_answer");
		if(!an1.equals(ran)&&!an2.equals(ran)){
			request.getRequestDispatcher("/Qu_bank.jsp").forward(request, response);
		}
		HttpSession session = request.getSession(); 
		String ids = (String)session.getAttribute("ids");
		if(qu!=""&&an1!=""&&an2!=""&&ran!=""){
			Insert ins = new Insert();
			ins.add(qu, an1, an2, ran, ids);
			request.getRequestDispatcher("/Qu_bank.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/Qu_bank.jsp").forward(request, response);
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
