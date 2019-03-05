package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String password =request.getParameter("password");
		int roll = Integer.parseInt(request.getParameter("roll"));
		
		Students students = new Students();
		
		students.setRoll(roll);
		students.setPassword(password);
		
		StudentsDAO dao = new StudentsDAO();
		
		try {
			boolean b = dao.existingStudent(students);
			if(b){
				
				AdminDAO dao1 = new AdminDAO();
				try {
					Students b1 = dao1.findByRoll(students);
					request.setAttribute("students", b1);
					RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
					rd.forward(request, response);
				}
				catch (Exception e) {
					e.printStackTrace();
					
				}
				//RequestDispatcher rd = request.getRequestDispatcher("student.html");
				//rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("studentLogin.html");
			//	out.println("invalid username or password");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
