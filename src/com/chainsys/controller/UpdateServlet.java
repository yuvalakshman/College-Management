package com.chainsys.controller;

import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.AdminDAO;
import com.chainsys.dao.StudentsDAO;
import com.chainsys.model.Students;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		String name = request.getParameter("name");
		int roll = Integer.parseInt(request.getParameter("roll"));
		Students students = new Students();
		students.setName(name);
		students.setRoll(roll);
		AdminDAO dao = new AdminDAO();
		StudentsDAO daostu = new StudentsDAO();
		try {
			boolean b = daostu.checkStudent(students);
			if (b) {
				request.setAttribute("MESSAGE",
						"!!..Student Doesn't Exists..!!");
				RequestDispatcher rd = request
						.getRequestDispatcher("updateStudent.jsp");
				rd.include(request, response);
			} else {
				dao.updateStudents(students);
				ArrayList<Students> list = new ArrayList<Students>();
				list = dao.findAll();
				request.setAttribute("STUDENTS", list);
				RequestDispatcher rd = request
						.getRequestDispatcher("studentsListUP.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
