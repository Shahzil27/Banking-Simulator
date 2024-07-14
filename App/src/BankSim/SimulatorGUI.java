package BankSim;

import java.awt.*;    
import javax.swing.*;   
import javax.swing.JFrame;
import java.awt.event.*;

public class SimulatorGUI extends JFrame   {
	
	private TextField usernameInput;
	private TextField passwordInput;
	private TextField firstNameInput;
	private TextField lastNameInput;
	private TextField addressInput;
	private TextField emailInput;
	private TextField phoneInput;
	private TextField kidsFirstNameInput;
	private TextField kidsLastNameInput;
	private JComboBox<String[]> planChoice;
	private TextField chequingWithdrawAmount;
	private TextField savingsWithdrawAmount;
	private TextField chequingDepositAmount;
	private TextField savingsDepositAmount;
	private TextField transferAmount;
	private JButton submitLogin;
	private JButton selectBalance;
	private JButton selectWithdraw;
	private JButton selectDeposit;
	private JButton selectTransfer;
	private JButton selectLogout;
	private JButton confirmWithdrawChequing;
	private JButton confirmWithdrawSavings;
	private JButton confirmDepositChequing;
	private JButton confirmDepositSavings;
	private JButton selectBack;
	private JButton confirmTransfer;
	private JComboBox<String[]> transferFrom;
	private JComboBox<String[]> transferTo;
	private boolean creationError;
	private boolean loginError;
	private boolean loggedOut;
	private AccountHolderInfo account = new AccountHolderInfo("", "", "", "", "", "", "");
	private PlanFactory planfactory = new PlanFactory();
	private Plans plan;
	private Tuple message = new Tuple(true, "");
	
	
	public void createLoginPage() {
		
		setLayout(new GridLayout(10, 3));
		
		add(new JLabel("Banking Simulator"));
		add(new JLabel("Please enter your information"));
		add(new JLabel(""));
		
		add(new JLabel("Username:"));
		usernameInput = new TextField(account.getUserName());
		add(usernameInput);
		add(new JLabel(""));
		
		add(new JLabel("Password:"));
		passwordInput = new TextField();
		add(passwordInput);
		add(new JLabel(""));
		
		add(new JLabel("First Name:"));
		firstNameInput = new TextField(account.getFirstName());
		add(firstNameInput);
		add(new JLabel(""));
		
		add(new JLabel("Last Name:"));
		lastNameInput = new TextField(account.getLastName());
		add(lastNameInput);
		add(new JLabel(""));
		
		add(new JLabel("Address:"));
		addressInput = new TextField(account.getAddress());
		add(addressInput);
		add(new JLabel(""));
		
		add(new JLabel("Email:"));
		emailInput = new TextField(account.getEmail());
		add(emailInput);
		add(new JLabel(""));
		
		add(new JLabel("Phone:"));
		phoneInput = new TextField(account.getPhone());
		add(phoneInput);
		add(new JLabel(""));
		
		add(new JLabel("Plan:"));
		DefaultComboBoxModel<String> planModel = new DefaultComboBoxModel<>();
        planModel.addElement(new String("Basic"));
        planModel.addElement(new String("Student"));
        planModel.addElement(new String("Kids"));
        planChoice = new JComboBox(planModel);
        add(planChoice);
        add(new JLabel(""));

		if(creationError == true) {
			
			add(new JLabel("Error! Password must contain an uppercase"));
			add(new JLabel("letter, a number, and a symbol."));
		}
		
		else {
			add(new JLabel(""));
			add(new JLabel(""));
		}
		submitLogin = new JButton("Create Account");
		add(submitLogin);
		submitLogin.addActionListener(new createAccountListener());
		creationError = false;

	}
	
	public void createLoginPageKids() {
		
		setLayout(new GridLayout(5, 3));
		
		add(new JLabel("Banking Simulator"));
		add(new JLabel(""));
		add(new JLabel(""));
		
		add(new JLabel("Please enter your child's information"));
		add(new JLabel(""));
		add(new JLabel(""));
		
		add(new JLabel("First Name:"));
		kidsFirstNameInput = new TextField();
		add(kidsFirstNameInput);
		add(new JLabel(""));
		
		add(new JLabel("Last Name:"));
		kidsLastNameInput = new TextField();
		add(kidsLastNameInput);
		add(new JLabel(""));
		
		add(new JLabel(""));
		add(new JLabel(""));
		submitLogin = new JButton("Create Account");
		add(submitLogin);
		submitLogin.addActionListener(new createAccountKidsListener());
		creationError = false;
		
	}
	
