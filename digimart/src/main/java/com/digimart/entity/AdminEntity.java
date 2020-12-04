package com.digimart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class AdminEntity {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int admin_id;
	@Column
	private String admin_name;
	@Column
	private String admin_mobile;
	@Column
	private String admin_email;
	@Column
	private String admin_password;
	/**
	 * @return the admin_id
	 */
	public int getAdmin_id() {
		return admin_id;
	}
	/**
	 * @param admin_id the admin_id to set
	 */
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	/**
	 * @return the admin_name
	 */
	public String getAdmin_name() {
		return admin_name;
	}
	/**
	 * @param admin_name the admin_name to set
	 */
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	/**
	 * @return the admin_mobile
	 */
	public String getAdmin_mobile() {
		return admin_mobile;
	}
	/**
	 * @param admin_mobile the admin_mobile to set
	 */
	public void setAdmin_mobile(String admin_mobile) {
		this.admin_mobile = admin_mobile;
	}
	/**
	 * @return the admin_email
	 */
	public String getAdmin_email() {
		return admin_email;
	}
	/**
	 * @param admin_email the admin_email to set
	 */
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	/**
	 * @return the admin_password
	 */
	public String getAdmin_password() {
		return admin_password;
	}
	/**
	 * @param admin_password the admin_password to set
	 */
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	@Override
	public String toString() {
		return "AdminEntity [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_mobile=" + admin_mobile
				+ ", admin_email=" + admin_email + ", admin_password=" + admin_password + "]";
	}
	
}
