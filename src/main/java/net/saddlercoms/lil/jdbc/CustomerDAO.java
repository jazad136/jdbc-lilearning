package net.saddlercoms.lil.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import net.saddlercoms.lil.jdbc.util.DataAccessObject;

public class CustomerDAO extends DataAccessObject<Customer> {

	private static final String INSERT = "INSERT INTO customer (first_name, last_name, "
			+ "email, phone, address, city, state, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	public CustomerDAO(Connection connection) { super(connection); }
	
	@Override
	public Customer create(Customer dto) {
		try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) { 
			statement.setString(1, dto.getFirstName());
			statement.setString(2, dto.getLastName());
			statement.setString(3, dto.getEmail());
			statement.setString(4, dto.getPhone());
			statement.setString(5, dto.getAddress());
			statement.setString(6, dto.getCity());
			statement.setString(7, dto.getState());
			statement.setString(8, dto.getZipCode());
			statement.execute();
			return null;
		} catch(SQLException e) { 
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	@Override
	public Customer findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer update(Customer dto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
}
