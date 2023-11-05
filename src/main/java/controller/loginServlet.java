package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.taiKhoan;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/controller/login-servlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		
		
		taiKhoan user = new taiKhoan();
		user = taiKhoan.authenticateUser(username, password);
		HttpSession session = request.getSession();
		
		
		if (user != null) {
			session.setAttribute("loggedInUser", user);
			session.setAttribute("loginMessage", "");
			session.setAttribute("loginStatus", true);
//			request.getRequestDispatcher("/newsfeed.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/newsfeed.jsp");

;		}
		else {
			session.setAttribute("loginMessage", "Sai thông tin đăng nhập!");
			session.setAttribute("loginStatus", false);
//			request.getRequestDispatcher("/login&register.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/login&register.jsp");
		}
		
	}

}
