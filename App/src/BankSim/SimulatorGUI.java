/**
 *  @author Quinn Maloney SID 200431628
 *  Course: ENSE 375 Software Testing and Validation
 *  Instructors: Yogesh Sharma and Trevor Douglas
 *  Assignment: Group Course Project
 *  Other group members: Brooklyn Coulson, Shahzil Siddiqui
 *  Filename: SimulatorGUI.java
 * 
 *  Last Updated: July 14, 2024
 * 
 *  Description: This File contains the methods and private classes required to control the GUI. Navigation is controlled here
 *  allowing the user to: Create an account with their selected plan, login and logout, View their balance, withdraw funds, 
 *  deposit funds, as well as transfer funds between accounts. Each Method is a page using Swing and JFrame and each private class
 *  with an overridden method are events to aid in switching pages as well as calling methods to complete the appropriate actions.
 */
package BankSim;

import java.awt.*;    
import javax.swing.*;   
import javax.swing.JFrame;
import java.awt.event.*;

public class SimulatorGUI extends JFrame   {
	
	private TextField usernameInput; 			// for getting the inputed username
	private TextField passwordInput; 			// for getting the inputed password
	private TextField firstNameInput; 			// for getting the inputed First Name
	private TextField lastNameInput;			// for getting the inputed Last Name
	private TextField addressInput;				// for getting the inputed address
	private TextField emailInput;		 		// for getting the inputed email
	private TextField phoneInput; 				// for getting the inputed phone number
	private TextField kidsFirstNameInput; 		// for getting the inputed kids First Name
	private TextField kidsLastNameInput; 		// for getting the inputed kids Last Name
	private JComboBox<String[]> planChoice; 	// ComboBox to list the plan options listed Basic, Student, Kids
	private TextField chequingWithdrawAmount;	// for getting amount to withdraw from chequing
	private TextField savingsWithdrawAmount; 	// for getting amount to withdraw from savings
	private TextField chequingDepositAmount; 	// for getting amount to deposit from chequing
	private TextField savingsDepositAmount;		// for getting amount to deposit from savings
	private TextField transferAmount; 			// for getting amount to transfer between accounts
	private JButton submitLogin; 				// button to submit login and account creation info
	private JButton selectAccountDetails;
	private JButton selectBalance; 				// button to go to check balance
	private JButton selectWithdraw; 			// button to go to withdraw menu
	private JButton selectDeposit;				// button to go to deposit menu
	private JButton selectTransfer; 			// button to go to transfer funds menu
	private JButton selectLogout;				// button to logout
	private JButton confirmWithdrawChequing;	// button to confirm withdraw on chequing account
	private JButton confirmWithdrawSavings;		// button to confirm withdraw on savings account
	private JButton confirmDepositChequing;		// button to confirm deposit on chequing account
	private JButton confirmDepositSavings;		// button to confirm deposit on savings account
	private JButton selectBack;					// button to return to the home menu
	private JButton confirmTransfer;			// button to confirm money transfer
	private JComboBox<String[]> transferFrom;	// ComboBox to hold account types to transfer from
	private JComboBox<String[]> transferTo;		// ComboBox to hold account types to transfer to
	private boolean creationError;				// for tracking when there is an error in login creation
	private boolean loginError;					// keeps track of incorrect login credentials
	private boolean loggedOut;					// keeps track of if the user is logged out or not
	private AccountHolderInfo account = new AccountHolderInfo("", "", "", "", "", "", "");	// blank account holder info for obtaining entered values
	private PlanFactory planfactory = new PlanFactory(); // initialization of factory for plan creation
	private Plans plan;							// initialization of plan for user
	private Tuple message = new Tuple(true, "");// tuple value to carry error messages and failures from other files
	private boolean isKids;						// for changing what is displayed if the plan is a Kids plan since they do not have a chequing account
	
	/**This is the first page the user sees when entering the program. It prompts them to enter their
	 * information and assuming all info is entered properly an account will be created for the user
	 * upon selecting the create account button.
	 */
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
	
	/**This page is only used when the type of account selected on the createLoginPage() screen is
	 * a Kids account. This page is used to collect the Kids first and last name before initializing
	 * their account.
	 */
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
	
	/**This page is where the user will be directed after creating their account or logging out. They
	 * will be prompted to enter their credentials to log into the program. If their information is
	 * entered correctly they will be taken to the homePage().
	 */
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
	
