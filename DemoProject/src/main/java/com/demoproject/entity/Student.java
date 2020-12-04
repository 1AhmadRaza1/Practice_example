package com.demoproject.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalIdCache;
@NamedNativeQueries({
	@NamedNativeQuery(
	name="getStudentList",
	query="CALL getStudentList()",
	resultClass=Student.class)
})
@Entity
@Table(name="stud_registration")
public class Student {
	
	
	// stud_reg_id, stud_name, gender, dob, age, email, password, mobileno
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	Integer stud_reg_id;
	
	@Column
	String stud_name;
	
	@Column
	String gender;
	
	@Column
	private String dob;
	
	@Column
	String email;
	
	@Column
	String password;
	
	@Column
	String mobileno;

	public Integer getStud_reg_id() {
		return stud_reg_id;
	}

	public void setStud_reg_id(Integer stud_reg_id) {
		this.stud_reg_id = stud_reg_id;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	@Override
	public String toString() {
		return "Student [stud_reg_id=" + stud_reg_id + ", stud_name=" + stud_name + ", gender=" + gender + ", dob="
				+ dob + ", email=" + email + ", password=" + password + ", mobileno=" + mobileno + "]";
	}
	
}