	public void loginPage() {
			
		setLayout(new GridLayout(6, 2));
		
		add(new JLabel("Banking Simulator"));
		add(new JLabel(""));
		
		if(loginError == true) {
			
			add(new JLabel(""));
			add(new JLabel("Error! incorrect login credentials"));
			
			add(new JLabel(""));
			add(new JLabel(""));
		}
		
		else if(loggedOut == true) {
			add(new JLabel(""));
			add(new JLabel(""));
			
			add(new JLabel(""));
			add(new JLabel(""));
		}
		
		else {
			
			add(new JLabel(""));
			add(new JLabel("Account Successfully Created!"));
			
			add(new JLabel(""));
			add(new JLabel("Please Login"));
		}
		
		add(new JLabel("Username:"));
		usernameInput = new TextField();
		add(usernameInput);
		
		add(new JLabel("Password:"));
		passwordInput = new TextField();
		add(passwordInput);
		
		add(new JLabel(""));
		submitLogin = new JButton("Login");
		add(submitLogin);
		submitLogin.addActionListener(new loginListener());
		loginError = false;
		loggedOut = false;
			
	}
	
	public void homePage() {
		
		setLayout(new GridLayout(6, 3));
		add(new JLabel("Banking Simulator"));
		add(new JLabel(""));
		add(new JLabel("Welcome, " + account.getFirstName()));
		
		add(new JLabel(""));
		selectBalance = new JButton("Check Balance");
		add(selectBalance);
		selectBalance.addActionListener(new checkBalanceListener());
		add(new JLabel(""));
		
		add(new JLabel(""));
		selectWithdraw = new JButton("Withdraw");
		add(selectWithdraw);
		selectWithdraw.addActionListener(new withdrawListener());
		add(new JLabel(""));
		
		add(new JLabel(""));
		selectDeposit = new JButton("Deposit");
		add(selectDeposit);
		selectDeposit.addActionListener(new depositListener());
		add(new JLabel(""));
		
		add(new JLabel(""));
		selectTransfer = new JButton("Transfer Funds");
		add(selectTransfer);
		selectTransfer.addActionListener(new transferListener());
		add(new JLabel(""));
		
		add(new JLabel(""));
		selectLogout = new JButton("Logout");
		add(selectLogout);
		add(new JLabel(""));
		selectLogout.addActionListener(new logOutListener());

	}
	
	public void checkBalancePage() {
		
		setLayout(new GridLayout(0, 3));
		add(new JLabel("Banking Simulator"));
		add(new JLabel(""));
		add(new JLabel("Welcome, " + account.getFirstName()));
		
		add(new JLabel(""));
		add(new JLabel("Account Balance"));
		add(new JLabel(""));
		
		add(new JLabel("Chequing:"));
		add(new JLabel(String.format("%.2f", plan.viewBalance(plan.getChequing()))));
		add(new JLabel(""));
		
		add(new JLabel("Savings:"));
		add(new JLabel(String.format("%.2f", plan.viewBalance(plan.getSavings()))));
		add(new JLabel(""));
		
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		
		add(new JLabel(""));
		selectBack = new JButton("Back");
		add(selectBack);
		add(new JLabel(""));
		selectBack.addActionListener(new backButtonListener());

		}
	
	public void withdrawPage() {
		
		setLayout(new GridLayout(0, 3));
		add(new JLabel("Banking Simulator"));
		add(new JLabel(""));
		add(new JLabel("Welcome, " + account.getFirstName()));
		
		add(new JLabel(""));
		add(new JLabel("Withdraw"));
		add(new JLabel(""));
		
		add(new JLabel("Chequing: " + String.format("%.2f", plan.viewBalance(plan.getChequing()))));
		chequingWithdrawAmount = new TextField();
		add(chequingWithdrawAmount);
		confirmWithdrawChequing = new JButton("Confirm Withdraw");
		add(confirmWithdrawChequing);
		confirmWithdrawChequing.addActionListener(new confirmWithdrawChequingListener());
		
		add(new JLabel("Savings: " + String.format("%.2f", plan.viewBalance(plan.getSavings()))));
		savingsWithdrawAmount = new TextField();
		add(savingsWithdrawAmount);
		confirmWithdrawSavings = new JButton("Confirm Withdraw");
		add(confirmWithdrawSavings);
		confirmWithdrawSavings.addActionListener(new confirmWithdrawSavingsListener());
		
		add(new JLabel(""));
		add(new JLabel(message.getResultsDescription()));
		add(new JLabel(""));

		add(new JLabel(""));
		selectBack = new JButton("Back");
		add(selectBack);
		add(new JLabel(""));
		selectBack.addActionListener(new backButtonListener());
		
		message = new Tuple(true, "");

		}

