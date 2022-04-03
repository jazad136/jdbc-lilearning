package net.saddlercoms.lil.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class JDBCExecutor8 {
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
			OrderDAO orderDAO = new OrderDAO(connection);
			int customerNumber = 413;
			List<Order> orders = orderDAO.getOrdersForCustomer(customerNumber);
			orders.forEach(System.out::println);
		} catch(SQLException e) { 
			e.printStackTrace();
		}
	}
		
}

