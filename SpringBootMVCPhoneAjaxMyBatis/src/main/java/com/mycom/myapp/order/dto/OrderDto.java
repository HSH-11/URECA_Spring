package com.mycom.myapp.order.dto;

public class OrderDto {
	private int orderId;
	private String userid;
    private int productId;
    private int quantity;
    private double totalAmount;
    private double discountAmount;
    private String shippingAddress;
     
    public OrderDto() {}

	public OrderDto(int orderId, String userid, int productId, int quantity, double totalAmount, double discountAmount,
			String shippingAddress) {
		this.orderId = orderId;
		this.userid = userid;
		this.productId = productId;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.discountAmount = discountAmount;
		this.shippingAddress = shippingAddress;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
       
	
    
    
}
