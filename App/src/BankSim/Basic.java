package BankSim;

import java.time.LocalDate;

public class Basic implements Plans {
	
	private Account savingsAccount;
	private Account checkingAccount;
	private AccountHolderInfo basicAccountHolder; 
	
	float dailyWithdrawCount;
	int dailyTransactionCount;
	LocalDate dailyTrackingDate;  
	
	float DAILY_WITHDRAW_LIMIT = 200f; 
	int DAILY_TRANSACTION_LIMIT = 10; 
	
	public Basic(AccountHolderInfo accountHolderInfo)
	{
		basicAccountHolder = accountHolderInfo; 
		savingsAccount = new Account("savings", "3478 4733 5684 2938", 500.00f); 
		checkingAccount = new Account("Checking", "3478 4733 5684 2939", 2500.00f);
		dailyWithdrawCount = 0f;
		dailyTransactionCount = 0;
		dailyTrackingDate = LocalDate.now(); 
		
	}
	
	
	@Override
	public Tuple withdraw(float withdrawAmount, Account account) {
		// TODO Auto-generated method stub
		Tuple result = new Tuple();
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
						
						result.setTaskStateDescription("Success: $" + withdrawAmount + "withdrawn from " + oldBalance);
						result.setTaskStatus(true);
						return result;
					}
					else
					{
						result.setTaskStateDescription("Failure: Daily transaction limit of " + DAILY_TRANSACTION_LIMIT + "reached for today"); 
						result.setTaskStatus(false); 
						return result;
					}	
				}
				else
				{
					result.setTaskStateDescription("Failure: Total Withdrawn exceeds daily withdraw limit. Withdrawn Today: " + dailyWithdrawCount);
					result.setTaskStatus(false);
					return result;
				}
			}
			else
			{
				result.setTaskStateDescription("Failure: $" + withdrawAmount + " exceeds daily withdraw limit of " + DAILY_WITHDRAW_LIMIT + "for Basic Plan.");
				result.setTaskStatus(false); 
				return result;
			}
		}
		else
		{
			result.setTaskStateDescription("Faiure: Not enough funds to withdraw $" + withdrawAmount + ", current balance: $" + oldBalance);
			result.setTaskStatus(false);  
			return result;
		}
		
	}

	@Override
	public Tuple deposit(float depositAmount, Account account) {
		
		// handle date checking to reset counters
		Tuple result = new Tuple(); 
		
		if(dailyTransactionCount <= DAILY_TRANSACTION_LIMIT)
		{
			dailyTransactionCount = dailyTransactionCount + 1; 
			account.setBalance(depositAmount);
			
			result.setTaskStateDescription("Success: $" + depositAmount + " deposited to " + account.getType() + " account");
			result.setTaskStatus(true);  
			return result; 
		}
		else
		{
			result.setTaskStateDescription("Failure: Daily transaction limit of " + DAILY_TRANSACTION_LIMIT + "reached for today"); 
			result.setTaskStatus(false);  
			return result; 
		}
		
	}

	@Override
	public float viewBalance(Account account) {
		
		//System.out.println(account.getType() + " Account Balance: $" + account.getBalance());
		return account.getBalance(); 
	}

	@Override
	public Tuple transferFunds(Account transferFrom, Account transferTo, float amount) {
		
		// handle date checking to reset counters
		Tuple result = new Tuple(); 
		
		if(dailyTransactionCount <= DAILY_TRANSACTION_LIMIT)
		{
			dailyTransactionCount = dailyTransactionCount + 1; 
			transferFrom.setBalance(transferFrom.getBalance() - amount);
			transferTo.setBalance(transferTo.getBalance() + amount);
			
			result.setTaskStateDescription("Success: $" + amount + " transferred from " + transferFrom.getType() + " account, to " + transferTo.getType() + " account"); 
			result.setTaskStatus(true); 
			return result; 
		}
		else
		{
			result.setTaskStateDescription("Failure: Daily transaction limit of " + DAILY_TRANSACTION_LIMIT + "reached for today"); 
			result.setTaskStatus(false); 
			return result; 
		}
	}

	@Override
	public void resetCounters() {
		
		dailyWithdrawCount = 0; 
		dailyTransactionCount = 0;
	}

}
