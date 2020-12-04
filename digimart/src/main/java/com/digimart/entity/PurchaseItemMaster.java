package com.digimart.entity;

public class PurchaseItemMaster {
	
	private int purchase_item_master_id;
	private int purchase_master_id;
	private int product_master_id;
	private int quantity;
	private String product_name;
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
	 * @return the purchase_item_master_id
	 */
	public int getPurchase_item_master_id() {
		return purchase_item_master_id;
	}
	/**
	 * @param purchase_item_master_id the purchase_item_master_id to set
	 */
	public void setPurchase_item_master_id(int purchase_item_master_id) {
		this.purchase_item_master_id = purchase_item_master_id;
	}
	/**
	 * @return the purchase_master_id
	 */
	public int getPurchase_master_id() {
		return purchase_master_id;
	}
	/**
	 * @param purchase_master_id the purchase_master_id to set
	 */
	public void setPurchase_master_id(int purchase_master_id) {
		this.purchase_master_id = purchase_master_id;
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
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 
	
}
