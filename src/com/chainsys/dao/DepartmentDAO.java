package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.model.Department;
import com.chainsys.util.ConnectionUtil;

public class DepartmentDAO {
	
	ResultSet resultSet = null;
	/**
	 * 
	 * @param dept_id
	 * @return
	 * @throws SQLException
	 */

	public Department getDept(int dept_id) throws SQLException {
		Department dept = new Department();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select name,hod from department where dept_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, dept_id);
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			String name = resultSet.getString("name");
			String hod = resultSet.getString("hod");
			dept.setName(name);
			dept.setHod(hod);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return dept;

	}

	public ArrayList<Department> deptName() throws SQLException {

		Connection connection = ConnectionUtil.getConnection();
		String sql = "select dept_id,name from department";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		ArrayList<Department> list = new ArrayList<Department>();
		while (resultSet.next()) {
			Department dept = new Department();
			dept.setDept_id(resultSet.getInt("dept_id"));
			dept.setName(resultSet.getString("name"));

			list.add(dept);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return list;
	}

	public void addDept(Department department) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into department(dept_id,name,hod) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, department.getDept_id());
		preparedStatement.setString(2, department.getName());
		preparedStatement.setString(3, department.getHod());

		int rows = preparedStatement.executeUpdate();
		System.out.println("Rows inserted: " + rows);
		ConnectionUtil.close(connection, preparedStatement, resultSet);
	}

}
