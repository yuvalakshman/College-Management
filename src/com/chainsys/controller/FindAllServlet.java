package com.chainsys.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.AdminDAO;
import com.chainsys.model.Students;

/**
 * Servlet implementation class FindAllServlet
 */
@WebServlet("/FindAllServlet")
public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response){

		AdminDAO dao = new AdminDAO();
		try {
			ArrayList<Students> list = new ArrayList<Students>();
			list = dao.findAll();
			request.setAttribute("STUDENTS", list);
			RequestDispatcher rd = request
					.getRequestDispatcher("studentsList.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
