package com.chainsys.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.AdminDAO;
import com.chainsys.dao.StudentsDAO;
import com.chainsys.model.Students;
/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		int roll = Integer.parseInt(request.getParameter("roll"));
		Students students = new Students();
		students.setRoll(roll);
		AdminDAO dao = new AdminDAO();
		StudentsDAO daostu = new StudentsDAO();
		try {
			boolean b = daostu.checkStudent(students);
			if (b) {
				request.setAttribute("MESSAGE",
						"!!..Student Doesn't Exists..!!");
				RequestDispatcher rd = request
						.getRequestDispatcher("findByRoll.jsp");
				rd.include(request, response);
			} else {
				Students b1 = dao.findByRoll(students);
				request.setAttribute("students", b1);
				RequestDispatcher rd = request
						.getRequestDispatcher("student.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
