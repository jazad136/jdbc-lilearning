package net.saddlercoms.lil.jdbc;

import net.saddlercoms.lil.jdbc.util.DataTransferObject;

public class Customer implements DataTransferObject {
	private long id;
	private String firstName
	,lastName
	,email
	,phone
	,address
	,city
	,state
	,zipCode;
	
	public Customer() { } 
	public Customer(String firstName, String lastName, String email, String phone, String address, String city,
			String state, String zipCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public Customer(long id, String firstName, String lastName, String email, String phone, String address, String city,
			String state, String zipCode) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	/** Gets the value of id */
	public long getId() { return id; }
	/** Sets the value of id */
	public void setId(long id) { this.id = id; }
	
	/** Gets the value of firstName */
	public String getFirstName() { return firstName; }
	/** Sets the value of lastName */
	public void setFirstName(String firstName) { this.firstName = firstName; }
	
	/** Gets the value oflastName */
	public String getLastName() { return lastName; }
	/** Sets the value of lastName */
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	/** Gets the value of email */
	public String getEmail() { return email; }
	/** Sets the value of email */
	public void setEmail(String email) { this.email = email; }
	
	/** Gets the value of phone */
	public String getPhone() { return phone; }
	/** Sets the value of phone */
	public void setPhone(String phone) { this.phone = phone; }
	
	/** Gets the value of address */
	public String getAddress() { return address; }
	/** @param address the address to set */
	public void setAddress(String address) { this.address = address; }
	
	/** Gets the value of city */
	public String getCity() { return city; }
	/** Sets the value of city */
	public void setCity(String city) { this.city = city; }
	
	/** Gets the value of state */
	public String getState() { return state; }
	/** Sets the value of state */
	public void setState(String state) { this.state = state; }
	
	/** Gets the value of zipCode */
	public String getZipCode() { return zipCode; }
	/** Sets the value of zipCode */ 
	public void setZipCode(String zipCode) { this.zipCode = zipCode; }
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", city=" + city + ", state=" + state + ", zipCode="
				+ zipCode + "]";
	}
}
