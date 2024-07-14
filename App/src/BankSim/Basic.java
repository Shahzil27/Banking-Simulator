/**
 *  @author Shahzil Siddiqui SID 200448986
 *  Course: ENSE 375 Software Testing and Validation
 *  Instructors: Yogesh Sharma and Trevor Douglas
 *  Assignment: Group Course Project
 *  Other group members: Brooklyn Coulson, Quinn Maloney
 *  Filename: Basic.java
 * 
 *  Date Created: July 05, 2024
 * 
 *  Description: This file describes one of the plans that the user can create within the Bank Simulation Application. With the Basic Plan, there will only be two  
 *  accounts associated with the plan (Savings Account and Checkings Account). The Account Holder will be able to simulate basic banking tasks like withdrawing funds, 
 *  depositing funds, and viewing Account Balances, and transfering funds between the accounts. The following restrictions associated with the Basic Plan are as follows:
 *       > Maximum funds that an Account (Savings Account) within this plan can hold: $1,000,000
 *       > Maximum total withdraws the Account Holder can make within one day: $200
 *       > Maximum number of transactions (deposits, withdraws, transfers) an Account Holder can perform within one day: 10
 */

package BankSim;

import java.time.LocalDate;

public class Basic implements Plans {
	
	private Account savingsAccount;
	private Account chequingAccount;
	private AccountHolderInfo basicAccountHolder; 
	
	float dailyWithdrawCount;
	int dailyTransactionCount;
	LocalDate dailyTrackingDate;  
	
