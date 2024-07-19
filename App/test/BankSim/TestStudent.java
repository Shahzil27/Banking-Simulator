package BankSim;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestStudent {

	@Test
	void test_Constructor_AccountHolderInfo() {
		
		AccountHolderInfo accountHolder = new AccountHolderInfo("StudentUser", "Pass123", "Student", "User", "123 Student Street", "student123@gmail.com", "6391234568"); 
		Student studentAcc = new Student(accountHolder, "", "");
		
		assertEquals(accountHolder, studentAcc.getAccountHolderInfo()); 
	}
}
