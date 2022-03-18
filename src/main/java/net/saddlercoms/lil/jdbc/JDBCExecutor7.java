package net.saddlercoms.lil.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class JDBCExecutor7 {
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
			Order o = orderDAO.findById(1001);
			System.out.println(o);
//			List<Order> os = orderDAO.findAllById(1001);
//			System.out.println(os.stream().map(Order::toString).collect(Collectors.joining("\n")));
		} catch(SQLException e) { 
			e.printStackTrace();
		}
	}
		
}

