/**
 *  @author Quinn Maloney SID 200431628
 *  Course: ENSE 375 Software Testing and Validation
 *  Instructors: Yogesh Sharma and Trevor Douglas
 *  Assignment: Group Course Project
 *  Other group members: Brooklyn Coulson, Shahzil Siddiqui
 *  Filename: Student.java
 * 
 *  Last Updated: July 14, 2024
 * 
 *  Description: This file describes one of the plans that the user can create within the Bank Simulation Application. With the Student Plan, there will only be two  
 *  accounts associated with the plan (Savings Account and a Chequing Account). The Account Holder will be able to simulate basic banking tasks like withdrawing funds, 
 *  depositing funds, and viewing Account Balances, and transfering funds between the accounts. The following restrictions associated with the Student Plan are as follows:
 *       > Maximum total withdraws the Account Holder can make within one day: $3000.00
 *       > Maximum number of transactions (deposits, withdraws, transfers) an Account Holder can perform within one day: 100
 */
package BankSim;

import java.time.LocalDate;

public class Student implements Plans {

	private Account savingsAccount;
	private Account chequingAccount;
	private AccountHolderInfo basicAccountHolder; 
	
	float dailyWithdrawCount;
	int dailyTransactionCount;
	LocalDate dailyTrackingDate;  
	
	float DAILY_WITHDRAW_LIMIT = 3000f; 
	int DAILY_TRANSACTION_LIMIT = 100; 
	
	public Student(AccountHolderInfo accountHolderInfo) {
		basicAccountHolder = accountHolderInfo; 
		savingsAccount = new Account("savings", "001", 100.00f); 
		chequingAccount = new Account("chequing", "002", 80.00f);
		dailyWithdrawCount = 0f;
		dailyTransactionCount = 0;
		dailyTrackingDate = LocalDate.now(); 
		
	}
	
	
	@Override
	public Tuple withdraw(float withdrawAmount, Account account) {
		// TODO Auto-generated method stub
		
		float oldBalance = account.getBalance(); 
		String message;
		Tuple result;
		// handle date checking to reset counters
		
		if (account.getBalance() >= withdrawAmount) {
			if (withdrawAmount <= DAILY_WITHDRAW_LIMIT) {
				if(dailyWithdrawCount <= DAILY_WITHDRAW_LIMIT) {
					if (dailyTransactionCount <= DAILY_TRANSACTION_LIMIT)	 {
						account.setBalance(account.getBalance() - withdrawAmount);
						dailyWithdrawCount = dailyWithdrawCount + withdrawAmount; 
						dailyTransactionCount = dailyTransactionCount + 1; 
						
						message = ("Success: $" + withdrawAmount + "withdrawn from " + oldBalance);
						return (result = new Tuple(true, message));
					}
					else {
						message = ("Failure: Daily transaction limit of " + DAILY_TRANSACTION_LIMIT + "reached for today"); 
						return (result = new Tuple(false, message));
					}	
				}
				else {
					message = ("Failure: Total Withdrawn exceeds daily withdraw limit. Withdrawn Today: " + dailyWithdrawCount); 
					return (result = new Tuple(false, message));
				}
			}
			else {
				message = ("Failure: $" + withdrawAmount + " exceeds daily withdraw limit of " + DAILY_WITHDRAW_LIMIT + "for Basic Plan." );
				return (result = new Tuple(false, message)); 
			}
		}
		else {
			message = ("Faiure: Not enough funds to withdraw $" + withdrawAmount + ", current balance: $" + oldBalance); 
			return (result = new Tuple(false, message)); 
		}
		
	}

	@Override
	public Tuple deposit(float depositAmount, Account account) {
		
		// handle date checking to reset counters
		String message;
		Tuple result;
		
		if(dailyTransactionCount <= DAILY_TRANSACTION_LIMIT) {
			dailyTransactionCount = dailyTransactionCount + 1; 
			account.setBalance(account.getBalance() + depositAmount);
			message = ("Success: $" + depositAmount + " deposited to " + account.getType() + " account"); 
			
			return (result = new Tuple(true, message)); 
		}
		else {
			message = ("Failure: Daily transaction limit of " + DAILY_TRANSACTION_LIMIT + "reached for today"); 
			return (result = new Tuple(false, message)); 
		}
		
	}

	@Override
	public float viewBalance(Account account) {
		
		//System.out.println(account.getType() + " Account Balance: $" + account.getBalance());
		return account.getBalance(); 
	}

	@Override
	public Tuple transferFunds(Account transferFrom, Account transferTo, float amount) {
		
		// handle date checking to reset counters
		String message;
		Tuple result;
		
		if(transferFrom.getBalance() < amount) {
			message = ("Failure: Not enough Funds "); 
			return (result = new Tuple(false, message));  
		}
		else if(dailyTransactionCount <= DAILY_TRANSACTION_LIMIT) {
			dailyTransactionCount = dailyTransactionCount + 1; 
			transferFrom.setBalance(transferFrom.getBalance() - amount);
			transferTo.setBalance(transferTo.getBalance() + amount);
			
			message = ("Success: $" + amount + " transferred from " + transferFrom.getType() + " account, to " + transferTo.getType() + " account"); 
			return (result = new Tuple(false, message));  
		}
		else {
			message = ("Failure: Daily transaction limit of " + DAILY_TRANSACTION_LIMIT + "reached for today"); 
			return (result = new Tuple(false, message));  
		}
	}

	@Override
	public void resetCounters() {
		
		dailyWithdrawCount = 0; 
		dailyTransactionCount = 0;
	}
	
	@Override
	public Account getSavings() {
		
		return savingsAccount;
	}
	
	@Override
	public Account getChequing() {
		
		return chequingAccount;
	}

}

