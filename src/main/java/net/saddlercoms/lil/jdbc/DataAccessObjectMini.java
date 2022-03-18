package net.saddlercoms.lil.jdbc;

import java.sql.Connection;

import net.saddlercoms.lil.jdbc.util.DataTransferObject;

public abstract class DataAccessObjectMini<T extends DataTransferObject> {
	protected final Connection connection;
	
	public DataAccessObjectMini(Connection connection) {
		this.connection = connection;
	}
	
	public abstract T findById(long id);
	
}
