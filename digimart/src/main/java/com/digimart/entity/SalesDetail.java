package com.digimart.entity;

import java.sql.Date;

public class SalesDetail {

	private int sales_id;
	private String sales_name;
	private String suplier_name;
	private String product_name;
	private String mobile_number;
	private Date datetime;
	private int total_ammount;
	/**
	 * @return the sales_id
	 */
	public int getSales_id() {
		return sales_id;
	}
	/**
	 * @param sales_id the sales_id to set
	 */
	public void setSales_id(int sales_id) {
		this.sales_id = sales_id;
	}
	/**
	 * @return the sales_name
	 */
	public String getSales_name() {
		return sales_name;
	}
	/**
	 * @param sales_name the sales_name to set
	 */
	public void setSales_name(String sales_name) {
		this.sales_name = sales_name;
	}
	/**
	 * @return the suplier_name
	 */
	public String getSuplier_name() {
		return suplier_name;
	}
	/**
	 * @param suplier_name the suplier_name to set
	 */
	public void setSuplier_name(String suplier_name) {
		this.suplier_name = suplier_name;
	}
	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}
	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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
	/**
	 * @return the datetime
	 */
	public Date getDatetime() {
		return datetime;
	}
	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	/**
	 * @return the total_ammount
	 */
	public int getTotal_ammount() {
		return total_ammount;
	}
	/**
	 * @param total_ammount the total_ammount to set
	 */
	public void setTotal_ammount(int total_ammount) {
		this.total_ammount = total_ammount;
	}
	
	@Override
	public String toString() {
		return "SalesDetail [sales_id=" + sales_id + ", sales_name=" + sales_name + ", suplier_name=" + suplier_name
				+ ", product_name=" + product_name + ", mobile_number=" + mobile_number + ", datetime=" + datetime
				+ ", total_ammount=" + total_ammount + "]";
	}
	
}
