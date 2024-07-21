package BankSim;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

@TestInstance(Lifecycle.PER_CLASS)
class TestGUI {
	
	SimulatorGUI test;
	Robot bot;
	
	public void delay() {
		try{Thread.sleep(250);}catch(InterruptedException e){}
	}
	
	@BeforeEach
	void initializeGUI() throws AWTException {
		test = new SimulatorGUI();
		bot = new Robot();
	}

	@Test
	void Failed_Creation_False() throws AWTException {
		test.createLoginPage();
		test.displayPage();
		
		Point coordinate = test.getSubmitLogin().getLocationOnScreen();
		bot.mouseMove(coordinate.x, coordinate.y);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		assertTrue(test.getCreationError());
	}
	
	@Test
	void Successful_Creation_and_Login_False() throws AWTException {
		test.createLoginPage();
		test.displayPage();
		
		Point coordinate = test.getUsernameInput().getLocationOnScreen();
		bot.mouseMove(coordinate.x, coordinate.y);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_A);
		delay();
		bot.keyRelease(KeyEvent.VK_A);
		
		coordinate = test.getPasswordInput().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 5, coordinate.y + 5);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_SHIFT);
		bot.keyPress(KeyEvent.VK_8);
		delay();
		bot.keyRelease(KeyEvent.VK_8);
		delay();
		bot.keyPress(KeyEvent.VK_A);
		delay();
		bot.keyRelease(KeyEvent.VK_A);
		bot.keyRelease(KeyEvent.VK_SHIFT);
		bot.keyPress(KeyEvent.VK_0);
		delay();
		bot.keyRelease(KeyEvent.VK_0);
		
		coordinate = test.getSubmitLogin().getLocationOnScreen();
		bot.mouseMove(coordinate.x, coordinate.y);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		coordinate = test.getUsernameInput().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_A);
		delay();
		bot.keyRelease(KeyEvent.VK_A);
		
		coordinate = test.getPasswordInput().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 5, coordinate.y + 5);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_SHIFT);
		bot.keyPress(KeyEvent.VK_8);
		delay();
		bot.keyRelease(KeyEvent.VK_8);
		delay();
		bot.keyPress(KeyEvent.VK_A);
		delay();
		bot.keyRelease(KeyEvent.VK_A);
		bot.keyRelease(KeyEvent.VK_SHIFT);
		bot.keyPress(KeyEvent.VK_0);
		delay();
		bot.keyRelease(KeyEvent.VK_0);
		
		coordinate = test.getSubmitLogin().getLocationOnScreen();
		bot.mouseMove(coordinate.x, coordinate.y);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		assertFalse(test.getLoggedOut());
	}
	
	@Test
	void Failed_Creation_and_Login_True() throws AWTException {		
		test.createLoginPage();
		test.displayPage();
		
		Point coordinate = test.getUsernameInput().getLocationOnScreen();
		bot.mouseMove(coordinate.x, coordinate.y);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_A);
		delay();
		bot.keyRelease(KeyEvent.VK_A);
		
		coordinate = test.getPasswordInput().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 5, coordinate.y + 5);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_SHIFT);
		bot.keyPress(KeyEvent.VK_8);
		delay();
		bot.keyRelease(KeyEvent.VK_8);
		delay();
		bot.keyPress(KeyEvent.VK_A);
		delay();
		bot.keyRelease(KeyEvent.VK_A);
		bot.keyRelease(KeyEvent.VK_SHIFT);
		bot.keyPress(KeyEvent.VK_0);
		delay();
		bot.keyRelease(KeyEvent.VK_0);
		
		coordinate = test.getSubmitLogin().getLocationOnScreen();
		bot.mouseMove(coordinate.x, coordinate.y);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		coordinate = test.getUsernameInput().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_A);
		delay();
		bot.keyRelease(KeyEvent.VK_A);
		
		coordinate = test.getPasswordInput().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 5, coordinate.y + 5);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_SHIFT);
		bot.keyPress(KeyEvent.VK_8);
		delay();
		bot.keyRelease(KeyEvent.VK_8);
		delay();
		bot.keyPress(KeyEvent.VK_A);
		delay();
		bot.keyRelease(KeyEvent.VK_A);
		bot.keyRelease(KeyEvent.VK_SHIFT);
		bot.keyPress(KeyEvent.VK_1);
		delay();
		bot.keyRelease(KeyEvent.VK_1);
		
		coordinate = test.getSubmitLogin().getLocationOnScreen();
		bot.mouseMove(coordinate.x, coordinate.y);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		assertTrue(test.getLoginError());
	}
	
	@Test
	void Sucessfull_Withdraw_Student_True() throws AWTException {		
		test.setAccountHolderInfo("QKM", "ENSE375$", "Quinn", "Maloney", "Address", "Quinn@fake.com", "1233456789");
		test.setPlans(test.getPlanFactory().getPlan("Student", test.getAccountHolderInfo(), "", ""));
		test.homePage();
		test.displayPage();
		float originalBalance = test.getPlans().viewBalance(test.getPlans().getChequing());	
		
		Point coordinate = test.getSelectWithdraw().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		coordinate = test.getWithdrawAmountChequing().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_1);
		delay();
		bot.keyRelease(KeyEvent.VK_1);
		
		coordinate = test.getConfirmWithdrawChequing().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		assertEquals(originalBalance, (test.getPlans().viewBalance(test.getPlans().getChequing()) + 1));
		
	}
	
	@Test
	void Sucessfull_Withdraw_Basic_True() throws AWTException {
		
		test.setAccountHolderInfo("QKM", "ENSE375$", "Quinn", "Maloney", "Address", "Quinn@fake.com", "1233456789");
		test.setPlans(test.getPlanFactory().getPlan("Basic", test.getAccountHolderInfo(), "", ""));
		test.homePage();
		test.displayPage();
		float originalBalance = test.getPlans().viewBalance(test.getPlans().getChequing());
		
		
		Point coordinate = test.getSelectWithdraw().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		coordinate = test.getWithdrawAmountChequing().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_1);
		delay();
		bot.keyRelease(KeyEvent.VK_1);
		
		coordinate = test.getConfirmWithdrawChequing().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		assertEquals(originalBalance, (test.getPlans().viewBalance(test.getPlans().getChequing()) + 1));
		
	}
	
	@Test
	void Sucessfull_Withdraw_Kids_True() throws AWTException {
		test.setAccountHolderInfo("QKM", "ENSE375$", "Quinn", "Maloney", "Address", "Quinn@fake.com", "1233456789");
		test.setPlans(test.getPlanFactory().getPlan("Kids", test.getAccountHolderInfo(), "", ""));
		test.homePage();
		test.displayPage();
		test.setIsKids(true);
		float originalBalance = test.getPlans().viewBalance(test.getPlans().getSavings());	
		
		Point coordinate = test.getSelectWithdraw().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		coordinate = test.getWithdrawAmountSavings().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_1);
		delay();
		bot.keyRelease(KeyEvent.VK_1);
		
		coordinate = test.getConfirmWithdrawSavings().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		assertEquals(originalBalance, (test.getPlans().viewBalance(test.getPlans().getSavings())));
		
	}
	
	@Test
	void Sucessful_Deposit_Student_True() throws AWTException {		
		test.setAccountHolderInfo("QKM", "ENSE375$", "Quinn", "Maloney", "Address", "Quinn@fake.com", "1233456789");
		test.setPlans(test.getPlanFactory().getPlan("Student", test.getAccountHolderInfo(), "", ""));
		test.homePage();
		test.displayPage();
		float originalBalance = test.getPlans().viewBalance(test.getPlans().getSavings());	
		
		Point coordinate = test.getSelectDeposit().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		coordinate = test.getDepositAmountSavings().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_1);
		delay();
		bot.keyRelease(KeyEvent.VK_1);
		delay();
		bot.keyPress(KeyEvent.VK_0);
		delay();
		bot.keyRelease(KeyEvent.VK_0);
		delay();
		
		coordinate = test.getConfirmDepositSavings().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		assertEquals(originalBalance, (test.getPlans().viewBalance(test.getPlans().getSavings())) - 10);
		
	}
	
	@Test
	void Sucessful_Deposit_Basic_True() throws AWTException {
		test.setAccountHolderInfo("QKM", "ENSE375$", "Quinn", "Maloney", "Address", "Quinn@fake.com", "1233456789");
		test.setPlans(test.getPlanFactory().getPlan("Basic", test.getAccountHolderInfo(), "", ""));
		test.homePage();
		test.displayPage();
		float originalBalance = test.getPlans().viewBalance(test.getPlans().getSavings());		
		
		Point coordinate = test.getSelectDeposit().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		coordinate = test.getDepositAmountSavings().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_1);
		delay();
		bot.keyRelease(KeyEvent.VK_1);
		delay();
		bot.keyPress(KeyEvent.VK_0);
		delay();
		bot.keyRelease(KeyEvent.VK_0);
		delay();
		
		coordinate = test.getConfirmDepositSavings().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		assertEquals(originalBalance, (test.getPlans().viewBalance(test.getPlans().getSavings())) - 10);
		
	}
	
	@Test
	void Sucessful_Deposit_Kids_True() throws AWTException {		
		test.setAccountHolderInfo("QKM", "ENSE375$", "Quinn", "Maloney", "Address", "Quinn@fake.com", "1233456789");
		test.setPlans(test.getPlanFactory().getPlan("Kids", test.getAccountHolderInfo(), "", ""));
		test.homePage();
		test.displayPage();
		float originalBalance = test.getPlans().viewBalance(test.getPlans().getSavings());
		test.setIsKids(true);		
		
		Point coordinate = test.getSelectDeposit().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		coordinate = test.getDepositAmountSavings().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_1);
		delay();
		bot.keyRelease(KeyEvent.VK_1);
		delay();
		bot.keyPress(KeyEvent.VK_0);
		delay();
		bot.keyRelease(KeyEvent.VK_0);
		delay();
		
		coordinate = test.getConfirmDepositSavings().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		assertEquals(originalBalance, (test.getPlans().viewBalance(test.getPlans().getSavings())) - 10);
		
	}
	
	@Test
	void Sucessful_Navigation_And_Logout_True() throws AWTException {		
		test.setAccountHolderInfo("QKM", "ENSE375$", "Quinn", "Maloney", "Address", "Quinn@fake.com", "1233456789");
		test.setPlans(test.getPlanFactory().getPlan("Student", test.getAccountHolderInfo(), "", ""));
		test.homePage();
		test.displayPage();		
		
		Point coordinate = test.getSelectBalance().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		coordinate = test.getSelectBack().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		coordinate = test.getSelectAccountDetails().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		coordinate = test.getSelectBack().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();

		assertTrue(test.getLoggedOut());
		
	}
	
	@Test
	void Sucessful_Transfer_Student_True() throws AWTException {		
		test.setAccountHolderInfo("QKM", "ENSE375$", "Quinn", "Maloney", "Address", "Quinn@fake.com", "1233456789");
		test.setPlans(test.getPlanFactory().getPlan("Student", test.getAccountHolderInfo(), "", ""));
		test.homePage();
		test.displayPage();
		float originalBalance = test.getPlans().viewBalance(test.getPlans().getSavings());
				
		Point coordinate = test.getSelectTransfer().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		coordinate = test.getTransferAmount().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_4);
		delay();
		bot.keyRelease(KeyEvent.VK_4);
		delay();
		bot.keyPress(KeyEvent.VK_5);
		delay();
		bot.keyRelease(KeyEvent.VK_5);
		delay();	
		
		coordinate = test.getConfirmTransfer().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();

		assertEquals(originalBalance, (test.getPlans().viewBalance(test.getPlans().getSavings())) + 45);
		
	}
	
	@Test
	void Sucessful_Transfer_Basic_True() throws AWTException {		
		test.setAccountHolderInfo("QKM", "ENSE375$", "Quinn", "Maloney", "Address", "Quinn@fake.com", "1233456789");
		test.setPlans(test.getPlanFactory().getPlan("Basic", test.getAccountHolderInfo(), "", ""));
		test.homePage();
		test.displayPage();
		float originalBalance = test.getPlans().viewBalance(test.getPlans().getSavings());		
		
		Point coordinate = test.getSelectTransfer().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		
		coordinate = test.getTransferAmount().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.keyPress(KeyEvent.VK_4);
		delay();
		bot.keyRelease(KeyEvent.VK_4);
		delay();
		bot.keyPress(KeyEvent.VK_5);
		delay();
		bot.keyRelease(KeyEvent.VK_5);
		delay();	
		
		coordinate = test.getConfirmTransfer().getLocationOnScreen();
		bot.mouseMove(coordinate.x + 2, coordinate.y + 2);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay();
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		delay();

		assertEquals(originalBalance, (test.getPlans().viewBalance(test.getPlans().getSavings())) + 45);
		
	}

}
