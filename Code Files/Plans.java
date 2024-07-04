package BankSim;

public interface Plans {
	
	boolean withdraw(float withdrawAmount, Account account);
	boolean deposit(float depositAmount, Account account); 
	float viewBalance(Account account);
	boolean transferFunds(Account transferFrom, Account transferTo, float amount);
	void resetCounters(); 
}
