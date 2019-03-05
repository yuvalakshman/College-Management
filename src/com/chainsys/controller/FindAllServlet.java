package com.chainsys.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindAllServlet
 */
@WebServlet("/FindAllServlet")
public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminDAO dao = new AdminDAO();
		try {
			ArrayList<Students> list=new ArrayList<Students>();
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
