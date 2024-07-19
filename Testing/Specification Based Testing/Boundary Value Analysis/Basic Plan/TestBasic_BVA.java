package BankSim;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
class TestBasic_BVA {


	AccountHolderInfo accountHolder;
	Basic basicAcc;
	
	@BeforeAll
	void initialize_accountHolder() {
		accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567");
	}
	
	@BeforeEach
	void initialize_BasicPlan() {
		basicAcc = new Basic(accountHolder, "", "");
	}
	
	// BVA Test Cases for Withdraw Functionality
	

	@Test
	void test_Withdraw_RB1() {
		basicAcc.dailyWithdrawCount = -1; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB2() {
		basicAcc.dailyWithdrawCount = 0; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB3() {
		basicAcc.dailyWithdrawCount = 1; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB4() {
		basicAcc.dailyWithdrawCount = 199; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB5() {
		basicAcc.dailyWithdrawCount = 200; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB6() {
		basicAcc.dailyWithdrawCount = 201; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB7() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB8() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(-1f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB9() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(0f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB10() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(1f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB11() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(99999f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB12() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(1000000f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB13() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(1000001f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB14() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = -1;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB15() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 0;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB16() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 1;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB17() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 9;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB18() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 10;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB19() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 11;
		basicAcc.getChequing().setBalance(1300f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB20() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(-1f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB21() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(0f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB22() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB23() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(99999f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB24() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1000000f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_RB25() {
		basicAcc.dailyWithdrawCount = 157; 
		
		basicAcc.dailyTransactionCount = 7;
		basicAcc.getChequing().setBalance(1000001f);
		Tuple result = basicAcc.withdraw(30f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	// BVA Test Cases for Deposit Functionality
	
	
	@Test
	void test_Deposit_RB1() {
		
		basicAcc.dailyTransactionCount = 7;
		Tuple result = basicAcc.deposit(-1f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB2() {
		
		basicAcc.dailyTransactionCount = 7;
		Tuple result = basicAcc.deposit(0f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB3() {
		
		basicAcc.dailyTransactionCount = 7;
		Tuple result = basicAcc.deposit(1f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB4() {
		
		basicAcc.dailyTransactionCount = 7;
		Tuple result = basicAcc.deposit(99999f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB5() {
		
		basicAcc.dailyTransactionCount = 7;
		Tuple result = basicAcc.deposit(1000000f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB6() {
		
		basicAcc.dailyTransactionCount = 7;
		Tuple result = basicAcc.deposit(1000001f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB7() {
		
		basicAcc.dailyTransactionCount = 7;
		Tuple result = basicAcc.deposit(570f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	
	@Test
	void test_Deposit_RB8() {
		
		basicAcc.dailyTransactionCount = -1;
		Tuple result = basicAcc.deposit(570f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB9() {
		
		basicAcc.dailyTransactionCount = 0;
		Tuple result = basicAcc.deposit(570f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB10() {
		
		basicAcc.dailyTransactionCount = 1;
		Tuple result = basicAcc.deposit(570f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB11() {
		
		basicAcc.dailyTransactionCount = 9;
		Tuple result = basicAcc.deposit(570f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB12() {
		
		basicAcc.dailyTransactionCount = 10;
		Tuple result = basicAcc.deposit(570f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_RB13() {
		
		basicAcc.dailyTransactionCount = 11;
		Tuple result = basicAcc.deposit(570f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	

}
