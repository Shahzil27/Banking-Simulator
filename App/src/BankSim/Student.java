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

	private Account savingsAccount;									// This is where the users saving account is stored
	private Account chequingAccount;								// This is where the users chequing account is stored
	private AccountHolderInfo studentAccountHolder; 					// This is where the users personal information is stored
	float dailyWithdrawCount;										// This is where the current amount of withdraws is stored
	int dailyTransactionCount;										// This is where the current running total of transactions is stored
	LocalDate dailyTrackingDate;  									// This is where the date is stored
	static final float DAILY_WITHDRAW_LIMIT = 3000f; 				// This is  where the daily withdraw limit is stored
	static final int DAILY_TRANSACTION_LIMIT = 100; 				// this is  where the daily transaction limit is stored
	
	/**This is  the constructor for the student class. It takes the account info and stores it inside the plan information
	 * as well as initiating its 2 accounts savings, and chequing.
	 * @param accountHolderInfo
	 */
	public Student(AccountHolderInfo accountHolderInfo) {
		studentAccountHolder = accountHolderInfo; 
		savingsAccount = new Account("savings", "001", 100.00f); 
		chequingAccount = new Account("chequing", "002", 80.00f);
		dailyWithdrawCount = 0f;
		dailyTransactionCount = 0;
		dailyTrackingDate = LocalDate.now(); 
		
	}
	
	/**this method allows the user to withdraw money from the selected account.
	 * @param withdrawAmount, the amount of funds that the account holder wishes to withdraw.
	 * @param account, account the funds will be withdrawn from.
	 * @return Tuple, a tuple type holding a string for description and a boolean for success or failure is returned.
	 */
	@Override
	public Tuple withdraw(float withdrawAmount, Account account) {
		
		float oldBalance = account.getBalance(); 
		String message;
		Tuple result;
		
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

	/** This method allows the user to deposit money into the selected account.
	 * @param depositAmount, the amount of funds that the account holder wishes to deposit.
	 * @param account, account the funds will be deposited to.
	 * @return Tuple, a tuple type holding a string for description and a boolean for success or failure is returned.
	 */
	@Override
	public Tuple deposit(float depositAmount, Account account) {
		
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

	/** This method allows the user to view the balance of the selected account.
	 * @param account, account that the holder wishes to view the funds of.
	 * @return float, float type is used to represent the monetary value. 
	 */
	@Override
	public float viewBalance(Account account) {
	
		return account.getBalance(); 
	}

	/** This method allows the user to move funds from one selcted account to another.
	 * @param transferFrom, account the funds will be taken out of.
	 * @param transferTo, account the funds will be put into.
	 * @param amount, the amount of funds that the account holder wishes to transfer.
	 * @return Tuple, a tuple type holding a string for description and a boolean for success or failure is returned.
	 */
	@Override
	public Tuple transferFunds(Account transferFrom, Account transferTo, float amount) {
		
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

	/** This method reset the counters present in the classes that will use the interface. It will reset the following counters:
	 * 		dailyWithdrawCount 
	 *		dailyTransactionCount 
	 */
	@Override
	public void resetCounters() {
		
		dailyWithdrawCount = 0; 
		dailyTransactionCount = 0;
	}
	
	/**this method returns the savings account so it can be used by other methods
	 * @return Account, the users savings account
	 */
	@Override
	public Account getSavings() {
		
		return savingsAccount;
	}
	
	/**this method returns the chequing account so it can be used by other methods
	 * @return Account, the users chequing account
	 */
	@Override
	public Account getChequing() {
		
		return chequingAccount;
	}
	
	/** This is a getter method for the local basicAccountHolder
	 * @return studentAccountHolder, studentAccountHolder is returned
	 */
	@Override
	public AccountHolderInfo getAccountHolderInfo() {
		return studentAccountHolder; 
	}

}

