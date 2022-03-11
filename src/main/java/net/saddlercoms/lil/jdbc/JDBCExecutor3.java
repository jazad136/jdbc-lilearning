package net.saddlercoms.lil.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor3 {
	public static void main(String... args) {
//		System.out.println("Hello Learning JDBC");
		DatabaseConnectionManager dcm = new DatabaseConnectionManager(
				"localhost", 
				"hplussport", 
				"postgres", 
				"password");
		try { 
			Connection connection = dcm.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
			while(resultSet.next()) { 
				System.out.println(resultSet.getInt(1));
			}
			
		} catch(SQLException e) { 
			e.printStackTrace();
		}
	}
		
}

