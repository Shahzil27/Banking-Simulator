/**
 *  @author Shahzil Siddiqui SID 200448986
 *  Course: ENSE 375 Software Testing and Validation
 *  Instructors: Yogesh Sharma and Trevor Douglas
 *  Assignment: Group Course Project
 *  Other group members: Brooklyn Coulson, Quinn Maloney
 *  Filename: Plans.java
 * 
 *  Date Created: July 05, 2024
 * 
 *  Description: This file describes the the interface used by the all different types of Plans (Kids, Basic, Student). 
 *  			 It is composed of the following method signatures: 
 *  				Tuple withdraw(float withdrawAmount, Account account);
 *					Tuple deposit(float depositAmount, Account account); 
 *					float viewBalance(Account account);
 *					Tuple transferFunds(Account transferFrom, Account transferTo, float amount);
 *					void resetCounters(); 
 *  
 */

package BankSim;

public interface Plans {
	
	/** This method allows for the account holder to be able to withdraw a certain amount of money from a specific account. 
	 * @param withdrawAmount, the amount of funds that the account holder wishes to withdraw.
	 * @param account, account the funds will be withdrawn from.
	 * @return Tuple, a tuple type holding a string for description and a boolean for success or failure is returned.
	 */
	Tuple withdraw(float withdrawAmount, Account account);
	
	
	/** This method allows for the account holder to be able to deposit a certain amount of money to a specific account. 
	 * @param depositAmount, the amount of funds that the account holder wishes to deposit.
	 * @param account, account the funds will be deposited to.
	 * @return Tuple, a tuple type holding a string for description and a boolean for success or failure is returned.
	 */
	Tuple deposit(float depositAmount, Account account); 
	
	
	/** This method allows for the account holder to be able to view the total balance for a specific account.
	 * @param account, account that the holder wishes to view the funds of.
	 * @return float, float type is used to represent the monetary value. 
	 */
	float viewBalance(Account account);
	
	
	/** This method allows for the account holder to be able to transfer a certain amount of money from one to another specific account.
	 * @param transferFrom, account the funds will be taken out of.
	 * @param transferTo, account the funds will be put into.
	 * @param amount, the amount of funds that the account holder wishes to transfer.
	 * @return Tuple, a tuple type holding a string for description and a boolean for success or failure is returned.
	 */
	Tuple transferFunds(Account transferFrom, Account transferTo, float amount);
	
	
	/** This method reset the counters present in the classes that will use the interface. It will reset the following counters:
	 * 		dailyWithdrawCount 
	 *		dailyTransactionCount 
	 */
	void resetCounters(); 
}
