package com.mphasis.training.dao;

import com.mphasis.training.model.Details;

public interface CustomerDao {
	boolean fundsTransfer(String from_account_id,String to_account_id);
	void miniStatement(String account_id);
	Details getDetails(String account_id);
	boolean foreClose(String account_id);
}
