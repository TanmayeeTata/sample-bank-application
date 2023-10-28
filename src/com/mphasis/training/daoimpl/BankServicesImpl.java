package com.mphasis.training.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Random;

import com.mphasis.training.dao.EmployeeDao;
import com.mphasis.training.model.Details;
import com.mphasis.training.model.Employee;
import com.mphasis.training.util.DbUtil;

public class BankServicesImpl {
	Connection con = null;
	public BankServicesImpl() {
		con = DbUtil.getConnection();
	}
	/*public String openAccount() 
	{
		String 
		return null;
	}
*/	
	public boolean openSavingsAccount(Details details) throws SQLException {
		boolean flag = false,flag1=false;
		Savepoint savepoint=null;
		con.setAutoCommit(false);
		try {
			String sql = "INSERT into customer VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, details.getCustomer_id());
			ps.setString(2, details.getCustomer_name());
			ps.setInt(3, details.getAge());
			ps.setString(4, details.getPan_number());
			ps.setString(5, details.getMail_id());
			ps.setString(6, details.getPassword());
			ps.setString(7, details.getPhone_no());
			ps.executeUpdate();
			
			con.commit();
			savepoint=con.setSavepoint();
			
			sql="insert into savings_account values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, details.getSb_account_id());
			ps.setString(2, details.getCustomer_id());
			ps.setDouble(3, details.getSb_balance());
			ps.executeUpdate();

			con.commit();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return (flag&&flag1);
	}
	public String customerIdGenerator() throws SQLException
	{
		int value=0;
		boolean check ;
		int customer_no;
		String customer_id;
		do
		{
			value=0;
			Random rand=new Random();
			customer_no = rand.nextInt(89999)+10000;
			customer_id="MLA"+customer_no;
			String sql="select count(*) from customer where customer_id=?"; 
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, customer_id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				 value=rs.getInt(1);
			}
			if(value==0)
			{
				check=true;
			}
			else
				check=false;
		}while(check=false);
		return customer_id;
	}
	
	public void fundsTransfer(String from_account,double balance,String to_account) throws SQLException
	{
		Savepoint savepoint=null;
		con.setAutoCommit(false);
		double amount = 0;
		try
		{
			String sql="select balance from savings_account where sb_account_id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,from_account);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
				amount=rs.getInt(1);
			if((amount-balance)>1000)
			{
				sql="update account set balance=balance-? where sb_account_id=?";
				pst=con.prepareStatement(sql);
				pst.setDouble(1,balance);
				pst.setString(2, to_account);
				pst.executeUpdate();
				con.commit();
				savepoint=con.setSavepoint();
				String sql1="update account set balance=balance+? where sb_account_id=?";
				PreparedStatement pst1=con.prepareStatement(sql1);
				pst1.setDouble(1,balance);
				pst1.setString(2, to_account);
				pst1.executeUpdate();
				con.commit();
			}
			else
			{
				throw new InsufficientBalanceException("Transaction failed");
			}
			
		}
		catch(Exception e)
		{
			con.rollback(savepoint);
		}
		
	}
	
	boolean addEmployee(Employee e) throws SQLException
	{
		int i=0;
		boolean check=false;
		String sql="insert into employee values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, e.getEmployee_id());
		ps.setString(2, e.getEmployee_name());
		ps.setString(3,e.getDepartment_id());
		ps.setString(4, e.getEmployee_type());
		ps.setString(5, e.getPassword());
		ps.setString(6, e.getPan_number());
		i=ps.executeUpdate();
		if(i>0)
			check=true;
		else
			check=false;
		return check;
		
	}
	boolean removeEmployee(int employee_id) throws SQLException
	{
		int i=0;
		boolean check=false;
		String sql="delete from employee where employee_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, employee_id);
		i=ps.executeUpdate();
		if(i>0)
			check=true;
		else
			check=false;
		return check;
	}
	
	public Details getDetails(String account_id)
	{
		Details details=new Details();
		if(account_id.charAt(0)=='S')
		{
			String sql="select * from savings_account where ";
		}
		return details;
	}
	public int employeeIdGenerator() throws SQLException
	{
		
		int value;
		boolean check;
		int employee_id;
		do
		{
			value=0;
			check=false;
			Random rand=new Random();
			employee_id = rand.nextInt(89999)+10000;
			String sql="select count(*) from employee where employee_id=?"; 
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, employee_id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				 value=rs.getInt(1);
			}
			if(value==0)
			{
				check=true;
			}
			else
				check=false;
		}while(check=false);
		return employee_id;
	}
	
	public boolean validate_customer(String customer_id,String password) throws SQLException
	{
		int validator=0;
		String sql="select count(*) from customer where customer_id=? and password=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,customer_id);
		pst.setString(2, password);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			validator=rs.getInt(1);
		}
		if(validator>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean validate_employee(String employee_id,String password) throws SQLException
	{
		int validator=0;
		String sql="select count(*) from employee where employee_id=? and password=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,employee_id);
		pst.setString(2, password);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			validator=rs.getInt(1);
		}
		if(validator>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String accountIdGenerator(String type) throws SQLException
	{
		int value;
		boolean check;
		int account_no;
		String account_id = null;
		do
		{
			value=0;
			check=false;
			Random rand=new Random();
			account_no = rand.nextInt(89999)+10000;
			
			if(type.equalsIgnoreCase("SB"))
			{
				account_id="SB"+account_no;
			}
			else if(type.equalsIgnoreCase("FD"))
			{
				account_id="FD"+account_no;
			}
			String sql="select count(*) from account where account_id=?"; 
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, account_id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				 value=rs.getInt(1);
			}
			if(value==0)
			{
				check=true;
			}
			else
				check=false;
		}while(check=false);
		return account_id;
	}
}
