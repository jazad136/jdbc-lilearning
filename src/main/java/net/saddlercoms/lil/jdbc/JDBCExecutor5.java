package net.saddlercoms.lil.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor5 {
	public static void main(String... args) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager(
				"localhost", 
				"hplussport", 
				"postgres", 
				"password");
		try { 
			Connection connection = dcm.getConnection();
			CustomerDAO customerDAO = new CustomerDAO(connection);
//			Customer customer = customerDAO.findById(1000);
//			System.out.println(customer.getFirstName() + " " + customer.getLastName());
//			Customer customer = customerDAO.findById(10000);
//			customer.setCity("Spokane");
//			customer.setState("Washington");
//			customerDAO.update(customer);
//			System.out.println("Updated!");
			Customer customer = customerDAO.findById(10000);
			customer.setCity("Mount Vernon");
			customer.setState("VA");
			customer = customerDAO.update(customer);
			
			System.out.println("Re-Updated!");
		} catch(SQLException e) { 
			e.printStackTrace();
		}
	}
		
}

