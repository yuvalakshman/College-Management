package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.AdminDAO;
import com.chainsys.model.Department;

/**
 * Servlet implementation class AddDeptServlet
 */
@WebServlet("/AddDeptServlet")
public class AddDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int dept_id = Integer.parseInt(request.getParameter("dept_id"));
		String name = request.getParameter("name");
		String hod = request.getParameter("hod");

		Department department = new Department();

		department.setDept_id(dept_id);
		department.setName(name);
		department.setHod(hod);

		AdminDAO dao = new AdminDAO();

		try {
			dao.addDept(department);
			List<Department> list = dao.allDept();
			request.setAttribute("DEPARTMENT", list);
			RequestDispatcher rd = request
					.getRequestDispatcher("departmentList.jsp");
			rd.include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
