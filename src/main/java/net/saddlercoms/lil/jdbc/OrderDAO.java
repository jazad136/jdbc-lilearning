package net.saddlercoms.lil.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import net.saddlercoms.lil.jdbc.util.DataAccessObject;

public class OrderDAO extends DataAccessObject<Order>{

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
			+ "p.code, p.name, p.size, p.variety, p.price "
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
, p.code, p.name, p.variety, p.price FROM orders o join customer c on o.customer_id=c.customer_id join salesperson s on o.salesperson_id=s.salesperson_id join
 order_item ol on ol.order_id=o.order_id join product p on ol.product_id=p.product_id WHERE o.order_id=1000
 
 answer for 1000
last_name |        email        | order_id | status | last_name |          email          | quantity |  code   |     name      |  variety   | price
-----------+---------------------+----------+--------+-----------+-------------------------+----------+---------+---------------+------------+-------
 Crawford  | acrawford8p@com.com |     1000 | paid   | Kelley    | ekelleyu@hplussport.com |       31 | MWCRA20 | Mineral Water | Cranberry  |  1.79
 Crawford  | acrawford8p@com.com |     1000 | paid   | Kelley    | ekelleyu@hplussport.com |       17 | MWLEM32 | Mineral Water | Lemon-Lime |  3.69
 
 full answer
SELECT c.customer_id, c.first_name, c.last_name, c.email, o.order_id, o.creation_date, o.total_due, o.status, s.salesperson_id, s.first_name, s.last_name, s.email, 
ol.quantity, p.code, p.name, p.size, p.variety, p.price FROM orders o join customer c on o.customer_id=c.customer_id join salesperson s on o.salesperson_id=s.salesperson_id join
order_item ol on ol.order_id=o.order_id join product p on ol.product_id=p.product_id WHERE o.order_id=1000;
   1               2           3               4                  5               6               7            8          9              10            11                12               13         14            15          16       17        18   
 customer_id | first_name | last_name |        email        | order_id |    creation_date    | total_due | status | salesperson_id | first_name | last_name |          email          | quantity |  code   |     name      | size |  variety   | price
-------------+------------+-----------+---------------------+----------+---------------------+-----------+--------+----------------+------------+-----------+-------------------------+----------+---------+---------------+------+------------+-------
         413 | Angela     | Crawford  | acrawford8p@com.com |     1000 | 2016-05-14 00:00:00 |    118.22 | paid   |            130 | Edward     | Kelley    | ekelleyu@hplussport.com |       31 | MWCRA20 | Mineral Water |   20 | Cranberry  |  1.79
         413 | Angela     | Crawford  | acrawford8p@com.com |     1000 | 2016-05-14 00:00:00 |    118.22 | paid   |            130 | Edward     | Kelley    | ekelleyu@hplussport.com |       17 | MWLEM32 | Mineral Water |   32 | Lemon-Lime |  3.69
(2 rows)


	 */
//	private static final int idxLngCustomerId= 1;
	private static final int idxStrCustomerFirstName = 2;
	private static final int idxStrCustomerLastName = 3;
	private static final int idxStrCustomerEmail = 4;	
	private static final int idxLngOrderId = 5;
	private static final int idxDatCreationDate = 6;
	private static final int idxBdcTotalDue = 7;
	private static final int idxStrStatus = 8;
//	private static final int idxLngSalespersonId = 9;
	private static final int idxStrSalespersonFirstName = 10;
	private static final int idxStrSalespersonLastName = 11;
	private static final int idxStrSalespersonEmail = 12;
	private static final int idxIntQuantity = 13;
	private static final int idxStrProductCode = 14;
	private static final int idxStrProductName = 15;
	private static final int idxIntProductSize = 16;
	private static final int idxStrProductVariety = 17;
	private static final int idxBdcProductPrice = 18;
	
	// String labels will not be helpful, too many matching column names. 
//	private static final String lngCustomerId= "customer_id";
//	private static final String lngOrderId = "order_id";
//	private static final String strCreationDate = "creation_date";
//	private static final String dblTotalDue = "total_due";
//	private static final String strStatus = "status";
//	private static final String lngSalespersonId = "salesperson_id";
	

	public OrderDAO(Connection connection) {
		super(connection);
	}

	@Override
	public Order findById(long id) {
		Order order = new Order();
		try(PreparedStatement statement = connection.prepareStatement(GET_FULL_ONE);) { 
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			long orderId = 0;
			List<OrderLine> orderLines = new ArrayList<>();
			while(resultSet.next()) { 
				if(orderId == 0) { 
					order.setCustomerFirstName(resultSet.getString(idxStrCustomerFirstName));
					order.setCustomerLastName(resultSet.getString(idxStrCustomerLastName));
					order.setCustomerEmail(resultSet.getString(idxStrCustomerEmail));
					order.setId(resultSet.getLong(idxLngOrderId));
					orderId = order.getId();
					order.setCreationDate(new Date(resultSet.getDate(idxDatCreationDate).getTime()));
					order.setTotalDue(resultSet.getBigDecimal(idxBdcTotalDue));
					order.setStatus(resultSet.getString(idxStrStatus));
					order.setSalespersonFirstName(resultSet.getString(idxStrSalespersonFirstName));
					order.setSalespersonLastName(resultSet.getString(idxStrSalespersonLastName));
					order.setSalespersonEmail(resultSet.getString(idxStrSalespersonEmail));
				}
				OrderLine orderLine = new OrderLine();
				orderLine.setQuantity(resultSet.getInt(idxIntQuantity));
				orderLine.setProductCode(resultSet.getString(idxStrProductCode));
				orderLine.setProductName(resultSet.getString(idxStrProductName));
				orderLine.setProductSize(resultSet.getInt(idxIntProductSize));
				orderLine.setProductVariety(resultSet.getString(idxStrProductVariety));
				orderLine.setProductPrice(resultSet.getBigDecimal(idxBdcProductPrice));
				orderLines.add(orderLine);
			}
			order.setOrderLines(orderLines);
		}catch(SQLException e) { 
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return order;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order update(Order dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order create(Order dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
}
