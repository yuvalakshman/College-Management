package com.chainsys.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.AdminDAO;
import com.chainsys.dao.StudentsDAO;
import com.chainsys.model.Department;
import com.chainsys.model.Students;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {

		int roll = Integer.parseInt(request.getParameter("roll"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		float attendance = Integer.parseInt(request.getParameter("attendance"));
		float cgpa = Integer.parseInt(request.getParameter("cgpa"));
		String batch = request.getParameter("batch");
		int dept_id = Integer.parseInt(request.getParameter("dept"));
		String mail = request.getParameter("mail");
		String gender = request.getParameter("gender");

		Students students = new Students();
		Department department = new Department();
		students.setRoll(roll);
		students.setName(name);
		students.setPassword(password);
		students.setAttendance(attendance);
		students.setCgpa(cgpa);
		students.setBatch(batch);
		students.setMail(mail);
		department.setDept_id(dept_id);
		students.setDepartment(department);
		students.setGender(gender);

		AdminDAO dao = new AdminDAO();
		StudentsDAO daostu = new StudentsDAO();
		try {
			boolean b = daostu.checkStudent(students);
			if (b) {
				dao.addStudents(students);
				ArrayList<Students> list = new ArrayList<Students>();
				list = dao.findAll();
				request.setAttribute("STUDENTS", list);
				RequestDispatcher rd = request
						.getRequestDispatcher("studentsList.jsp");
				rd.forward(request, response);
			} else {
				Students b1 = dao.findByRoll(students);

				request.setAttribute("MESSAGE",
						"..!!Student Already Exists..!!");
				request.setAttribute("students", b1);
				RequestDispatcher rd = request
						.getRequestDispatcher("student.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