	/**This page is the home page and acts like a hub for all the activities the user can do. From here
	 * the user can enter a variety of other pages to complete the associated action. They can also Logout.
	 */
	public void homePage() {
		
		setLayout(new GridLayout(7, 3));
		add(new JLabel("Banking Simulator"));
		add(new JLabel(""));
		add(new JLabel("Welcome, " + account.getFirstName()));
		
		add(new JLabel(""));
		selectAccountDetails = new JButton("Account Details");
		add(selectAccountDetails);
		selectAccountDetails.addActionListener(new accountDetailsListener());
		add(new JLabel(""));
		
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
		
		if(isKids == false) {
			add(new JLabel(""));
			selectTransfer = new JButton("Transfer Funds");
			add(selectTransfer);
			selectTransfer.addActionListener(new transferListener());
			add(new JLabel(""));
		}
		
		else {
			add(new JLabel(""));
			add(new JLabel(""));
			add(new JLabel(""));
		}
		
		add(new JLabel(""));
		selectLogout = new JButton("Logout");
		add(selectLogout);
		add(new JLabel(""));
		selectLogout.addActionListener(new logOutListener());

	}
	
	/**This page allows the user to check the information attached to their accounts. The values will be 
	 * displayed to the user and they can select back to return to the home page at any time.
	 */
	public void accountDetailsPage() {
		
		setLayout(new GridLayout(9, 3));
		add(new JLabel("Banking Simulator"));
		add(new JLabel(""));
		add(new JLabel("Welcome, " + account.getFirstName()));
		
		add(new JLabel(""));
		add(new JLabel("Account Details"));
		add(new JLabel(""));
		
		add(new JLabel("Username:"));
		add(new JLabel(account.getUserName()));
		add(new JLabel(""));
		
		add(new JLabel("First Name:"));
		add(new JLabel(account.getFirstName()));
		add(new JLabel(""));
		
		add(new JLabel("Last Name:"));
		add(new JLabel(account.getLastName()));
		add(new JLabel(""));
		
		add(new JLabel("Address:"));
		add(new JLabel(account.getAddress()));
		add(new JLabel(""));
		
		add(new JLabel("Email:"));
		add(new JLabel(account.getEmail()));
		add(new JLabel(""));
		
		add(new JLabel("Phone Number:"));
		add(new JLabel(account.getPhone()));
		add(new JLabel(""));
		
		add(new JLabel(""));
		selectBack = new JButton("Back");
		add(selectBack);
		add(new JLabel(""));
		selectBack.addActionListener(new backButtonListener());

	}
	