	public void depositPage() {
		
		setLayout(new GridLayout(0, 3));
		add(new JLabel("Banking Simulator"));
		add(new JLabel(""));
		add(new JLabel("Welcome, " + account.getFirstName()));
		
		add(new JLabel(""));
		add(new JLabel("Deposit"));
		add(new JLabel(""));
		
		add(new JLabel("Chequing: " + String.format("%.2f", plan.viewBalance(plan.getChequing()))));
		chequingDepositAmount = new TextField();
		add(chequingDepositAmount);
		confirmDepositChequing = new JButton("Confirm Deposit");
		add(confirmDepositChequing);
		confirmDepositChequing.addActionListener(new confirmDepositChequingListener());
		
		add(new JLabel("Savings: " + String.format("%.2f", plan.viewBalance(plan.getSavings()))));
		savingsDepositAmount = new TextField();
		add(savingsDepositAmount);
		confirmDepositSavings = new JButton("Confirm Deposit");
		add(confirmDepositSavings);
		confirmDepositSavings.addActionListener(new confirmDepositSavingsListener());
		
		add(new JLabel(""));
		add(new JLabel(message.getResultsDescription()));
		add(new JLabel(""));

		add(new JLabel(""));
		selectBack = new JButton("Back");
		add(selectBack);
		add(new JLabel(""));
		selectBack.addActionListener(new backButtonListener());
		
		message = new Tuple(true, "");
	
		}
	
public void transferPage() {
		
		setLayout(new GridLayout(0, 3));
		add(new JLabel("Banking Simulator"));
		add(new JLabel(""));
		add(new JLabel("Welcome, " + account.getFirstName()));
		
		add(new JLabel(""));
		add(new JLabel("Transfer Funds"));
		add(new JLabel(""));
		
		DefaultComboBoxModel<String> accountModel1 = new DefaultComboBoxModel<>();
        accountModel1.addElement(new String("Savings"));
        accountModel1.addElement(new String("Chequing"));
		add(new JLabel("Account to transfer from:"));
		transferFrom = new JComboBox(accountModel1);
		add(transferFrom);
		add(new JLabel(""));
		
		DefaultComboBoxModel<String> accountModel2 = new DefaultComboBoxModel<>();
        accountModel2.addElement(new String("Chequing"));
        accountModel2.addElement(new String("Savings"));
		add(new JLabel("Account to transfer to:"));
		transferTo = new JComboBox(accountModel2);
		add(transferTo);
		add(new JLabel(""));
		
		add(new JLabel(""));
		transferAmount = new TextField();
		add(transferAmount);
		confirmTransfer = new JButton("Confirm Transfer");
		add(confirmTransfer);
		confirmTransfer.addActionListener(new confirmTransferListener());
		
		add(new JLabel(message.getResultsDescription()));
		selectBack = new JButton("Back");
		add(selectBack);
		add(new JLabel(""));
		selectBack.addActionListener(new backButtonListener());
		
		message = new Tuple(true, "");
	
		}
	
