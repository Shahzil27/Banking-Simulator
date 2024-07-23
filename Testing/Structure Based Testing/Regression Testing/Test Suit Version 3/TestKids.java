/**
 *  @author Brooklyn Coulson SID 200375222
 *  Course: ENSE 375 Software Testing and Validation
 *  Instructors: Yogesh Sharma and Trevor Douglas
 *  Assignment: Group Course Project
 *  Other group members: Shahzil Siddiqui, Quinn Maloney
 *  Filename: TestKids.java
 * 
 *  Date Created: July 15, 2024
 *  Last Updated: July 20, 2024
 * 
 *  Description: This file performs Code Coverage on the Kids.java file specifically.
 *  As a result, functions from other files may be indirectly covered during the execution of some test cases. 
 */

package BankSim;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


/**
 * Test class for {@link BankSim.Kids}
 */
@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("This is a Test Class intended to test the functionality of the Kids Plan.")
class TestKids {
	AccountHolderInfo parent;
	Kids kidPlan;
	
	Tuple depositTupleResult;
	Tuple withdrawTupleResult;
	
	@BeforeAll
	@DisplayName("Initialize the authorized parent of the kid plan used for the test cases below. "
			+ "These variables will remain constant throughout the test process.")
	void initialize_parent() {
		parent = new AccountHolderInfo("Sally703", "pass123!", "Sally", "Hansen", "92 This Street", "s.hans@email.com", "3061234567");
	}
	
	@BeforeEach
	@DisplayName("Initialize the kidPlan before each new test case is executed.")
	void initialize_kidPlan() {
		kidPlan = new Kids(parent, "Andy", "Hansen");
	}

	/**
	 * Test method for {@link BankSim.Kids#Kids(AccountHolderInfo, String, String)}
	 */
	@Test
	void test_constructor_authorizedParentInfo_true() {	
		assertEquals(parent, kidPlan.getAccountHolderInfo());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#Kids(AccountHolderInfo, String, String)}
	 */
	@Test
	void test_constructor_savingsAccount_getType_true() {
		Account trueValues = new Account("savings", "001", 0.00f);
		
		assertEquals(trueValues.getType(), kidPlan.getSavings().getType());
	}

	/**
	 * Test method for {@link BankSim.Kids#Kids(AccountHolderInfo, String, String)}
	 */
	@Test
	void test_constructor_savingsAccount_getAccountNumber_true() {		
		Account trueValues = new Account("savings", "001", 0.00f);
		
		assertEquals(trueValues.getAccountNumber(), kidPlan.getSavings().getAccountNumber());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#Kids(AccountHolderInfo, String, String)}
	 */
	@Test
	void test_constructor_savingsAccount_getBalance_true() {
		Account trueValues = new Account("savings", "001", 0.00f);
		
		assertEquals(trueValues.getBalance(), kidPlan.viewBalance(kidPlan.getSavings()));
	}
	
	/**
	 * Test method for {@link BankSim.Kids#deposit(float, Account)}
	 */
	@Test
	void test_deposit_true() {		 
		depositTupleResult = kidPlan.deposit(50, kidPlan.getSavings());
		
		assertTrue(depositTupleResult.getTaskStatus());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#deposit(float, Account)}
	 */
	@Test
	void test_deposit_exceedMaxAccountBalance_false() {	
		Account randomAccount = new Account("savings", "002", 1000000);
		depositTupleResult = kidPlan.deposit(5, randomAccount);
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#deposit(float, Account)}
	 */
	@Test
	void test_deposit_exceedDailyDepositLimit_false() {		
		depositTupleResult = kidPlan.deposit(90, kidPlan.getSavings());
		depositTupleResult = kidPlan.deposit(90, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#deposit(float, Account)}
	 */
	@Test
	void test_deposit_exceedDailyTransactionLimit_false() {		
		for (int i = 0; i < 7; i++) {
			depositTupleResult = kidPlan.deposit(5, kidPlan.getSavings());
		}
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#deposit(float, Account)}
	 */
	@Test
	void test_deposit_depositZeroFunds_false() {		
		for (int i = 0; i < 7; i++) {
			depositTupleResult = kidPlan.deposit(0, kidPlan.getSavings());
		}
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#withdraw(float, Account)}
	 */
	@Test
	void test_withdraw_true() {		 
		depositTupleResult = kidPlan.deposit(50, kidPlan.getSavings());
		withdrawTupleResult = kidPlan.withdraw(10, kidPlan.getSavings());
		
		assertTrue(withdrawTupleResult.getTaskStatus());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#withdraw(float, Account)}
	 */
	@Test
	void test_withdraw_insufficientFunds_false() {	
		depositTupleResult = kidPlan.deposit(5, kidPlan.getSavings());
		withdrawTupleResult = kidPlan.withdraw(10, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#withdraw(float, Account)}
	 */
	@Test
	void test_withdraw_exceedDailyWithdrawLimit_false() {
		Account randomAccount = new Account("savings", "002", 1000000);
		withdrawTupleResult = kidPlan.withdraw(110, randomAccount);
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#withdraw(float, Account)}
	 */
	@Test
	void test_withdraw_exceedDailyTransactionLimit_false() {	
		depositTupleResult = kidPlan.deposit(90, kidPlan.getSavings());
		for (int i = 0; i < 7; i++) {
			withdrawTupleResult = kidPlan.withdraw(5, kidPlan.getSavings());
		}
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}

	/**
	 * Test method for {@link BankSim.Kids#resetCounters()}
	 */
	@Test
	void test_resetCounters_withdrawCount_true() {
		Account randomAccount = new Account("savings", "002", 700);
		for (int i = 0; i < 3; i++) {
			withdrawTupleResult = kidPlan.withdraw(50, randomAccount);
		}
		
		kidPlan.resetCounters();
		
		withdrawTupleResult = kidPlan.withdraw(50, randomAccount);
		
		assertTrue(withdrawTupleResult.getTaskStatus());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#resetCounters()}
	 */
	@Test
	void test_resetCounters_depositCount_true() {
		for (int i = 0; i < 3; i++) {
			depositTupleResult = kidPlan.deposit(50, kidPlan.getSavings());
		}
		
		kidPlan.resetCounters();
		
		depositTupleResult = kidPlan.deposit(50, kidPlan.getSavings());
		
		assertTrue(depositTupleResult.getTaskStatus());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#resetCounters()}
	 */
	@Test
	void test_resetCounters_transactionCount_true() {
		depositTupleResult = kidPlan.deposit(90, kidPlan.getSavings());
		for (int i = 0; i < 7; i++) {
			withdrawTupleResult = kidPlan.withdraw(5, kidPlan.getSavings());
		}
		
		kidPlan.resetCounters();
		
		withdrawTupleResult = kidPlan.withdraw(5, kidPlan.getSavings());
		
		assertTrue(withdrawTupleResult.getTaskStatus());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#transferFunds(Account, Account, float)}
	 */
	@Test
	void test_transferFunds_false() {
		Tuple impossibleFundTransfer = new Tuple();
		impossibleFundTransfer = kidPlan.transferFunds(kidPlan.getSavings(), kidPlan.getSavings(), 5);
		assertFalse(impossibleFundTransfer.getTaskStatus());
	}
	
	/**
	 * Test method for {@link BankSim.Kids#transferFunds(Account, Account, float)}
	 */
	@Test
	void test_getChequing_null() {
		assertEquals(null, kidPlan.getChequing());
	}
}
