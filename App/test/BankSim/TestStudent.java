package BankSim;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
class TestStudent {
	
	AccountHolderInfo accountHolder;
	Student studentAcc;
	
	@BeforeAll
	void initialize_accountHolder() {
		accountHolder = new AccountHolderInfo("StudentUser", "Pass123", "Student", "User", "123 Student Street", "student123@gmail.com", "6391234568");
	}
	
	@BeforeEach
	void initialize_StudentPlan() {
		studentAcc = new Student(accountHolder, "", "");
	}
	
	@Test
	void test_Constructor_AccountHolderInfo() {
		assertEquals(accountHolder, studentAcc.getAccountHolderInfo()); 
	}
	
	@Test
	void test_Constructor_Chequing_Balance() {
		Account chequingAcc = new Account ("chequing", "002", 4000.00f);  
		
		assertEquals(chequingAcc.getBalance(), studentAcc.getChequing().getBalance()); 
	}
	
	@Test
	void test_Constructor_Chequing_AccNum() {
		Account chequingAcc = new Account ("chequing", "002", 4000.00f);  
		
		assertEquals(chequingAcc.getAccountNumber(), studentAcc.getChequing().getAccountNumber());
	}
	
	@Test
	void test_Constructor_Chequing_AccType() {
		Account chequingAcc = new Account ("chequing", "002", 4000.00f);  
		
		assertEquals(chequingAcc.getType(), studentAcc.getChequing().getType()); 
	}
	
	@Test
	void test_Constructor_publicVars_WithdrawCount() {
		assertEquals(0f, studentAcc.dailyWithdrawCount);
	}
	
	@Test
	void test_Constructor_publicVars_TransActionCount() {
		assertEquals(0, studentAcc.dailyTransactionCount);
	}
	  ////
	@Test
	void test_Withdraw_Success() {
		Tuple result = studentAcc.withdraw(10f, studentAcc.getChequing()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_Failure_notEnoughBalance() {
		Tuple result = studentAcc.withdraw(3500f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_Failure_exceedsWithdrawLimit() {
		Tuple result = studentAcc.withdraw(3001f, studentAcc.getChequing()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_Withdraw_Failure_exceedsTotalWithdrawLimit() {
		studentAcc.withdraw(2700f, studentAcc.getChequing());
		Tuple result = studentAcc.withdraw(400f, studentAcc.getChequing());
		System.out.println(studentAcc.dailyWithdrawCount); 
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_WithdrawBoundary_Success_DailyTransactionCount() {
		
		for(int i = 0; i < 99; i++) {
			studentAcc.withdraw(10f, studentAcc.getChequing());
		}
		Tuple result = studentAcc.withdraw(10f, studentAcc.getChequing());
		
		assertEquals(true, result.getTaskStatus());
	}
	
	
	@Test
	void test_Withdraw_Failure_ExceedsDailyTransactionCount() {
		for(int i = 0; i < 100; i++) {
			studentAcc.withdraw(10f, studentAcc.getChequing());
		}
		Tuple result = studentAcc.withdraw(10f, studentAcc.getChequing());
		
		assertEquals(false, result.getTaskStatus());
	}
	

	@Test
	void test_Deposit_Success() {
		Tuple result = studentAcc.deposit(300f, studentAcc.getSavings()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	
	@Test
	void test_DepositBoundary_Success_() {
		for(int i = 0; i < 99; i++) {
			studentAcc.deposit(10f, studentAcc.getChequing());
		}
		Tuple result = studentAcc.deposit(300f, studentAcc.getSavings()); 
		
		assertEquals(true, result.getTaskStatus());
	}
	
	
	@Test
	void test_Deposit_Failure_ExceedsTransctionLimit() {
		for(int i = 0; i < 100; i++) {
			studentAcc.deposit(10f, studentAcc.getChequing());
		}
		Tuple result = studentAcc.deposit(300f, studentAcc.getSavings()); 
		
		assertEquals(false, result.getTaskStatus());
	}
	
	
	@Test
	void test_ViewBalance_Success_Chequing() {
		float result = studentAcc.viewBalance(studentAcc.getChequing()); 
		
		assertEquals(4000.00f, result);
	}
	
	
	@Test
	void test_ViewBalance_Success_Savings() {
		float result = studentAcc.viewBalance(studentAcc.getSavings()); 
		
		assertEquals(100.00f, result);
	}
	
	
	@Test
	void test_TransferFunds_Success() {
		Tuple result = studentAcc.transferFunds(studentAcc.getChequing(), studentAcc.getSavings(), 50f);  
		assertEquals(true, result.getTaskStatus());
	}
	
	
	@Test
	void test_TransferFundsBoundary_Success() {
		for(int i = 0; i < 99; i++) {
			studentAcc.transferFunds(studentAcc.getChequing(), studentAcc.getSavings(), 1f);  
		}
		Tuple result = studentAcc.transferFunds(studentAcc.getChequing(), studentAcc.getSavings(), 50f);  
		
		assertEquals(true, result.getTaskStatus());
	}
	
	
	@Test
	void test_TransferFunds_Failure_ExceedsTransactionLimit() {
		
		for(int i = 0; i < 100; i++) {
			studentAcc.transferFunds(studentAcc.getChequing(), studentAcc.getSavings(), 1f);  
		}
		
		Tuple result = studentAcc.transferFunds(studentAcc.getChequing(), studentAcc.getSavings(), 50f);
		
		assertEquals(false, result.getTaskStatus());
	}
	
	@Test
	void test_TransferFunds_Failure_exceedsFunds() {
		Tuple result = studentAcc.transferFunds(studentAcc.getChequing(), studentAcc.getSavings(), 5000f);  
		
		assertEquals(false, result.getTaskStatus());
	}
	
}
