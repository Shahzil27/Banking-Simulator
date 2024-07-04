package BankSim;

import java.time.LocalDate;

public class Basic implements Plans {
	
	public Account savingsAccount;
	public Account checkingAccount;
	float dailyWithdrawCount;
	int dailyTransactionCount;
	LocalDate dailyTrackingDate;  
	
	float DAILY_WITHDRAW_LIMIT = 200f; 
	int DAILY_TRANSACTION_LIMIT = 10; 
	
	public Basic(AccountHolderInfo accountHolderInfo)
	{
		accountHolderInfo.setFirstName("Basic");
		accountHolderInfo.setLastName("Billy");
		accountHolderInfo.setPassword("Basic123"); 
		accountHolderInfo.setAddress("1234 Basic Street East");
		accountHolderInfo.setEmail("basicbilly123@gmail.com");
		accountHolderInfo.setPhone("6391234326");
		
		savingsAccount = new Account("savings", "3478 4733 5684 2938", 500.00f); 
		checkingAccount = new Account("Checking", "3478 4733 5684 2939", 2500.00f);
		dailyWithdrawCount = 0f;
		dailyTransactionCount = 0;
		dailyTrackingDate = LocalDate.now(); 
		
	}
	
	
	@Override
	public boolean withdraw(float withdrawAmount, Account account) {
		// TODO Auto-generated method stub
		
		float oldBalance = account.getBalance(); 
		
		// handle date checking to reset counters
		
		if (account.getBalance() >= withdrawAmount)
		{
			if (withdrawAmount <= DAILY_WITHDRAW_LIMIT)
			{
				if(dailyWithdrawCount <= DAILY_WITHDRAW_LIMIT)
				{
					if (dailyTransactionCount <= DAILY_TRANSACTION_LIMIT)	
					{
						account.setBalance(account.getBalance() - withdrawAmount);
						dailyWithdrawCount = dailyWithdrawCount + withdrawAmount; 
						dailyTransactionCount = dailyTransactionCount + 1; 
						
						System.out.println("Success: $" + withdrawAmount + "withdrawn from " + oldBalance);
						return true;
					}
					else
					{
						System.out.println("Failure: Daily transaction limit of " + DAILY_TRANSACTION_LIMIT + "reached for today"); 
						return false; 
					}	
				}
				else
				{
					System.out.println("Failure: Total Withdrawn exceeds daily withdraw limit. Withdrawn Today: " + dailyWithdrawCount); 
					return false; 
				}
			}
			else
			{
				System.out.println("Failure: $" + withdrawAmount + " exceeds daily withdraw limit of " + DAILY_WITHDRAW_LIMIT + "for Basic Plan." );
				return false; 
			}
		}
		else
		{
			System.out.println("Faiure: Not enough funds to withdraw $" + withdrawAmount + ", current balance: $" + oldBalance); 
			return false; 
		}
		
	}

	@Override
	public boolean deposit(float depositAmount, Account account) {
		
		// handle date checking to reset counters
		
		if(dailyTransactionCount <= DAILY_TRANSACTION_LIMIT)
		{
			dailyTransactionCount = dailyTransactionCount + 1; 
			account.setBalance(depositAmount);
			System.out.println("Success: $" + depositAmount + " deposited to " + account.getType() + " account"); 
			
			return true; 
		}
		else
		{
			System.out.println("Failure: Daily transaction limit of " + DAILY_TRANSACTION_LIMIT + "reached for today"); 
			return false; 
		}
		
	}

	@Override
	public float viewBalance(Account account) {
		
		System.out.println(account.getType() + " Account Balance: $" + account.getBalance());
		return account.getBalance(); 
	}

	@Override
	public boolean transferFunds(Account transferFrom, Account transferTo, float amount) {
		
		// handle date checking to reset counters
		
		if(dailyTransactionCount <= DAILY_TRANSACTION_LIMIT)
		{
			dailyTransactionCount = dailyTransactionCount + 1; 
			transferFrom.setBalance(transferFrom.getBalance() - amount);
			transferTo.setBalance(transferTo.getBalance() + amount);
			
			System.out.println("Success: $" + amount + " transferred from " + transferFrom.getType() + " account, to " + transferTo.getType() + " account"); 
			return true; 
		}
		else
		{
			System.out.println("Failure: Daily transaction limit of " + DAILY_TRANSACTION_LIMIT + "reached for today"); 
			return false; 
		}
	}

	@Override
	public void resetCounters() {
		
		dailyWithdrawCount = 0; 
		dailyTransactionCount = 0;
	}

}