	/**This page allows the user to check the balance of their accounts. The values will be displayed to the user
	 * and they can select back to return to the home page at any time.
	 */
	public void checkBalancePage() {
		
		setLayout(new GridLayout(0, 3));
		add(new JLabel("Banking Simulator"));
		add(new JLabel(""));
		add(new JLabel("Welcome, " + account.getFirstName()));
		
		add(new JLabel(""));
		add(new JLabel("Account Balance"));
		add(new JLabel(""));
		
		if(isKids == false) {
			add(new JLabel("Chequing:"));
			add(new JLabel(String.format("%.2f", plan.viewBalance(plan.getChequing()))));
			add(new JLabel(""));
		}
		
		else {
			add(new JLabel(""));
			add(new JLabel(""));
			add(new JLabel(""));
		}
		
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
	
	/**This page allows the user to withdraw money from their account. The user can only withdraw as much money as 
	 * they have and must stay within the limit set by their plan. This means only a certain amount of transaction
	 * or a certain amount of money can be taken out per day. The user can select back to return to the home page at 
	 * any time.
	 */
	public void withdrawPage() {
		
		setLayout(new GridLayout(0, 3));
		add(new JLabel("Banking Simulator"));
		add(new JLabel(""));
		add(new JLabel("Welcome, " + account.getFirstName()));
		
		add(new JLabel(""));
		add(new JLabel("Withdraw"));
		add(new JLabel(""));
		
		if(isKids == false) {
			add(new JLabel("Chequing: " + String.format("%.2f", plan.viewBalance(plan.getChequing()))));
			chequingWithdrawAmount = new TextField();
			add(chequingWithdrawAmount);
			confirmWithdrawChequing = new JButton("Confirm Withdraw");
			add(confirmWithdrawChequing);
			confirmWithdrawChequing.addActionListener(new confirmWithdrawChequingListener());
		}
		
		else {
			add(new JLabel(""));
			add(new JLabel(""));
			add(new JLabel(""));
		}
		
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

	/**This page allows the user to deposit money into their account. There is a limit to this functionality as the 
	 * user can only make so many transactions a day base don their plan. The user can select back to return to the 
	 * home page at any time.
	 */
	public void depositPage() {
		
		setLayout(new GridLayout(0, 3));
		add(new JLabel("Banking Simulator"));
		add(new JLabel(""));
		add(new JLabel("Welcome, " + account.getFirstName()));
		
		add(new JLabel(""));
		add(new JLabel("Deposit"));
		add(new JLabel(""));
		
		if(isKids == false) {
			add(new JLabel("Chequing: " + String.format("%.2f", plan.viewBalance(plan.getChequing()))));
			chequingDepositAmount = new TextField();
			add(chequingDepositAmount);
			confirmDepositChequing = new JButton("Confirm Deposit");
			add(confirmDepositChequing);
			confirmDepositChequing.addActionListener(new confirmDepositChequingListener());
		}
		
		else {
			add(new JLabel(""));
			add(new JLabel(""));
			add(new JLabel(""));
		}
		
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
	
	/**This page allows the user to transfer funds between accounts the user has. This can be Chequing to Savings
	 * or Savings to Chequing. The user cannot transfer money the do not have as they cannot enter the negatives.
	 * The user can select back to return to the home page at any time.
	 */
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

	/**this method makes the page visible to the user so they can interact with the GUI. It also makes the
	 * application stop running when the window is closed.
	 */
	public void displayPage() {
		
		setTitle("Banking Simulator");
	    setSize(780, 300);
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**This private class as well as all of the following private classes are created in order to implement
	 * Listeners to trigger the desired events when the associated elements are interacted with. This
	 * listener gets the users information from the create login page and creates an account for them as long
	 * as they have a valid password of 1 upper case letter, 1 symbol, and 1 number. They will then be directed
	 * to the login page.
	 */
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
	    			isKids = true;
	    			getContentPane().removeAll();
	    			createLoginPageKids();
	    			validate();
	    		}
	    		
	    		else {
		    		plan = planfactory.getPlan(planType, account, "", "");
		    		isKids = false;
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
	
	/**This listener gets the kids information for account creation and acts similarly to the above listener.
	 * It does not however need to validate password selection as this has been done in the previous step. They
	 * will then be directed to the login page.
	 */
	private class createAccountKidsListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    		//plan = planfactory.getPlan("Kids", account, kidsFirstNameInput.getText(),  kidsLastNameInput.getText());
	    		plan = planfactory.getPlan("Kids", account, kidsFirstNameInput.getText(), kidsLastNameInput.getText());
	    		getContentPane().removeAll();
		    	loginPage();
		    	validate();
	    	}
	    }
	
	/**This listener checks the users login credentials to see if they match the ones on the account.
	 * If they do the user will be redirected to the home page. Otherwise they will receive an error and stay on 
	 * the current page.
	 */
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
	
	/**This listener logs out the user from the home page and returns them to the login page.
	 */
	private class logOutListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	loggedOut = true;
	    	getContentPane().removeAll();
	    	loginPage();
	    	validate();
	    	
	    }
	}
	
	/**This Listener redirects the user to the account details page.
	 */
	private class accountDetailsListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	getContentPane().removeAll();
	    	accountDetailsPage();
	    	validate();
	    	
	    }
	}
	
	/**This Listener redirects the user to the check balance page.
	 */
	private class checkBalanceListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	getContentPane().removeAll();
	    	checkBalancePage();
	    	validate();
	    	
	    }
	}
	
	/**This Listener redirects the user to the withdraw page.
	 */
	private class withdrawListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	getContentPane().removeAll();
	    	withdrawPage();
	    	validate();
	    	
	    }
	}
	
	/**This Listener redirects the user to the deposit page.
	 */
	private class depositListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	getContentPane().removeAll();
	    	depositPage();
	    	validate();
	    	
	    }
	}
	
	/**This Listener redirects the user to the transfer funds page.
	 */
	private class transferListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	getContentPane().removeAll();
	    	transferPage();
	    	validate();
	    	
	    }
	}
	
	/**This Listener redirects the user to the home page.
	 */
	private class backButtonListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	    	getContentPane().removeAll();
	    	homePage();
	    	validate();
	    	
	    }
	}
	
	/**This Listener calls the withdraw method from the plan file for the chequing account. This
	 * removes money from that account assuming there is not error. A message and success state are
	 * passed to notify the user of the result of the withdraw.
	 */
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
	
	/**This Listener calls the withdraw method from the plan file for the savings account. This
	 * removes money from that account assuming there is not error. A message and success state are
	 * passed to notify the user of the result of the withdraw.
	 */
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
	
	/**This Listener calls the deposit method from the plan file for the chequing account. This
	 * adds money to that account. A message and success state are passed to notify the user of 
	 * the result of the deposit.
	 */
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
	
	/**This Listener calls the deposit method from the plan file for the savings account. This
	 * adds money to that account. A message and success state are passed to notify the user of 
	 * the result of the deposit.
	 */
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
	
	/**This Listener calls the transfer funds method from the plan file using the appropriate accounts as
	 * selected by the user to transfer the entered amount of funds. A message and success state are passed 
	 * to notify the user of the result of the deposit.
	 */
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
