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
 *  Description: This file performs Robust Boundary Value Analysis on the Kids.java file specifically.
 *  The parameters for testing are as follows:
 *  	> dailyWithdrawCount:
 *  		> min-1 = -1
 *  		> min = 0
 *  		> min + 1 = 1
 *  		> nom = 57
 *  		> max-1 = 99
 *  		> max = 100
 *  		> max+1 = 101 
 *  	> dailyDepositCount:
 *  		> min-1 = -1
 *  		> min = 0
 *  		> min + 1 = 1
 *  		> nom = 49
 *  		> max-1 = 99
 *  		> max = 100
 *  		> max+1 = 101 
 *  	> dailyTransactionCount:
 *  		> min-1 = -1
 *  		> min = 0
 *  		> min + 1 = 1
 *  		> nom = 3
 *  		> max-1 = 4
 *  		> max = 5
 *  		> max+1 = 6
 *  	> accountBalance:
 *  		> min-1 = -1
 *  		> min = 0
 *  		> min + 1 = 1
 *  		> nom = 532
 *  		> max-1 = 4999
 *  		> max = 5000
 *  		> max+1 = 5001
 *  	> withdrawAmount:
 *  		> min-1 = -1
 *  		> min = 0
 *  		> min + 1 = 1
 *  		> nom = 25
 *  		> max-1 = 4999
 *  		> max = 5000
 *  		> max+1 = 5001   
 *  	> depositAmount:
 *  		> min-1 = -1
 *  		> min = 0
 *  		> min + 1 = 1
 *  		> nom = 33
 *  		> max-1 = 4999
 *  		> max = 5000
 *  		> max+1 = 5001
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
class TestKids_BVA {
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
	
	
	@Test
	void test_withdraw_case1_false() {
		kidPlan.getSavings().setBalance(532);	
		kidPlan.setDailyWithdrawCount(-1);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case2_true() {
		kidPlan.getSavings().setBalance(532);
		kidPlan.setDailyWithdrawCount(0);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertTrue(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case3_true() {
		kidPlan.getSavings().setBalance(532);
		kidPlan.setDailyWithdrawCount(1);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertTrue(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case4_false() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(99);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case5_false() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(100);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case6_false() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(101);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case7_false() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(-1, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case8_false() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(0, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case9_true() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(1, kidPlan.getSavings());
		
		assertTrue(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case10_false() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(4999, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case11_false() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(5000, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case12_false() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(5001, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case13_false() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(-1);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case14_true() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(0);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertTrue(withdrawTupleResult.getTaskStatus());
	}

	@Test
	void test_withdraw_case15_true() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(1);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertTrue(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case16_true() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(4);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertTrue(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case17_false() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(5);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case18_false() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(6);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case19_false() {
		kidPlan.getSavings().setBalance(-1);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case20_false() {
		kidPlan.getSavings().setBalance(0);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case21_false() {
		kidPlan.getSavings().setBalance(1);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case22_true() {
		kidPlan.getSavings().setBalance(4999);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertTrue(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case23_true() {
		kidPlan.getSavings().setBalance(5000);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertTrue(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case24_false() {
		kidPlan.getSavings().setBalance(5001);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertFalse(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_withdraw_case25_true() {
		kidPlan.getSavings().setBalance(532);		
		kidPlan.setDailyWithdrawCount(57);
		kidPlan.setDailyTransactionCount(3);
		
		withdrawTupleResult = kidPlan.withdraw(25, kidPlan.getSavings());
		
		assertTrue(withdrawTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case1_false() {
		kidPlan.setDailyDepositCount(-1);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case2_true() {
		kidPlan.setDailyDepositCount(0);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertTrue(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case3_true() {
		kidPlan.setDailyDepositCount(1);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertTrue(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case4_false() {
		kidPlan.setDailyDepositCount(99);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case5_false() {
		kidPlan.setDailyDepositCount(100);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case6_false() {
		kidPlan.setDailyDepositCount(101);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case7_false() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(-1, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case8_false() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(0, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case9_true() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(1, kidPlan.getSavings());
		
		assertTrue(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case10_false() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(4999, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case11_false() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(5000, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case12_false() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(5001, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case13_false() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(-1);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case14_true() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(0);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertTrue(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case15_true() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(1);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertTrue(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case16_true() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(4);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertTrue(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case17_false() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(5);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case18_false() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(6);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case19_false() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(-1);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case20_true() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(0);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertTrue(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case21_true() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(1);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertTrue(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case22_false() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(4999);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case23_false() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(5000);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case24_false() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(5001);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertFalse(depositTupleResult.getTaskStatus());
	}
	
	@Test
	void test_deposit_case25_true() {
		kidPlan.setDailyDepositCount(49);
		kidPlan.setDailyTransactionCount(2);
		kidPlan.getSavings().setBalance(237);	
		
		depositTupleResult = kidPlan.deposit(33, kidPlan.getSavings());
		
		assertTrue(depositTupleResult.getTaskStatus());
	}
}
