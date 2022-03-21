package net.saddlercoms.lil.jdbc;

import net.saddlercoms.lil.jdbc.util.DataTransferObject;

public class Order implements DataTransferObject {
	/*
  order_id bigint NOT NULL DEFAULT nextval('hp_order_seq'),
  creation_date timestamp DEFAULT NULL,
  total_due numeric(10,2) DEFAULT NULL,
  status varchar(50) DEFAULT NULL,
  customer_id bigint NOT NULL,
  salesperson_id bigint NOT NULL,
  PRIMARY KEY (order_id),
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
  FOREIGN KEY (salesperson_id) REFERENCES salesperson(salesperson_id)
	 */
	private long id;
	private String creationDate;
	private double totalDue;
	private String status;
	private long customerId;
	private long salespersonId;
	
	public Order() {  }
	
	public Order(long orderId, String creation_date, double totalDue, 
			String status, long customerId, long salespersonId) {
		this.id = orderId;
		this.creationDate = creation_date;
		this.totalDue = totalDue;
		this.status = status;
		this.customerId = customerId;
		this.salespersonId = salespersonId;
	}

	public long getId() { return id; }

	public void setId(long id) { this.id = id; }

	public String getCreationDate() { return creationDate; }

	public void setCreationDate(String creation_date) { this.creationDate = creation_date; }

	public double getTotalDue() { return totalDue; }

	public void setTotalDue(double total_due) { this.totalDue = total_due; }

	public String getStatus() { return status; }

	public void setStatus(String status) { this.status = status; }

	public long getCustomerId() { return customerId; }

	public void setCustomerId(long customerId) { this.customerId = customerId; }

	public long getSalespersonId() { return salespersonId; }

	public void setSalespersonId(long salespersonId) { this.salespersonId = salespersonId; }

	@Override
	public String toString() {
		return "Order [id=" + id + ", creationDate=" + creationDate + ", totalDue=" + totalDue + ", status=" + status
				+ ", customerId=" + customerId + ", salespersonId=" + salespersonId + "]";
	}
	
	
}
