package com.chainsys.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAO {

	ResultSet resultSet = null;
	public void addStudents(Students students)
	{
		try {
			Connection connection = ConnectionUtil.getConnection();
			System.out.println(connection);
			String sql = "insert into students(roll,password,name,attendance,cgpa,batch,mail,dept_id) values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(3, students.getName());
			preparedStatement.setFloat(4,students.getAttendance());
			preparedStatement.setFloat(5,students.getCgpa());
			preparedStatement.setInt(1, students.getRoll());
			preparedStatement.setString(2,students.getPassword());
			preparedStatement.setString(6,students.getBatch());
			preparedStatement.setInt(8,students.getDepartment().getDept_id());
		//	System.out.println(students.getMail());
			preparedStatement.setString(7,students.getMail());
			
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted: " + rows);
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateStudents(Students students) throws SQLException {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "update students set name=? where roll=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, students.getName());
			preparedStatement.setInt(2, students.getRoll());
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows updated:" + rows);
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteStudents(Students students) throws SQLException {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "delete from students where roll =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, students.getRoll());

			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows deleted:" + rows);
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Students findByRoll(Students students) throws SQLException {
		Students b = null;
		Department dept = new Department();
		AdminDAO dao = new AdminDAO();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select roll,name,attendance,cgpa,batch,mail,dept_id from students where roll=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, students.getRoll());
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			b = new Students();
			b.setRoll(resultSet.getInt("roll"));
			//b.setPassword(resultSet.getString("password"));
			b.setName(resultSet.getString("name"));
			b.setAttendance(resultSet.getFloat("attendance"));
			b.setCgpa(resultSet.getFloat("cgpa"));
			b.setBatch(resultSet.getString("batch"));
			b.setMail(resultSet.getString("mail"));	
			//b.setDept_id(resultSet.getInt("dept_id"));
			dept.setDept_id(resultSet.getInt("dept_id"));
			b.setDepartment(dept);
			dept = dao.getDept(dept.getDept_id());
			b.setDepartment(dept);
				
			
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return b;
	}
	public ArrayList<Students> findAll() throws SQLException {
		AdminDAO dao = new AdminDAO();
		Department dept = new Department();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select roll,name,attendance,cgpa,batch,mail,dept_id from students";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		ArrayList<Students> list = new ArrayList<Students>();
		while (resultSet.next()) {
			Students b = new Students();
			b.setRoll(resultSet.getInt("roll"));
			//b.setPassword(resultSet.getString("password"));
			b.setName(resultSet.getString("name"));
			b.setAttendance(resultSet.getFloat("attendance"));
			b.setCgpa(resultSet.getFloat("cgpa"));
			b.setBatch(resultSet.getString("batch"));
			b.setMail(resultSet.getString("mail"));	
			//b.setDept_id(resultSet.getInt("dept_id"));
			dept.setDept_id(resultSet.getInt("dept_id"));
			b.setDepartment(dept);
			dept = dao.getDept(dept.getDept_id());
			b.setDepartment(dept);
					
			list.add(b);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		//System.out.println(list);
		return list;
		
	}
	public ArrayList<Department> allDept() throws SQLException
	{
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select dept_id,name,hod from department";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		ArrayList<Department> list = new ArrayList<Department>();
		while (resultSet.next())
		{
			Department dept = new Department();
			dept.setDept_id(resultSet.getInt("dept_id"));
			dept.setName(resultSet.getString("name"));
			dept.setHod(resultSet.getString("hod"));
			list.add(dept);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return list;
	}
	public boolean existingAdmin(Admin admin) throws SQLException
	{
		boolean login=false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from admin where email=? and password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
			try {
				preparedStatement.setString(1,admin.getEmail());
				preparedStatement.setString(2,admin.getPassword());
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()){
				
				String checkUser = resultSet.getString(1);
				String checkPass = resultSet.getString(2);
				if((checkUser.equalsIgnoreCase(admin.getEmail())) && (checkPass.equals(admin.getPassword())))
				{
				   login=true;	
				}
				else
				{
					login=false;
				}
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return login;
		}
	public boolean checkAdmin(Admin admin) throws SQLException
	{
		boolean signup=false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select email from admin where email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1,admin.getEmail());
		resultSet = preparedStatement.executeQuery();
		
		try {
			if(resultSet.next()){
				signup=false;
				return signup;
				
				}
				else 
				{
					signup=true;
					return signup;
				}
				 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return signup;
	}
	public void addAdmin(Admin admin)
	{
		try {
			Connection connection = ConnectionUtil.getConnection();
			System.out.println(connection);
			String sql = "insert into admin(email,password,name) values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(2,admin.getPassword());
			preparedStatement.setString(1,admin.getEmail());
			preparedStatement.setString(3,admin.getName());
			
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted: " + rows);
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Department getDept(int dept_id) throws SQLException
	{
		Department dept = new Department();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select name,hod from department where dept_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, dept_id);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		{
			String name = resultSet.getString("name");
			String hod = resultSet.getString("hod");
			dept.setName(name);
			dept.setHod(hod);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return dept;
		
	}
	public ArrayList<Department> deptName() throws SQLException 
	{
		
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select dept_id,name from department";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		ArrayList<Department> list = new ArrayList<Department>();
		while (resultSet.next())
		{
			Department dept = new Department();
			dept.setDept_id(resultSet.getInt("dept_id"));
			dept.setName(resultSet.getString("name"));
			
			list.add(dept);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return list;
	}
	public void addDept(Department department) throws SQLException
	{
		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into department(dept_id,name,hod) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, department.getDept_id());
		preparedStatement.setString(2,department.getName());
		preparedStatement.setString(3,department.getHod());
		
		int rows = preparedStatement.executeUpdate();
		System.out.println("Rows inserted: " + rows);
		ConnectionUtil.close(connection, preparedStatement, resultSet);
	}
	
	
}
