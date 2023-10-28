package com.mphasis.training.dao;

import com.mphasis.training.model.Customer;
import com.mphasis.training.model.Details;

public interface EmployeeDao {
	String openAccount(); 
	boolean openSavingsAccount(Customer customer);
	boolean openFixedDepositAccount(Customer customer);
	boolean closeAccount(String account_id);
	boolean closeSavingsAccount(String account_id);
	boolean foreclose(String account_id);
	void miniStatement(String account_id);
	
	Details getDetails(String account_id);
}
