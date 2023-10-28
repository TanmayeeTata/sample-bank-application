package com.mphasis.training.controller;

import com.mphasis.training.daoimpl.BankServicesImpl;
import com.mphasis.training.model.Details;
import com.mphasis.training.util.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TestClass {
	
	public static void main(String[] args) throws SQLException {
		Details d=new Details();
		BankServicesImpl bs=new BankServicesImpl();
		Scanner sc = new Scanner(System.in);
		Connection con = DbUtil.getConnection();
		
		
		
		
/*		String cid=bs.customerIdGenerator();
		d.setCustomer_name("akhil");
		d.setAge(22);
		d.setPan_number("AJKI1234");
		d.setMail_id("ajdbsfj");
		d.setPassword("AKHIL");
		d.setPhone_no("9133013333");
		String custid=bs.customerIdGenerator();
		d.setCustomer_id(custid);
		boolean check=bs.openSavingsAccount(d);
		if(check=true)
		{
			System.out.println("Account created");
		}
		else
			System.out.println("Account not created");*/
		
	}
	
}
