package com.mphasis.training.model;

import java.util.Date;

public class Details {
	private String customer_id;
	private String customer_name;
	private int age;
	private String pan_number;
	private String mail_id;
	private String password;
	private String phone_no;
	private String sb_account_id;
	private double sb_balance;
	private String fd_account_id;
	private double fixed_balance;
	private Date start_date;
	private Date end_date;
	private float fd_roi;
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPan_number() {
		return pan_number;
	}
	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getSb_account_id() {
		return sb_account_id;
	}
	public void setSb_account_id(String sb_account_id) {
		this.sb_account_id = sb_account_id;
	}
	public double getSb_balance() {
		return sb_balance;
	}
	public void setSb_balance(double sb_balance) {
		this.sb_balance = sb_balance;
	}
	public String getFd_account_id() {
		return fd_account_id;
	}
	public void setFd_account_id(String fd_account_id) {
		this.fd_account_id = fd_account_id;
	}
	public double getFixed_balance() {
		return fixed_balance;
	}
	public void setFixed_balance(double fixed_balance) {
		this.fixed_balance = fixed_balance;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public float getFd_roi() {
		return fd_roi;
	}
	public void setFd_roi(float fd_roi) {
		this.fd_roi = fd_roi;
	}
	
	
}
