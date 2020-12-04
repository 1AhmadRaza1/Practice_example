package com.digimart.entity;

public class PurchaseProductItemMasterHistory {
	
	private int purchase_product_item_master_id;
	private int purchase_master_id;
	private int suplier_detail_id;
	private int product_master_id;
	private int purchase_item_master_id;
	private int product_item_quantity;
	private String purchase_date;
	
	
	/**
	 * @return the product_item_quantity
	 */
	public int getProduct_item_quantity() {
		return product_item_quantity;
	}
	/**
	 * @param product_item_quantity the product_item_quantity to set
	 */
	public void setProduct_item_quantity(int product_item_quantity) {
		this.product_item_quantity = product_item_quantity;
	}
	/**
	 * @return the purchase_product_item_master_id
	 */
	public int getPurchase_product_item_master_id() {
		return purchase_product_item_master_id;
	}
	/**
	 * @param purchase_product_item_master_id the purchase_product_item_master_id to set
	 */
	public void setPurchase_product_item_master_id(int purchase_product_item_master_id) {
		this.purchase_product_item_master_id = purchase_product_item_master_id;
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
	 * @return the suplier_detail_id
	 */
	public int getSuplier_detail_id() {
		return suplier_detail_id;
	}
	/**
	 * @param suplier_detail_id the suplier_detail_id to set
	 */
	public void setSuplier_detail_id(int suplier_detail_id) {
		this.suplier_detail_id = suplier_detail_id;
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
	 * @return the purchase_date
	 */
	public String getPurchase_date() {
		return purchase_date;
	}
	/**
	 * @param purchase_date the purchase_date to set
	 */
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

}
