package net.saddlercoms.lil.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class OrderDAO extends DataAccessObjectMini<Order>{

	private static final String GET_ONE = "SELECT "
			+ "c.first_name, c.last_name, c.email, "
			+ "o.order_id, o.creation_date, o.total_due, o.status, "
			+ "s.first_name, s.last_name, s.email, ol.quantity,"
			+ "p.code, p.name, p.size, p.price "
			+ "FROM orders o join customer c on o.customer_id=c.customer_id "
			+ "join salesperson s on o.salesperson_id=s.salesperson_id "
			+ "join order_item ol on ol.order_id=o.order_id "
			+ "join product p on ol.product_id=p.product_id "
			+ "WHERE o.order_id=?";
	
	private static final String GET_FULL_ONE = "SELECT "
			+ "c.customer_id, c.first_name, c.last_name, c.email, "
			+ "o.order_id, o.creation_date, o.total_due, o.status, "
			+ "s.salesperson_id, s.first_name, s.last_name, s.email, ol.quantity, "
			+ "p.code, p.name, p.size, p.price "
			+ "FROM orders o "
			+ "join customer c on o.customer_id=c.customer_id "
			+ "join salesperson s on o.salesperson_id=s.salesperson_id "
			+ "join order_item ol on ol.order_id=o.order_id "
			+ "join product p on ol.product_id=p.product_id "
			+ "WHERE o.order_id=?";
	
	/*
SELECT c.first_name, c.last_name, c.email, o.order_id, o.creation_date, o.total_due, o.status, s.first_name, s.last_name, s.email, ol.quantity
, p.code, p.name, p.size, p.price FROM orders o join customer c on o.customer_id=c.customer_id join salesperson s on o.salesperson_id=s.salesperson_id join
 order_item ol on ol.order_id=o.order_id join product p on ol.product_id=p.product_id WHERE o.order_id=1000

 answer for 1000: 
     1           2                 3                  4                5               6            7      8            9                 10 
  first_name | last_name |        email        | order_id |    creation_date    | total_due | status | first_name | last_name |          email          | quantity |  code
       11           12     13 
 |     name      | size | price
------------+-----------+---------------------+----------+---------------------+-----------+--------+------------+-----------+-------------------------+----------+--------
-+---------------+------+-------
 Angela     | Crawford  | acrawford8p@com.com |     1000 | 2016-05-14 00:00:00 |    118.22 | paid   | Edward     | Kelley    | ekelleyu@hplussport.com |       31 | MWCRA20
 | Mineral Water |   20 |  1.79
 Angela     | Crawford  | acrawford8p@com.com |     1000 | 2016-05-14 00:00:00 |    118.22 | paid   | Edward     | Kelley    | ekelleyu@hplussport.com |       17 | MWLEM32
 | Mineral Water |   32 |  3.69


 broken up
 
 SELECT c.last_name, c.email, o.order_id, o.status, s.last_name, s.email, ol.quantity
, p.code, p.name, p.price FROM orders o join customer c on o.customer_id=c.customer_id join salesperson s on o.salesperson_id=s.salesperson_id join
 order_item ol on ol.order_id=o.order_id join product p on ol.product_id=p.product_id WHERE o.order_id=1000
 
 answer for 1000
  last_name |        email        | order_id | status | last_name |          email          | quantity |  code   |     name      | price
-----------+---------------------+----------+--------+-----------+-------------------------+----------+---------+---------------+-------
 Crawford  | acrawford8p@com.com |     1000 | paid   | Kelley    | ekelleyu@hplussport.com |       31 | MWCRA20 | Mineral Water |  1.79
 Crawford  | acrawford8p@com.com |     1000 | paid   | Kelley    | ekelleyu@hplussport.com |       17 | MWLEM32 | Mineral Water |  3.69
 
 full answer
SELECT c.customer_id, c.first_name, c.last_name, c.email, o.order_id, o.creation_date, o.total_due, o.status, s.salesperson_id, s.first_name, s.last_name, s.email, 
ol.quantity, p.code, p.name, p.size, p.price FROM orders o join customer c on o.customer_id=c.customer_id join salesperson s on o.salesperson_id=s.salesperson_id join
order_item ol on ol.order_id=o.order_id join product p on ol.product_id=p.product_id WHERE o.order_id=1000;
    1            2             3                4                 5              6                7         8           9             10              11                  12             13           14          15            16     17         
 customer_id | first_name | last_name |        email        | order_id |    creation_date    | total_due | status | salesperson_id | first_name | last_name |          email          | quantity |  code   |     name      | size | price
-------------+------------+-----------+---------------------+----------+---------------------+-----------+--------+----------------+------------+-----------+-------------------------+----------+---------+---------------+------+-------
         413 | Angela     | Crawford  | acrawford8p@com.com |     1000 | 2016-05-14 00:00:00 |    118.22 | paid   |            130 | Edward     | Kelley    | ekelleyu@hplussport.com |       31 | MWCRA20 | Mineral Water |   20 |  1.79
         413 | Angela     | Crawford  | acrawford8p@com.com |     1000 | 2016-05-14 00:00:00 |    118.22 | paid   |            130 | Edward     | Kelley    | ekelleyu@hplussport.com |       17 | MWLEM32 | Mineral Water |   32 |  3.69
(2 rows)

	 */
	private static final int idxLngCustomerId= 1;
	private static final int idxLngOrderId = 5;
	private static final int idxStrCreationDate = 6;
	private static final int idxDblTotalDue = 7;
	private static final int idxStrStatus = 8;
	private static final int idxLngSalespersonId = 9;
	
	private static final String lngCustomerId= "customer_id";
	private static final String lngOrderId = "order_id";
	private static final String strCreationDate = "creation_date";
	private static final String dblTotalDue = "total_due";
	private static final String strStatus = "status";
	private static final String lngSalespersonId = "salesperson_id";
	

	public OrderDAO(Connection connection) {
		super(connection);
	}

	@Override
	public Order findById(long id) {
		Order order = new Order();
		try(PreparedStatement statement = connection.prepareStatement(GET_FULL_ONE);) { 
			statement.setLong(1, id);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			while(rs.next()) { 
				order.setCustomerId(rs.getLong(idxLngCustomerId));
				order.setId(rs.getLong(idxLngOrderId));
				order.setCreationDate(rs.getString(idxStrCreationDate));
				order.setTotalDue(rs.getDouble(idxDblTotalDue));
				order.setStatus(rs.getString(idxStrStatus));
				order.setSalespersonId(rs.getLong(idxLngSalespersonId));
			}
			rs.close();
		}catch(SQLException e) { 
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return order;
		
	}
	public List<Order> findAllById(long id) {
		List<Order> orders = new LinkedList<Order>();
		try(PreparedStatement statement = connection.prepareStatement(GET_FULL_ONE);) { 
			statement.setLong(1, id);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			while(rs.next()) {
				Order order = new Order();
				order.setCustomerId(rs.getLong(idxLngCustomerId));
				order.setId(rs.getLong(idxLngOrderId));
				order.setCreationDate(rs.getString(idxStrCreationDate));
				order.setTotalDue(rs.getDouble(idxDblTotalDue));
				order.setStatus(rs.getString(idxStrStatus));
				order.setSalespersonId(rs.getLong(idxLngSalespersonId));
				orders.add(order);
			}
			rs.close();
		}catch(SQLException e) { 
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return orders;
		
	}

}
