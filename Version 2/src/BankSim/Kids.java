/**
 *  @author Brooklyn Coulson SID 200375222
 *  Course: ENSE 375 Software Testing and Validation
 *  Instructors: Yogesh Sharma and Trevor Douglas
 *  Assignment: Group Course Project
 *  Other group members: Shahzil Siddiqui, Quinn Maloney
 *  Filename: Kids.java
 * 
 *  Date Created: July 01, 2024
 * 
 *  Description: This file describes one of the plans that the user can create within the Bank Simulation Application. With the Kids Plan, there will only be one 
 *  account associated with the plan (Savings Account) and although the Account Holder will be a child, there must be an Authorized Parent in order to 
 *  make any changes regarding the plan. Like all other plans, the Account Holder will be able to simulate basic banking tasks like withdrawing funds, 
 *  depositing funds, and viewing Account Balances. The following restrictions associated with the Kids Plan are as follows:
 *       > Maximum funds that an Account (Savings Account) within this plan can hold: $1,000,000
 *       > Maximum total withdraws the Account Holder can make within one day: $100
 *       > Maximum total deposits the Account Holder can make within one day: $100
 *       > Maximum number of transactions (deposits, withdraws, transfers) an Account Holder can perform within one day: 5
 */

package BankSim;

import java.time.LocalDate; 

public class Kids {	
	private Account savingsAccount;
	private float dailyWithdrawalCount;
	private int dailyTransactionCount;
	private LocalDate dailyTrackingDate;
	private static float DAILY_WITHDRAW_LIMIT = 100;
	private static int DAILY_TRANSACTION_LIMIT = 5;
	private static float DAILY_DEPOSIT_LIMIT = 100;
	private static float MAX_ACCOUNT_BALANCE = 1000000;
	private AccountHolderInfo authorizedParent;
	private String kidFirstName;
	private String kidLastName;

	/**
	 * This is a constructor that will initialize a new Kids Plan. The Kids Plan will create a new instance of a Savings Account, save the parent/guardian
	 * that will have authorization over the account, and initialize all counts associated with daily withdrawal and transaction limits.
	 */
	public Kids(AccountHolderInfo parent, String kidFirstName, String kidLastName) {
		this.savingsAccount = new Account("savings", "001", 0);
		this.dailyWithdrawalCount = 0;
		this.dailyTransactionCount = 0;
		this.dailyTrackingDate = LocalDate.now();
		this.authorizedParent = parent;
		this.kidFirstName = kidFirstName;
		this.kidLastName = kidLastName;
	}
	
	/**
	 * This function will withdraw funds from a specified account the Account Holder has access to.
	 * @param withdrawAmount the amount the kid wishes to withdraw from their account.
	 * @param account the account the funds will be withdrawn from.
	 * @return true or false; this reflects whether the funds were successfully withdrawn.  
	 */
	public Boolean withdraw(float withdrawAmount, Account account) {
		if (this.dailyTransactionCount < DAILY_TRANSACTION_LIMIT) {
			if ((this.dailyWithdrawalCount + withdrawAmount) < DAILY_WITHDRAW_LIMIT) {
				if (withdrawAmount <= account.getBalance()) {
					account.setBalance(account.getBalance() - withdrawAmount);
					this.dailyTransactionCount++;
					this.dailyWithdrawalCount += withdrawAmount;
					System.out.print("Success: You have withdrawn $" + withdrawAmount + " from your account.");
					return true;
				}
				else {
					System.out.print("Error: Insufficient funds. Cannot preform withdrawal request of $" + withdrawAmount + " from your account.");
					return false;
				}
			}
			else {
				System.out.print("Error: You have exceeded your daily withdrawal limit of $" + DAILY_WITHDRAW_LIMIT + ".");
				return false;
			}
		}
		else {
			System.out.print("Error: You have exceeded your daily transaction limit of " + DAILY_TRANSACTION_LIMIT + " transactions.");
			return false;
		}
	}

	/**
	 * This function will deposit funds into a specified account the Account Holder has access to.
	 * @param depositAmount the amount the kid wishes to deposit into their account.
	 * @param account the account the funds will be deposited into.
	 * @return true or false; this reflects whether the funds were successfully deposited.  
	 */
	public Boolean deposit(float depositAmount, Account account) {
		if (this.dailyTransactionCount < DAILY_TRANSACTION_LIMIT) {
			account.setBalance(account.getBalance() + depositAmount);
			this.dailyTransactionCount++;
			System.out.print("Success: You have deposited $" + depositAmount + " into your account.");
			return true;
		}
		else {
			System.out.print("Error: You have exceeded your daily transaction limit of " + DAILY_TRANSACTION_LIMIT + " transactions.");
			return false;
		}
	}

	/**
	 * This function will return the current fund balance of a specified account.
	 * @param account the account the Account Holder wishes to know the balance of. 
	 * @return float; this reflects the total funds within the specified account.  
	 */
	public float viewBalance(Account account) {
		return account.getBalance();
	}	
	
	/**
	 * This function will reset the dailyTransactionCount and dailyWithdrawCount variables once a new day has started.  
	 */
	public void resetCounters() {
		this.dailyTransactionCount = 0;
		this.dailyWithdrawalCount = 0;
	}
	
	/**This method returns the savings account attached to a user's plan
	 * 
	 * @return savings account Account holds the balance, type, and account number.
	 */
	public Account getSavings() {
		return this.savingsAccount;
	}
	
	/**This method returns the Account Holder Info attached to a user's plan
	 * 
	 * @return AccountHolderInfo. The general information of the account holder.
	 */
	public AccountHolderInfo getAccountHolderInfo() {
		return this.authorizedParent;
	}
}