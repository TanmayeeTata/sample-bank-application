package com.mphasis.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.training.daoimpl.BankServicesImpl;
import com.mphasis.training.model.Account;
import com.mphasis.training.model.Details;
/**
 * Servlet implementation class BankControllerServlet
 */
@WebServlet("/Bank")
public class BankController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private double amount;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankController() {
        super();
        //BankServicesImpl dao = new BankServicesImpl();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		Account a=new Account();
		BankServicesImpl dao=new BankServicesImpl();
		String account_id = null;
		List<Account> accounts;
		PrintWriter out=response.getWriter();
		if(action.equalsIgnoreCase("customer_login")) {
			String id=request.getParameter("customer_id");
			String password=request.getParameter("password");
			boolean check=false;
			try {
				if( dao.validate_customer(id,password))
				{
					RequestDispatcher rd=request.getRequestDispatcher("employeefeatures.html");
					rd.include(request, response);
					out.print("true");	
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("fd.html");
					rd.include(request, response);
					out.print("false");	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		else if(action.equalsIgnoreCase("openAccount"))
		{
			accounts=(List<Account>) dao.getDetails(account_id);
			request.setAttribute("account",a);
		
			if(action.equalsIgnoreCase("openSavingsAccount"))
			{
				accounts=(List<Account>) dao.getDetails(account_id);
				request.setAttribute("account",a);
			}
			/*else if(action.equalsIgnoreCase("openFixedDepositAccount"))
			{
				accounts=(List<Account>) dao.getDetails();
				request.setAttribute("account",a);
			}*/
		}
		/*else if(action.equalsIgnoreCase("closeAccount"))
		{
			if(action.equalsIgnoreCase("closeAccount"))
			{
				account_id=request.getParameter("account_id");
				dao.closeAccount(account_id);
				request.setAttribute("account", dao.getDetails());
			}
		}
			
		else if(action.equalsIgnoreCase("miniStatement"))
		{
			account_id=request.getParameter("account_id");
			dao.miniStatement(account_id);
			request.setAttribute("account", dao.miniStatement(account_id));
		}*/
		else if(action.equalsIgnoreCase("getDetails"))
		{
			Details details=new Details();
			account_id=request.getParameter("account_id");
			details=dao.getDetails(account_id);
			request.setAttribute("account", details);
		}
		
		else if(action.equalsIgnoreCase("addEmployee"))
		{
			
		}
		else if(action.equals("removeEmployee"))
		{
			
			
		}
		else if(action.equalsIgnoreCase("fundsTransfer"))
		{
			account_id=request.getParameter("account_id");
			String from_account = null;
			String to_account= null;
			try {
				dao.fundsTransfer(from_account,amount,to_account);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//request.setAttribute("account", dao.fundsTransfer(from_account,amount, to_account));
		}
		/*else if(action.equalsIgnoreCase("foreClose"))
		{
			account_id=request.getParameter("account_id");
			dao.miniStatement(account_id);
			//request.setAttribute("account", dao.foreClose(account_id));
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}