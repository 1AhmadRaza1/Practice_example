package com.digimart.entity;

import java.sql.Date;

public class ProductMaster {
	
	private int product_master_id;
	private int cattegory_master_id;
	private int sub_cattegory_master_id;
	private String product_name;
	private String product_description;
	private int product_prise;
	private String product_photo;
	private Date product_expiry_date;
	private Date product_manufacture_date;
	private String product_company_name; 
	private String product_discount_type;
	private int product_discount;
	private String cattegory_name;
	private String sub_cattegory_name;
	
	
	/**
	 * @return the cattegory_name
	 */
	public String getCattegory_name() {
		return cattegory_name;
	}
	/**
	 * @param cattegory_name the cattegory_name to set
	 */
	public void setCattegory_name(String cattegory_name) {
		this.cattegory_name = cattegory_name;
	}
	/**
	 * @return the sub_cattegory_name
	 */
	public String getSub_cattegory_name() {
		return sub_cattegory_name;
	}
	/**
	 * @param sub_cattegory_name the sub_cattegory_name to set
	 */
	public void setSub_cattegory_name(String sub_cattegory_name) {
		this.sub_cattegory_name = sub_cattegory_name;
	}
	/**
	 * @return the product_master_id
	 */
	public int getProduct_master_id() {
		return product_master_id;
	}
	/**
	 * @param product_master_id the product_master_id to set
	 */
	public void setProduct_master_id(int product_master_id) {
		this.product_master_id = product_master_id;
	}
	/**
	 * @return the cattegory_master_id
	 */
	public int getCattegory_master_id() {
		return cattegory_master_id;
	}
	/**
	 * @param cattegory_master_id the cattegory_master_id to set
	 */
	public void setCattegory_master_id(int cattegory_master_id) {
		this.cattegory_master_id = cattegory_master_id;
	}
	/**
	 * @return the sub_cattegory_master_id
	 */
	public int getSub_cattegory_master_id() {
		return sub_cattegory_master_id;
	}
	/**
	 * @param sub_cattegory_master_id the sub_cattegory_master_id to set
	 */
	public void setSub_cattegory_master_id(int sub_cattegory_master_id) {
		this.sub_cattegory_master_id = sub_cattegory_master_id;
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
	 * @return the product_description
	 */
	public String getProduct_description() {
		return product_description;
	}
	/**
	 * @param product_description the product_description to set
	 */
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	/**
	 * @return the product_prise
	 */
	public int getProduct_prise() {
		return product_prise;
	}
	/**
	 * @param product_prise the product_prise to set
	 */
	public void setProduct_prise(int product_prise) {
		this.product_prise = product_prise;
	}
	/**
	 * @return the product_photo
	 */
	public String getProduct_photo() {
		return product_photo;
	}
	/**
	 * @param product_photo the product_photo to set
	 */
	public void setProduct_photo(String product_photo) {
		this.product_photo = product_photo;
	}
	/**
	 * @return the product_expiry_date
	 */
	public Date getProduct_expiry_date() {
		return product_expiry_date;
	}
	/**
	 * @param product_expiry_date the product_expiry_date to set
	 */
	public void setProduct_expiry_date(Date product_expiry_date) {
		this.product_expiry_date = product_expiry_date;
	}
	/**
	 * @return the product_manufacture_date
	 */
	public Date getProduct_manufacture_date() {
		return product_manufacture_date;
	}
	/**
	 * @param product_manufacture_date the product_manufacture_date to set
	 */
	public void setProduct_manufacture_date(Date product_manufacture_date) {
		this.product_manufacture_date = product_manufacture_date;
	}
	/**
	 * @return the product_company_name
	 */
	public String getProduct_company_name() {
		return product_company_name;
	}
	/**
	 * @param product_company_name the product_company_name to set
	 */
	public void setProduct_company_name(String product_company_name) {
		this.product_company_name = product_company_name;
	}
	/**
	 * @return the product_discount_type
	 */
	public String getProduct_discount_type() {
		return product_discount_type;
	}
	/**
	 * @param product_discount_type the product_discount_type to set
	 */
	public void setProduct_discount_type(String product_discount_type) {
		this.product_discount_type = product_discount_type;
	}
	/**
	 * @return the product_discount
	 */
	public int getProduct_discount() {
		return product_discount;
	}
	/**
	 * @param product_discount the product_discount to set
	 */
	public void setProduct_discount(int product_discount) {
		this.product_discount = product_discount;
	}
	@Override
	public String toString() {
		return "ProductMaster [product_master_id=" + product_master_id + ", cattegory_master_id=" + cattegory_master_id
				+ ", sub_cattegory_master_id=" + sub_cattegory_master_id + ", product_name=" + product_name
				+ ", product_description=" + product_description + ", product_prise=" + product_prise
				+ ", product_photo=" + product_photo + ", product_expiry_date=" + product_expiry_date
				+ ", product_manufacture_date=" + product_manufacture_date + ", product_company_name="
				+ product_company_name + ", product_discount_type=" + product_discount_type + ", product_discount="
				+ product_discount + ", cattegory_name=" + cattegory_name + ", sub_cattegory_name=" + sub_cattegory_name
				+ "]";
	}
	
	
	
}
