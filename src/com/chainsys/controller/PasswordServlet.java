package com.chainsys.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PasswordServlet
 */
@WebServlet("/PasswordServlet")
public class PasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String password = request.getParameter("password");

		Password pass = new Password();
		pass.setPassword(password);
		if (password.equals("password")) {
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("MESSAGE", "!..INVALID PASSWORD..!");
			RequestDispatcher rd = request.getRequestDispatcher("pass.jsp");
			rd.forward(request, response);
		}

	}

}
