package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.model.Department;
import com.chainsys.model.Students;
import com.chainsys.util.ConnectionUtil;

public class StudentsDAO {
	ResultSet resultSet = null;

	public boolean existingStudent(Students students) throws SQLException {
		boolean login = false;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;

		try {
			String sql = "select roll,password from students where roll=? and password=?";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, students.getRoll());
			preparedStatement.setString(2, students.getPassword());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				Integer checkUser = resultSet.getInt(1);
				String checkPass = resultSet.getString(2);
				System.out.println(checkUser + checkPass);
				if ((checkUser.equals(students.getRoll()))
						&& (checkPass.equals(students.getPassword()))) {
					login = true;

				} else {
					login = false;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return login;
	}

	public boolean checkStudent(Students students) throws SQLException {
		boolean insert = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select roll from students where roll=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, students.getRoll());
		resultSet = preparedStatement.executeQuery();

		try {
			if (resultSet.next()) {
				insert = false;

			} else {
				insert = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return insert;
	}
	public Students findStudent(Students students) throws SQLException {
		Students b = null;
		Department dept = new Department();
		DepartmentDAO dao1 = new DepartmentDAO();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from students where roll=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, students.getRoll());
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			b = new Students();
			b.setRoll(resultSet.getInt("roll"));
			b.setName(resultSet.getString("name"));
			b.setAttendance(resultSet.getFloat("attendance"));
			b.setCgpa(resultSet.getFloat("cgpa"));
			b.setBatch(resultSet.getString("batch"));
			b.setMail(resultSet.getString("mail"));
			b.setGender(resultSet.getString("gender"));
			dept.setDept_id(resultSet.getInt("dept_id"));
			b.setDepartment(dept);
			dept = dao1.getDept(dept.getDept_id());
			b.setDepartment(dept);

			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return b;
	}
}
