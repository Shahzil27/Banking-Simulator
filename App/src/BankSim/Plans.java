package BankSim;

public interface Plans {
	
	Tuple withdraw(float withdrawAmount, Account account);
	Tuple deposit(float depositAmount, Account account); 
	float viewBalance(Account account);
	Tuple transferFunds(Account transferFrom, Account transferTo, float amount);
	void resetCounters(); 
}
