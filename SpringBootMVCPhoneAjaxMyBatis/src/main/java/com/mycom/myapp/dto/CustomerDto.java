package com.mycom.myapp.dto;

public class CustomerDto {
	private Integer customerId; // int → Integer 변경 (AUTO_INCREMENT 대응)
	private String name;
	private String email;
	private String phone;
	private String address;

	public CustomerDto() {
	}

	// 조회용 생성자 (customerId 포함)
	public CustomerDto(Integer customerId, String name, String email, String phone, String address) {
			this.customerId = customerId;
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.address = address;
		}

	// 신규 고객 추가용 생성자 (customerId 없이)
	public CustomerDto(String name, String email, String phone, String address) {
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.address = address;
		}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerDto [customerId=" + customerId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + "]";
	}
	
	
}
