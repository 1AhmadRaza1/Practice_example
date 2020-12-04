package com.digimart.entity;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseMaster {
//purchase_master_id, , purchaseDate
	private int purchase_master_id;
	private int suplier_detail_id;
	private String purchaseDate;
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
	 * @return the date
	 */
	public String getPurchaseDate() {
		return purchaseDate;
	}
	/**
	 * @param date the date to set
	 */
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "PurchaseMaster [purchase_master_id=" + purchase_master_id + ", suplier_detail_id=" + suplier_detail_id
				+ ", purchaseDate=" + purchaseDate + "]";
	}
	
	
}
