package com.mphasis.training.model;

public class Account {
	private String account_type;
	private String account_id;
	
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	
	@Override
	public String toString() {
		return "Account [account_type=" + account_type + ", account_id=" + account_id + "]";
	}
	
	
}
