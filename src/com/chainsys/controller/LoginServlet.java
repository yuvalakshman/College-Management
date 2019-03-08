package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.StudentsDAO;
import com.chainsys.model.Students;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		Integer roll = Integer.parseInt(request.getParameter("roll"));
		String password = request.getParameter("password");
		Students students = new Students();
		students.setRoll(roll);
		students.setPassword(password);
		StudentsDAO dao = new StudentsDAO();
		boolean b;
		try {
			b = dao.existingStudent(students);
			if (b) {
				RequestDispatcher rd = request
						.getRequestDispatcher("student.html");
				try {
					rd.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("studentLogin.html");
				try {
					rd.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
