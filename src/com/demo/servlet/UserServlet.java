package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.UserBean;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = (String) request.getParameter("method");
		if(method == null) {
			PrintWriter out = response.getWriter();
			out.println("invalid request");
		} else if(method.equals("login")) {
			Login(request, response);
		} else if(method.equals("logout")) {
			Logout(request, response);
		} else if(method.equals("register")) {
			Register(request, response);
		}
	}

	private void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		
		//check null
		if(username == null || password == null || password2 == null || email == null) {
			response.sendRedirect("register.jsp");
			return;
		}
		
		UserBean userBean = new UserBean();

		//validate
		boolean isExist = userBean.isExist(username);


		if(!isExist) {
			userBean.add(username, password, email);
			response.sendRedirect("login.jsp");
			return;
		} else {
			response.sendRedirect("register.jsp");
			return;
		}
	}

	private void Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		response.sendRedirect("login.jsp");
	}

	private void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//check null
		if(username == null || password == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		//validate
		UserBean userBean = new UserBean();
		boolean isValid = userBean.valid(username, password);
		
		if(isValid) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("welcome.jsp");
			return;
		} else {
			response.sendRedirect("login.jsp");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
