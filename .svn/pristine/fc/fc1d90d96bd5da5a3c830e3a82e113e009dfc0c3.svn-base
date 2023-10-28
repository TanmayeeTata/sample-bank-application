package com.mphasis.training.dao;

import com.mphasis.training.model.Details;

public interface ManagerDao {
	String openAccount(); 
	boolean openSavingsAccount(Details details);
	boolean openFixedDepositAccount(Details details);
	boolean closeAccount(String account_id);
	boolean closeSavingsAccount(String account_id);
	boolean foreclose(String account_id);
	void miniStatement(String account_id);
	Details getDetails(String account_id);
	boolean addEmployee(EmployeeDao e);
	boolean removeEmployee(int employee_id);

}