	public void displayPage() {
		
		setTitle("Banking Simulator");  // "super" Frame sets title
	    setSize(780, 250);  // "super" Frame sets initial window size
	    setVisible(true);   // "super" Frame shows
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class createAccountListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	String username = usernameInput.getText();
	    	String password = passwordInput.getText();
	    	String firstName = firstNameInput.getText();
	    	String lastName = lastNameInput.getText();
	    	String address = addressInput.getText();
	    	String email = emailInput.getText();
	    	String phone = phoneInput.getText();
	    	String planType = String.valueOf(planChoice.getSelectedItem());
	    	
	    	boolean uppercase = false;
	    	boolean symbol = false;
	    	boolean number = false;
	    	char checkPassword[] = password.toCharArray();
	    	for(int i = 0; i < password.length(); i++) {
	    		
	    		if(uppercase == false) 
	    			if(Character.isUpperCase(checkPassword[i]) == true)
	    				uppercase = true;		
	    		
	    		if(symbol == false)
	    			if(!Character.isDigit(checkPassword[i]) && !Character.isLetter(checkPassword[i]) && !Character.isWhitespace(checkPassword[i]))
	    				symbol = true;
	    		
	    		if(number == false)
	    			if(Character.isDigit(checkPassword[i]) == true)
	    				number = true;	
	    	}
	    	
	    	if(uppercase == true && symbol == true && number == true) {	
	    		//gather login info and store it
	    		account = new AccountHolderInfo(username, password, firstName, lastName, address, email, phone);
	    		if(planType.equals("Kids")) {
	    			getContentPane().removeAll();
	    			createLoginPageKids();
	    			validate();
	    		}
	    		
	    		else {
		    		plan = planfactory.getPlan(planType, account, "", "");
			    	getContentPane().removeAll();
			    	loginPage();
			    	validate();
	    		}
	    	}
	    	
	    	else {
	    		account = new AccountHolderInfo(username, "", firstName, lastName, address, email, phone);
	    		creationError = true;
	    		//System.out.print(account.getUserName());
	    		getContentPane().removeAll();
		    	createLoginPage();
		    	validate();
	    	}
	    }
	 }
	
	private class createAccountKidsListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    		//plan = planfactory.getPlan("Kids", account, kidsFirstNameInput.getText(),  kidsLastNameInput.getText());
	    		plan = planfactory.getPlan("Kids", account);
	    		getContentPane().removeAll();
		    	loginPage();
		    	validate();
	    	}
	    }
	
	private class loginListener implements ActionListener {
			
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	String user = usernameInput.getText();
		    	String password = passwordInput.getText();
		    	
		    	
		    	if(user.equals(account.getUserName()) && password.equals(account.getPassword())) {
			    	getContentPane().removeAll();
			    	homePage();
			    	validate();
		    	}
		    	else {
		    		loginError = true;
		    		getContentPane().removeAll();
			    	loginPage();
			    	validate();
		    	}
		    	
		 }
	

	}
	
	private class logOutListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	loggedOut = true;
	    	getContentPane().removeAll();
	    	loginPage();
	    	validate();
	    	
	    }
	}
	
	private class checkBalanceListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	getContentPane().removeAll();
	    	checkBalancePage();
	    	validate();
	    	
	    }
	}
	
	private class withdrawListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	getContentPane().removeAll();
	    	withdrawPage();
	    	validate();
	    	
	    }
	}
	
	private class depositListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	getContentPane().removeAll();
	    	depositPage();
	    	validate();
	    	
	    }
	}
	
	private class transferListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	getContentPane().removeAll();
	    	transferPage();
	    	validate();
	    	
	    }
	}
	
	private class backButtonListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	getContentPane().removeAll();
	    	homePage();
	    	validate();
	    	
	    }
	}
	
	private class confirmWithdrawChequingListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	
	    	if(chequingWithdrawAmount.getText().isEmpty()) {
	    		message = new Tuple(false, "Field empty");
	    		getContentPane().removeAll();
		    	withdrawPage();
		    	validate();
	    	}
	    	else {
		    	message = plan.withdraw(Float.parseFloat(chequingWithdrawAmount.getText()), plan.getChequing());
		    	getContentPane().removeAll();
		    	withdrawPage();
		    	validate();
	    	}
	    	
	    }
	}
	
	private class confirmWithdrawSavingsListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	
	    	if(savingsWithdrawAmount.getText().isEmpty()) {
	    		message = new Tuple(false, "Field empty");
		    	getContentPane().removeAll();
		    	withdrawPage();
		    	validate();
		    }
		    	else {
		    	message = plan.withdraw(Float.parseFloat(savingsWithdrawAmount.getText()), plan.getSavings());
		    	getContentPane().removeAll();
		    	withdrawPage();
		    	validate();
	    	}
	    }
	}
	
	private class confirmDepositChequingListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	if(chequingDepositAmount.getText().isEmpty()) {
	    		message = new Tuple(false, "Field empty");
	    		getContentPane().removeAll();
	    		depositPage();
	    		validate();
	    	}
	    	else {
		    	message = plan.deposit(Float.parseFloat(chequingDepositAmount.getText()), plan.getChequing());
		    	getContentPane().removeAll();
		    	depositPage();
		    	validate();
	    	}
	    	
	    }
	}
	
	private class confirmDepositSavingsListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	if(savingsDepositAmount.getText().isEmpty()) {
	    		message = new Tuple(false, "Field empty");
	    		getContentPane().removeAll();
		    	depositPage();
		    	validate();
	    	}
	    	else {
		    	message = plan.deposit(Float.parseFloat(savingsDepositAmount.getText()), plan.getSavings());
		    	getContentPane().removeAll();
		    	depositPage();
		    	validate();
	    	}
	    	
	    }
	}
	
	private class confirmTransferListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	if(String.valueOf(transferFrom.getSelectedItem()).equals(String.valueOf(transferTo.getSelectedItem()))) {
	    		message = new Tuple(false, "Error: Must Select 2 Different Accounts");
	    		System.out.print("error");
	    		getContentPane().removeAll();
		    	transferPage();
		    	validate();
	    	}
	    	else {
	    		if(transferFrom.getSelectedItem().equals("Chequing"))	    
	    			message = plan.transferFunds(plan.getChequing(), plan.getSavings(), Float.parseFloat(transferAmount.getText()));
	    		else
	    			message = plan.transferFunds(plan.getSavings(), plan.getChequing(), Float.parseFloat(transferAmount.getText()));
		    	getContentPane().removeAll();
		    	transferPage();
		    	validate();
	    	}
	    	
	    }
	}
	
}
