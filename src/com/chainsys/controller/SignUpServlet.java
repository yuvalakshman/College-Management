package com.chainsys.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.AdminDAO;
import com.chainsys.model.Admin;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Admin admin = new Admin();

		admin.setEmail(email);
		admin.setPassword(password);
		admin.setName(name);

		AdminDAO dao = new AdminDAO();

		try {
			boolean b = dao.checkAdmin(admin);
			if (b) {

				dao.addAdmin(admin);
				RequestDispatcher rd = request
						.getRequestDispatcher("adminLogin.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("MESSAGE", "..!!Admin Already Exists..!!");
				RequestDispatcher rd = request
						.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
