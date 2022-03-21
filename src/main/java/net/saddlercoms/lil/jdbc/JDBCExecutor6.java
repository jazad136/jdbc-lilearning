package net.saddlercoms.lil.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor6 {
	// select * from customer where customer_id = 10001;
	// select * from customer where customer_id = 10000;
	
	public static void main(String... args) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager(
				"localhost", 
				"hplussport", 
				"postgres", 
				"password");
		try { 
			Connection connection = dcm.getConnection();
			CustomerDAO customerDAO = new CustomerDAO(connection);
			long toDelete = 10001;
			customerDAO.delete(toDelete);
			System.out.println("Deleted " + toDelete + "!");
		} catch(SQLException e) { 
			e.printStackTrace();
		}
	}
		
}

