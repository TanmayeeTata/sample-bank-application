package com.mphasis.training.daoimpl;

@SuppressWarnings("serial") 
public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String msg)
	{
		super(msg);
	}
}
