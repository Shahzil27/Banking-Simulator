package BankSim;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class TestBasic {

	@Test
	void test_Constructor_AccountHolderInfo() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		
		assertEquals(accountHolder, basicAcc.getAccountHolderInfo()); 
	}
	
	@Test
	void test_Constructor_Chequing() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		Account chequingAcc = new Account ("chequing", "3478 4733 5684 2939", 2500.00f);  
		
		assertEquals(chequingAcc.getBalance(), basicAcc.getChequing().getBalance()); 
		assertEquals(chequingAcc.getAccountNumber(), basicAcc.getChequing().getAccountNumber());
		assertEquals(chequingAcc.getType(), basicAcc.getChequing().getType()); 
	}
	
	@Test
	void test_Constructor_publicVars() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		LocalDate dateNow = LocalDate.now();   
		
		assertEquals(0f, basicAcc.dailyWithdrawCount);
		assertEquals(0, basicAcc.dailyTransactionCount);
		assertEquals(dateNow, basicAcc.dailyTrackingDate); 
	}
	
	@Test
	void test_Withdraw_Success() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		Tuple result = basicAcc.withdraw(100f, basicAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_Failure_notEnoughBalance() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		Tuple result = basicAcc.withdraw(3000f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_Failure_exceedsWithdrawLimit() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		Tuple result = basicAcc.withdraw(201f, basicAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_Failure_exceedsTotalWithdrawLimit() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		
		basicAcc.withdraw(100f, basicAcc.getChequing()); 
		Tuple result = basicAcc.withdraw(110f, basicAcc.getChequing());
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_WithdrawBoundary_Success_DailyTransactionCount() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		Tuple result = basicAcc.withdraw(10f, basicAcc.getChequing());
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_Failure_ExceedsDailyTransactionCount() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		
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
		Tuple result = basicAcc.withdraw(10f, basicAcc.getChequing());
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_Success() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		Tuple result = basicAcc.deposit(300f, basicAcc.getSavings()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_DepositBoundary_Success_() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		basicAcc.deposit(300f, basicAcc.getSavings());
		Tuple result = basicAcc.deposit(300f, basicAcc.getSavings()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Deposit_Failure_ExceedsTransctionLimit() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		
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
		Tuple result = basicAcc.deposit(300f, basicAcc.getSavings()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_ViewBalance_Success_Chequing() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		float result = basicAcc.viewBalance(basicAcc.getChequing()); 
		
		assertEquals(2500.00f, result);
	}
	
	@Test
	void test_ViewBalance_Success_Savings() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		float result = basicAcc.viewBalance(basicAcc.getSavings()); 
		
		assertEquals(500.00f, result);
	}
	
	@Test
	void test_ResetCounters_Success() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		basicAcc.withdraw(20f, basicAcc.getChequing());
		basicAcc.deposit(10, basicAcc.getChequing());
		basicAcc.withdraw(30f, basicAcc.getChequing());
		
		basicAcc.resetCounters();
		
		assertEquals(0f, basicAcc.dailyWithdrawCount);
		assertEquals(0, basicAcc.dailyTransactionCount);
	}
	
	@Test
	void test_TransferFunds_Success() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		Tuple result = basicAcc.transferFunds(basicAcc.getChequing(), basicAcc.getSavings(), 50f);  
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_TransferFundsBoundary_Success() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.deposit(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.deposit(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		basicAcc.deposit(10f, basicAcc.getChequing());
		basicAcc.withdraw(10f, basicAcc.getChequing());
		Tuple result = basicAcc.transferFunds(basicAcc.getChequing(), basicAcc.getSavings(), 50f);  
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_TransferFunds_Failure_ExceedsTransactionLimit() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		System.out.println(basicAcc.getChequing().getBalance()); 
		
		basicAcc.withdraw(10f, basicAcc.getChequing());
		System.out.println(basicAcc.getChequing().getBalance());
		System.out.println(basicAcc.dailyTransactionCount); 
		
		basicAcc.deposit(10f, basicAcc.getChequing());
		System.out.println(basicAcc.getChequing().getBalance());
		System.out.println(basicAcc.dailyTransactionCount); 
		
		basicAcc.withdraw(10f, basicAcc.getChequing());
		System.out.println(basicAcc.getChequing().getBalance());
		System.out.println(basicAcc.dailyTransactionCount); 
		
		Tuple x = basicAcc.withdraw(10f, basicAcc.getChequing());
		System.out.println(x.getResultsDescription()); 
		System.out.println(basicAcc.dailyTransactionCount); 
		
		basicAcc.deposit(10f, basicAcc.getChequing());
		System.out.println(basicAcc.dailyTransactionCount); 
		
		basicAcc.withdraw(10f, basicAcc.getChequing());
		System.out.println(basicAcc.dailyTransactionCount); 
		
		basicAcc.withdraw(10f, basicAcc.getChequing());
		System.out.println(basicAcc.dailyTransactionCount); 
		
		basicAcc.deposit(10f, basicAcc.getChequing());
		System.out.println(basicAcc.dailyTransactionCount); 
		
		basicAcc.withdraw(10f, basicAcc.getChequing());
		System.out.println(basicAcc.dailyTransactionCount); 
		
		basicAcc.withdraw(10f, basicAcc.getChequing());
		System.out.println(basicAcc.dailyTransactionCount); 
		
		Tuple result = basicAcc.transferFunds(basicAcc.getChequing(), basicAcc.getSavings(), 50f);
		System.out.println(basicAcc.dailyTransactionCount); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_TransferFunds_Failure_exceedsFunds() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("BasicUser", "Pass123", "Basic", "User", "123 Basic Street", "basic123@gmail.com", "6391234567"); 
		Basic basicAcc = new Basic(accountHolder);
		Tuple result = basicAcc.transferFunds(basicAcc.getChequing(), basicAcc.getSavings(), 5000f);  
		
		assertEquals(false, result.getTaskStatus());
	}
}
