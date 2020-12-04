package com.digimart.entity;

import java.sql.Date;

public class Offer {

	// , , , , , 
	
	private int offer_id;
	private String offer_name;
	private Date offer_start_date;
	private Date offer_end_date;
	private String offer_description;
	private String offer_code;
	/**
	 * @return the offer_id
	 */
	public int getOffer_id() {
		return offer_id;
	}
	/**
	 * @param offer_id the offer_id to set
	 */
	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}
	/**
	 * @return the offer_name
	 */
	public String getOffer_name() {
		return offer_name;
	}
	/**
	 * @param offer_name the offer_name to set
	 */
	public void setOffer_name(String offer_name) {
		this.offer_name = offer_name;
	}
	/**
	 * @return the offer_start_date
	 */
	public Date getOffer_start_date() {
		return offer_start_date;
	}
	/**
	 * @param offer_start_date the offer_start_date to set
	 */
	public void setOffer_start_date(Date offer_start_date) {
		this.offer_start_date = offer_start_date;
	}
	/**
	 * @return the offer_end_date
	 */
	public Date getOffer_end_date() {
		return offer_end_date;
	}
	/**
	 * @param offer_end_date the offer_end_date to set
	 */
	public void setOffer_end_date(Date offer_end_date) {
		this.offer_end_date = offer_end_date;
	}
	/**
	 * @return the offer_description
	 */
	public String getOffer_description() {
		return offer_description;
	}
	/**
	 * @param offer_description the offer_description to set
	 */
	public void setOffer_description(String offer_description) {
		this.offer_description = offer_description;
	}
	/**
	 * @return the offer_code
	 */
	public String getOffer_code() {
		return offer_code;
	}
	/**
	 * @param offer_code the offer_code to set
	 */
	public void setOffer_code(String offer_code) {
		this.offer_code = offer_code;
	}
	
	
	
}
