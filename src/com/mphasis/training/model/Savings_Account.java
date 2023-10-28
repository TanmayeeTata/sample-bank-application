package com.mphasis.training.model;

public class Savings_Account {
	private String sb_account_id;
	private String customer_id;
	private double balance;
	
	public String getSb_account_id() {
		return sb_account_id;
	}
	public void setSb_account_id(String sb_account_id) {
		this.sb_account_id = sb_account_id;
	}
/*	public Customer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}*/
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
