package com.chainsys.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.AdminDAO;
import com.chainsys.model.Students;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int roll = Integer.parseInt(request.getParameter("roll"));

		Students students = new Students();
		students.setRoll(roll);
		AdminDAO dao = new AdminDAO();
		try {
			Students b = dao.findByRoll(students);
			request.setAttribute("students", b);
			RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
