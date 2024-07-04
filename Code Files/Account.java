package BankSim;

public class Account {
	
	private String type; 
	private String accountNumber; 
	private float balance; 
	
	public Account (String type, String AccountNumber, float balance)
	{
		this.type = type; 
		this.accountNumber = AccountNumber; 
		this.balance = balance; 
	}
	
	public String getType()
	{
		return this.type; 
	}
	
	public String getAccountNumber ()
	{
		return this.accountNumber; 
	}
	
	public float getBalance()
	{
		return this.balance;
	}
	
	public void setBalance(float newBalance)
	{
		this.balance = newBalance; 
	}
}
