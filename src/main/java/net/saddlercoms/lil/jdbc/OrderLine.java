package net.saddlercoms.lil.jdbc;

import java.math.BigDecimal;

public class OrderLine {
	private int quantity;
	private String productCode;
	private String productName; 
	private int productSize;
	private String productVariety;
	private BigDecimal productPrice;
	
	
	/** Gets the value of productQuantity */
	public int getQuantity() { return quantity; }
	/** Sets the value of productQuantity */
	public void setQuantity(int quantity) { this.quantity = quantity; }
	
	/** Gets the value of productCode */
	public String getProductCode() { return productCode; }
	/** Sets the value of productCode */
	public void setProductCode(String productCode) { this.productCode = productCode; }
	
	/** Gets the value of productName */
	public String getProductName() { return productName; }
	/** Sets the value of productName */
	public void setProductName(String productName) { this.productName = productName; }
	
	/** Gets the value of productSize */
	public int getProductSize() { return productSize; }
	/** Sets the value of productSize */
	public void setProductSize(int productSize) { this.productSize = productSize; }
	
	/** Gets the value of productVariety */
	public String getProductVariety() { return productVariety; }
	/** Sets the value of productVariety */
	public void setProductVariety(String productVariety) { this.productVariety = productVariety; }
	
	/** Gets the value of productPrice */
	public BigDecimal getProductPrice() { return productPrice; }
	/** Sets the value of productPrice */
	public void setProductPrice(BigDecimal productPrice) { this.productPrice = productPrice; }
	
	@Override
	public String toString() {
		return "OrderLine ["
				+   "quantity=" + quantity 
				+ ", productCode=" + productCode 
				+ ", productName=" + productName
				+ ", productSize=" + productSize 
				+ ", productVariety=" + productVariety 
				+ ", productPrice=" + productPrice 
				+ "]";
	}
	
	
}
