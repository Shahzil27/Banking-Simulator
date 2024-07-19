package BankSim;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@TestInstance(Lifecycle.PER_CLASS)
class TestBasic_v1 {

	AccountHolderInfo accountHolder;
	Basic basicAcc;
	
	@BeforeAll
	void initialize_parent() {
		accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567");
	}
	
	@BeforeEach
	void initialize_kidPlan() {
		basicAcc = new Basic(accountHolder);
	}
	
	@Test
	void test_Constructor_AccountHolderInfo() {
		assertEquals(accountHolder, basicAcc.getAccountHolderInfo()); 
	}
	
	@Test
	void test_Constructor_Chequing_Balance() {
		Account chequingAcc = new Account ("chequing", "3478 4733 5684 2939", 2500.00f);  
		
		assertEquals(chequingAcc.getBalance(), basicAcc.getChequing().getBalance()); 
	}
	
	@Test
	void test_Constructor_Chequing_AccNum() {
		Account chequingAcc = new Account ("chequing", "3478 4733 5684 2939", 2500.00f);  
		
		assertEquals(chequingAcc.getAccountNumber(), basicAcc.getChequing().getAccountNumber());
	}
	
	@Test
	void test_Constructor_Chequing_Type() {
		Account chequingAcc = new Account ("chequing", "3478 4733 5684 2939", 2500.00f);  
		
		assertEquals(chequingAcc.getType(), basicAcc.getChequing().getType()); 
	}
	
	@Test
	void test_Constructor_publicVars_WithdrawCount() {
		assertEquals(0f, basicAcc.dailyWithdrawCount);
	}
	
	@Test
	void test_Constructor_publicVars_TransActionCount() {
		assertEquals(0, basicAcc.dailyTransactionCount);
	}
	
	@Test
	void test_Withdraw_Success() {
		boolean result = basicAcc.withdraw(100f, basicAcc.getChequing()); 
		
		assertEquals(true, result);
	}
	
	@Test
	void test_Withdraw_Failure_notEnoughBalance() {
		boolean result = basicAcc.withdraw(3000f, basicAcc.getChequing()); 
		
		assertEquals(false, result);
	}
	
	@Test
	void test_Withdraw_Failure_exceedsWithdrawLimit() {
		boolean result = basicAcc.withdraw(201f, basicAcc.getChequing()); 
		
		assertEquals(false, result);
	}
	
	@Test
	void test_Withdraw_Failure_exceedsTotalWithdrawLimit() {
		basicAcc.withdraw(100f, basicAcc.getChequing()); 
		boolean result = basicAcc.withdraw(110f, basicAcc.getChequing());
		
		assertEquals(false, result);
	}
	
	@Test
	void test_WithdrawBoundary_Success_DailyTransactionCount() {
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		boolean result = basicAcc.withdraw(10f, basicAcc.getChequing());
		
		assertEquals(true, result);
	}
	
	@Test
	void test_Withdraw_Failure_ExceedsDailyTransactionCount() {
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		boolean result = basicAcc.withdraw(10f, basicAcc.getChequing());
		
		assertEquals(false, result);
	}
	
	@Test
	void test_Deposit_Success() {
		boolean result = basicAcc.deposit(300f, basicAcc.getSavings()); 
		
		assertEquals(true, result);
	}
	
	@Test
	void test_DepositBoundary_Success_() {
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		boolean result = basicAcc.deposit(300f, basicAcc.getSavings()); 
		
		assertEquals(true, result);
	}
	
	@Test
	void test_Deposit_Failure_ExceedsTransctionLimit() {
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		boolean result = basicAcc.deposit(300f, basicAcc.getSavings()); 
		
		assertEquals(false, result);
	}
	
	@Test
	void test_ViewBalance_Success_Chequing() {
		float result = basicAcc.viewBalance(basicAcc.getChequing()); 
		
		assertEquals(2500.00f, result);
	}
	
	@Test
	void test_ViewBalance_Success_Savings() {
		float result = basicAcc.viewBalance(basicAcc.getSavings()); 
		
		assertEquals(500.00f, result);
	}
	
	@Test
	void test_TransferFunds_Success() {
		boolean result = basicAcc.transferFunds(basicAcc.getChequing(), basicAcc.getSavings(), 50f);  
		
		assertEquals(true, result);
	}
	
	@Test
	void test_TransferFundsBoundary_Success() {
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.deposit(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.deposit(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.deposit(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		boolean result = basicAcc.transferFunds(basicAcc.getChequing(), basicAcc.getSavings(), 50f);  
		
		assertEquals(true, result);
	}
	
	@Test
	void test_TransferFunds_Failure_ExceedsTransactionLimit() {
		
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.deposit(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.deposit(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.deposit(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		
		boolean result = basicAcc.transferFunds(basicAcc.getChequing(), basicAcc.getSavings(), 50f);
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_TransferFunds_Failure_exceedsFunds() {
		boolean result = basicAcc.transferFunds(basicAcc.getChequing(), basicAcc.getSavings(), 5000f);  
		
		assertEquals(false, result);
	}
	
	@Test
	void test_ResetCounter_Success_withdrawCount() {
		basicAcc.resetCounters();
		assertEquals(0f, basicAcc.dailyWithdrawCount);
	}
	
	@Test
	void test_ResetCounter_Success_transactionCount() {
		basicAcc.resetCounters();
		assertEquals(0, basicAcc.dailyTransactionCount);
	}
	
}
