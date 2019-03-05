package com.chainsys.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentsDAO {
	ResultSet resultSet = null;
	
	
	public boolean existingStudent(Students students) throws SQLException
	{
		boolean login=false;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
			
		try {
				String sql = "select roll,password from students where roll=? and password=?";
				 preparedStatement= connection.prepareStatement(sql);
				
				preparedStatement.setInt(1,students.getRoll());
				preparedStatement.setString(2,students.getPassword());
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()){
				
				Integer checkUser = resultSet.getInt(1);
				String checkPass = resultSet.getString(2);
				System.out.println(checkUser+checkPass);
				if((checkUser.equals(students.getRoll())) && (checkPass.equals(students.getPassword())))
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
	public boolean checkStudent(Students students) throws SQLException
	{
		boolean insert=false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select roll from students where roll=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1,students.getRoll());
		resultSet = preparedStatement.executeQuery();
		
		try {
			if(resultSet.next()){
				insert=false;
				
				}
				else 
				{
					insert=true;
					
				}
				 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insert;
	}
}
