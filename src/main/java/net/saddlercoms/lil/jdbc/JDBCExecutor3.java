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
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
//			while(resultSet.next()) { 
//				System.out.println(resultSet.getInt(1));
//			}
			Connection connection = dcm.getConnection();
			CustomerDAO customerDAO = new CustomerDAO(connection);
			Customer customer = new Customer();
			customer.setFirstName("George");
			customer.setLastName("Washington");
			customer.setEmail("george.washington@wh.gov");
			customer.setPhone("(555) 555-6543");
			customer.setAddress("1234 Main St");
			customer.setCity("Mount Vernon");
			customer.setState("VA");
			customer.setZipCode("21221");
			customerDAO.create(customer);
			
		} catch(SQLException e) { 
			e.printStackTrace();
		}
	}
		
}