	float DAILY_WITHDRAW_LIMIT = 200f; 
	int DAILY_TRANSACTION_LIMIT = 10; 
	
	
	/** This is a constructor for the Basic class that sets the given account holder information and initializes two accounts. 
	 *  Namely, a checking and a savings account with preset balances to compliment the simulation. The constructor also sets 
	 *  the counts to 0 for both counters and initializes the current relative local date.   
	 * @param accountHolderInfo
	 */
	public Basic(AccountHolderInfo accountHolderInfo)
	{
		basicAccountHolder = accountHolderInfo; 
		savingsAccount = new Account("savings", "3478 4733 5684 2938", 500.00f); 
		chequingAccount = new Account("checking", "3478 4733 5684 2939", 2500.00f);
		dailyWithdrawCount = 0f;
		dailyTransactionCount = 0;
		dailyTrackingDate = LocalDate.now(); 
		
	}
	
	
	/** This method allows for the account holder to be able to withdraw a certain amount of money from a specific account. 
	 * @param withdrawAmount, the amount of funds that the account holder wishes to withdraw.
	 * @param account, account the funds will be withdrawn from.
	 * @return Tuple, a tuple type holding a string for description and a boolean for success or failure is returned.
	 */
	@Override
	public Tuple withdraw(float withdrawAmount, Account account) {
		// TODO Auto-generated method stub
		Tuple result = new Tuple();
		float oldBalance = account.getBalance(); 
		
		// handle date checking to reset counters
		
		if (account.getBalance() >= withdrawAmount)
		{
			if (withdrawAmount <= DAILY_WITHDRAW_LIMIT)
			{
				if(dailyWithdrawCount <= DAILY_WITHDRAW_LIMIT)
				{
					if (dailyTransactionCount <= DAILY_TRANSACTION_LIMIT)	
					{
						account.setBalance(account.getBalance() - withdrawAmount);
						dailyWithdrawCount = dailyWithdrawCount + withdrawAmount; 
						dailyTransactionCount = dailyTransactionCount + 1; 
						
						result.setTaskStateDescription("Success: $" + withdrawAmount + " withdrawn from " + oldBalance);
						result.setTaskStatus(true);
						return result;
					}
					else
					{
						result.setTaskStateDescription("Failure: Daily transaction limit of " + DAILY_TRANSACTION_LIMIT + "reached for today"); 
						result.setTaskStatus(false); 
						return result;
					}	
				}
				else
				{
					result.setTaskStateDescription("Failure: Total Withdrawn exceeds daily withdraw limit. Withdrawn Today: " + dailyWithdrawCount);
					result.setTaskStatus(false);
					return result;
				}
			}
			else
			{
				result.setTaskStateDescription("Failure: $" + withdrawAmount + " exceeds daily withdraw limit of " + DAILY_WITHDRAW_LIMIT + "for Basic Plan.");
				result.setTaskStatus(false); 
				return result;
			}
		}
		else
		{
			result.setTaskStateDescription("Faiure: Not enough funds to withdraw $" + withdrawAmount + ", current balance: $" + oldBalance);
			result.setTaskStatus(false);  
			return result;
		}
		
	}

	
	/** This method allows for the account holder to be able to deposit a certain amount of money to a specific account. 
	 * @param depositAmount, the amount of funds that the account holder wishes to deposit.
	 * @param account, account the funds will be deposited to.
	 * @return Tuple, a tuple type holding a string for description and a boolean for success or failure is returned.
	 */
	@Override
	public Tuple deposit(float depositAmount, Account account) {
		
		// handle date checking to reset counters
		Tuple result = new Tuple(); 
		
		if(dailyTransactionCount <= DAILY_TRANSACTION_LIMIT)
		{
			dailyTransactionCount = dailyTransactionCount + 1; 
			account.setBalance(account.getBalance() + depositAmount);
			
			result.setTaskStateDescription("Success: $" + depositAmount + " deposited to " + account.getType() + " account");
			result.setTaskStatus(true);  
			return result; 
		}
		else
		{
			result.setTaskStateDescription("Failure: Daily transaction limit of " + DAILY_TRANSACTION_LIMIT + "reached for today"); 
			result.setTaskStatus(false);  
			return result; 
		}
		
	}

	
	/** This method allows for the account holder to be able to view the total balance for a specific account.
	 * @param account, account that the holder wishes to view the funds of.
	 * @return float, float type is used to represent the monetary value. 
	 */
	@Override
	public float viewBalance(Account account) {
		
		//System.out.println(account.getType() + " Account Balance: $" + account.getBalance());
		return account.getBalance(); 
	}

	
	/** This method allows for the account holder to be able to transfer a certain amount of money from one to another specific account.
	 * @param transferFrom, account the funds will be taken out of.
	 * @param transferTo, account the funds will be put into.
	 * @param amount, the amount of funds that the account holder wishes to transfer.
	 * @return Tuple, a tuple type holding a string for description and a boolean for success or failure is returned.
	 */
	@Override
	public Tuple transferFunds(Account transferFrom, Account transferTo, float amount) {
		
		// handle date checking to reset counters
		Tuple result = new Tuple(); 
		
		if(transferFrom.getBalance() < amount) {
			result.setTaskStateDescription("Failure: Not enough Funds "); 
			result.setTaskStatus(false); 
			return (result);  
		}
		
		else if(dailyTransactionCount <= DAILY_TRANSACTION_LIMIT)
		{
			dailyTransactionCount = dailyTransactionCount + 1; 
			transferFrom.setBalance(transferFrom.getBalance() - amount);
			transferTo.setBalance(transferTo.getBalance() + amount);
			
			result.setTaskStateDescription("Success: $" + amount + " transferred from " + transferFrom.getType() + " account, to " + transferTo.getType() + " account"); 
			result.setTaskStatus(true); 
			return result; 
		}
		else
		{
			result.setTaskStateDescription("Failure: Daily transaction limit of " + DAILY_TRANSACTION_LIMIT + "reached for today"); 
			result.setTaskStatus(false); 
			return result; 
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
	
	@Override
	public Account getSavings() {
		
		return savingsAccount;
	}
	
	@Override
	public Account getChequing() {
		
		return chequingAccount;
	}

}
