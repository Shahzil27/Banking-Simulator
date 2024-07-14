/**
 *  @author Shahzil Siddiqui SID 200448986
 *  Course: ENSE 375 Software Testing and Validation
 *  Instructors: Yogesh Sharma and Trevor Douglas
 *  Assignment: Group Course Project
 *  Other group members: Brooklyn Coulson, Quinn Maloney
 *  Filename: Account.java
 * 
 *  Date Created: July 05, 2024
 * 
 *  Description: This file describes the accounts that the account holders can have. It has the ability to creat a custom account 
 *  given an account type, account number, and account balance. In the simulation, this class will be used to create instances of 
 *  checking and/or savings accounts.   
 * 
 */

package BankSim;

public class Account {
	
	private String type; 
	private String accountNumber; 
	private float balance; 
	
	/** This method is a constructor used to initialize an account type for a potential account holder. 
	 * @param type, type is a String that represent the name of the account, in the simulation this would be "checking" or "savings". 
	 * @param AccountNumber, AccountNumber is a String that represents the unique account number.
	 * @param balance, balance is of type float that represent the initial balance the account can be set to have.
	 */
	public Account (String type, String AccountNumber, float balance)
	{
		this.type = type; 
		this.accountNumber = AccountNumber; 
		this.balance = balance; 
	}
	
	/** This is a getter method for the type variable. 
	 * 
	 * @return String, the return type for this method is a string, such as "checking" or "savings". 
	 */
	public String getType()
	{
		return this.type; 
	}
	
	
	/** This is a getter for the AccountNumber private variable. 
	 * 
	 * @return String, the return type for this method is a string. 
	 */
	public String getAccountNumber ()
	{
		return this.accountNumber; 
	}
	
	
	/** This is a getter for the balance private variable. 
	 * 
	 * @return float, the return type for this method is float to represent a monetary value. 
	 */
	public float getBalance()
	{
		return this.balance;
	}
	
	
	/** This is a setter for the balance private variable. 
	 */
	public void setBalance(float newBalance)
	{
		this.balance = newBalance; 
	}
}
