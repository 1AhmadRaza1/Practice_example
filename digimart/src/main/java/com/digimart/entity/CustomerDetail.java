package com.digimart.entity;

import java.sql.Date;

public class CustomerDetail {

	private int customer_detail_id;
	private String customer_name;
	private String gender;
	private Date dob;
	private String email;
	private String mobile_number;
	/**
	 * @return the customer_detail_id
	 */
	public int getCustomer_detail_id() {
		return customer_detail_id;
	}
	/**
	 * @param customer_detail_id the customer_detail_id to set
	 */
	public void setCustomer_detail_id(int customer_detail_id) {
		this.customer_detail_id = customer_detail_id;
	}
	/**
	 * @return the customer_name
	 */
	public String getCustomer_name() {
		return customer_name;
	}
	/**
	 * @param customer_name the customer_name to set
	 */
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the mobile_number
	 */
	public String getMobile_number() {
		return mobile_number;
	}
	/**
	 * @param mobile_number the mobile_number to set
	 */
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	@Override
	public String toString() {
		return "CustomerDetail [customer_detail_id=" + customer_detail_id + ", customer_name=" + customer_name
				+ ", gender=" + gender + ", dob=" + dob + ", email=" + email + ", mobile_number=" + mobile_number + "]";
	}
	
}
