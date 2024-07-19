package BankSim;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
class TestStudent_BVA {


	AccountHolderInfo accountHolder;
	Student studentAcc;
	
	@BeforeAll
	void initialize_accountHolder() {
		accountHolder = new AccountHolderInfo("StudentUser", "Password2$", "Student", "Quinn", "105 Fake Street", "user@gmail.com", "23190574");
	}
	
	@BeforeEach
	void initialize_StudentPlan() {
		studentAcc = new Student(accountHolder, "", "");
	}
	
	// BVA Test Cases for Withdraw Functionality
	
	@Test
	void test_Withdraw_RB1() {
		studentAcc.dailyWithdrawCount = -1; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB2() {
		studentAcc.dailyWithdrawCount = 0; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB3() {
		studentAcc.dailyWithdrawCount = 1; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB4() {
		studentAcc.dailyWithdrawCount = 2999; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB5() {
		studentAcc.dailyWithdrawCount = 3000; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB6() {
		studentAcc.dailyWithdrawCount = 3001; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB7() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB8() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(-1f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB9() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(0f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB10() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(1f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB11() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(99999f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB12() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(1000000f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB13() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(1000001f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB14() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = -1;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB15() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 0;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB16() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 1;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB17() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 99;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB18() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 100;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB19() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 101;
		studentAcc.getChequing().setBalance(4000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB20() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(-1f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB21() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(0f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB22() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(1f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB23() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(99999f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB24() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(1000000f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB25() {
		studentAcc.dailyWithdrawCount = 1450; 
		
		studentAcc.dailyTransactionCount = 70;
		studentAcc.getChequing().setBalance(1000001f);
		Tuple result = studentAcc.withdraw(50f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	// BVA Test Cases for Deposit Functionality
	
	@Test
	void test_Deposit_RB1() {
		
		studentAcc.dailyTransactionCount = 70;
		Tuple result = studentAcc.deposit(-1f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB2() {
		
		studentAcc.dailyTransactionCount = 70;
		Tuple result = studentAcc.deposit(0f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB3() {
		
		studentAcc.dailyTransactionCount = 70;
		Tuple result = studentAcc.deposit(1f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB4() {
		
		studentAcc.dailyTransactionCount = 70;
		Tuple result = studentAcc.deposit(99999f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB5() {
		
		studentAcc.dailyTransactionCount = 70;
		Tuple result = studentAcc.deposit(1000000f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB6() {
		
		studentAcc.dailyTransactionCount = 70;
		Tuple result = studentAcc.deposit(1000001f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB7() {
		
		studentAcc.dailyTransactionCount = 70;
		Tuple result = studentAcc.deposit(570f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	
	@Test
	void test_Deposit_RB8() {
		
		studentAcc.dailyTransactionCount = -1;
		Tuple result = studentAcc.deposit(570f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB9() {
		
		studentAcc.dailyTransactionCount = 0;
		Tuple result = studentAcc.deposit(570f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB10() {
		
		studentAcc.dailyTransactionCount = 1;
		Tuple result = studentAcc.deposit(570f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB11() {
		
		studentAcc.dailyTransactionCount = 99;
		Tuple result = studentAcc.deposit(570f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB12() {
		
		studentAcc.dailyTransactionCount = 100;
		Tuple result = studentAcc.deposit(570f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB13() {
		
		studentAcc.dailyTransactionCount = 101;
		Tuple result = studentAcc.deposit(570f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	

}
