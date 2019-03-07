package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.AdminDAO;
import com.chainsys.model.Admin;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String password = request.getParameter("password");
		String email = request.getParameter("email");

		Admin admin = new Admin();

		admin.setEmail(email);
		admin.setPassword(password);

		AdminDAO dao = new AdminDAO();

		try {
			boolean b = dao.existingAdmin(admin);
			if (b) {
				RequestDispatcher rd = request
						.getRequestDispatcher("admin.html");
				rd.forward(request, response);
			} else {
				request.setAttribute("MESSAGE",
						"!..INVALID EMAIL OR PASSWORD..!");
				RequestDispatcher rd = request
						.getRequestDispatcher("adminLogin.jsp");
				// out.println("invalid username or password");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
