package com.fullstack.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCRUDEx {

	Connection connection = null;

	public JDBCCRUDEx() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm?useSSL=false", "root",
						"root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		JDBCCRUDEx ex = new JDBCCRUDEx();
		// ex.createDatabase();
		// ex.createTable();
		// ex.insertData();
		// ex.readData();
		// ex.updateData();
		//ex.deleteById();
		ex.deleteAll();

	}

	void createDatabase() {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("create database hrm");

			preparedStatement.executeUpdate();

			System.out.println("Database Created Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void createTable() {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("create table employee(empid int, empname varchar(255), empsalary double)");

			preparedStatement.executeUpdate();
			System.out.println("Table Created successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void insertData() {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into employee values(122, 'LAKSHMI', 99000.96)");
			preparedStatement.executeUpdate();
			System.out.println("Data Inserted Successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void readData() {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getDouble(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void updateData() {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update employee set empsalary=250000.00 where empid=122");
			preparedStatement.executeUpdate();

			System.out.println("Data Updated Successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void deleteById() {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where empid=122");
			preparedStatement.executeUpdate();

			System.out.println("Data Deleted Successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void deleteAll() {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("TRUNCATE TABLE employee");

			preparedStatement.executeUpdate();

			System.out.println("Table Truncated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
