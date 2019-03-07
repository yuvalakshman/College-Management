package com.chainsys.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.AdminDAO;
import com.chainsys.dao.StudentsDAO;
import com.chainsys.model.Students;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

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
						.getRequestDispatcher("deleteStudent.jsp");
				rd.include(request, response);
			} else {
				dao.deleteStudents(students);
				ArrayList<Students> list = new ArrayList<Students>();
				list = dao.findAll();
				request.setAttribute("STUDENTS", list);
				RequestDispatcher rd = request
						.getRequestDispatcher("studentsListDEL.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
