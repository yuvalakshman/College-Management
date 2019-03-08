package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.StudentsDAO;
import com.chainsys.model.Students;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {

		String password = request.getParameter("password");
		int roll = Integer.parseInt(request.getParameter("roll"));
		Students students = new Students();
		students.setRoll(roll);
		students.setPassword(password);
		StudentsDAO dao = new StudentsDAO();
		try {
			boolean b = dao.existingStudent(students);
			if (b) {
				try {
					Students b1 = dao.findStudent(students);
					request.setAttribute("students", b1);
					RequestDispatcher rd = request
							.getRequestDispatcher("student.jsp");
					rd.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();

				}
			} else {
				request.setAttribute("MESSAGE",
						"!..INVALID EMAIL OR PASSWORD..!");
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
