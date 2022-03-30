package net.saddlercoms.lil.jdbc;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.saddlercoms.lil.jdbc.util.DataTransferObject;

/**
 * By Frank Moley, with syntactic sugar by Jonathan A. Saddler
 */
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
	private String customerFirstName;
	private String customerLastName; // spelled lastLane in video and code. 
	private String customerEmail;
	private Date creationDate;
	private BigDecimal totalDue;
	private String status;
	private String salespersonFirstName;
	private String salespersonLastName;
	private String salespersonEmail;
	private List<OrderLine> orderLines;
	
	public Order() {  }
	
	/** Gets the value of id */
	public long getId() { return id; }
	/** Sets the value of id */
	public void setId(long id) { this.id = id; }
	
	/** Gets the value of customerFirstName */
	public String getCustomerFirstName() { return customerFirstName; }
	/** Sets the value of customerFirstName */
	public void setCustomerFirstName(String value) { this.customerFirstName = value; } 
	
	/** Gets the value of customerLastName */
	public String getCustomerLastName() { return customerLastName; }
	/** Sets the value of customerLastName */
	public void setCustomerLastName(String value) { this.customerLastName = value; } 
	
	/** Gets the value of customerEmail */
	public String getCustomerEmail() { return customerEmail; }
	/** Sets the value of customerEmail */
	public void setCustomerEmail(String value) { this.customerEmail = value; } 
	
	/** Gets the value of creationDate */
	public Date getCreationDate() { return creationDate; }
	/** Sets the value of creationDate */
	public void setCreationDate(Date creation_date) { this.creationDate = creation_date; }

	/** Gets the value of totalDue */
	public BigDecimal getTotalDue() { return totalDue; }
	/** Sets the value of totalDue */
	public void setTotalDue(BigDecimal totalDue) { this.totalDue = totalDue; }

	/** Gets the value of status */
	public String getStatus() { return status; }
	/** Sets the value of status */
	public void setStatus(String status) { this.status = status; }

	/** Gets the value of salespersonFirstName */
	public String getSalespersonFirstName() { return salespersonFirstName; }
	/** Sets the value of salespersonFirstName */
	public void setSalespersonFirstName(String value) { this.salespersonFirstName = value; } 
	
	/** Gets the value of salespersonLastName */
	public String getSalespersonLastName() { return salespersonLastName; }
	/** Sets the value of salespersonLastName */
	public void setSalespersonLastName(String value) { this.salespersonLastName = value; } 
	
	/** Gets the value of salespersonEmail */
	public String getSalespersonEmail() { return salespersonEmail; }
	/** Sets the value of salespersonEmail */
	public void setSalespersonEmail(String value) { this.salespersonEmail = value; } 
	
	/** Gets the value of orderLines */
	public List<OrderLine> getOrderLines() { return orderLines; }
	/** Sets the value of orderLines */
	public void setOrderLines(List<OrderLine> value) { this.orderLines = value; }

	@Override
	public String toString() {
		return "Order ["
				+  "id=" + id 
				+", customerFirstName=" + customerFirstName 
				+", customerLastName=" + customerLastName
				+", customerEmail=" + customerEmail 
				+", creationDate=" + creationDate 
				+", totalDue=" + totalDue
				+", status=" + status 
				+", salespersonFirstName=" + salespersonFirstName 
				+", salespersonLastName=" + salespersonLastName 
				+", salespersonEmail=" + salespersonEmail 
				+", orderLines=" + orderLines + "]";
	} 	
}
