
/**
 * @author Brooklyn Coulson SID 200375222
 *  Course: ENSE 375 Software Testing and Validation
 *  Instructors: Yogesh Sharma and Trevor Douglas
 *  Assignment: Group Course Project
 *  Other group members: Shahzil Siddiqui, Quinn Maloney
 *  Filename: AccountHolderInfo.java
 * 
 *  Date Created: July 01, 2024
 *  Last Updated: July 05, 2024
 * 
 *  Description: This file describes all of the information associated with an Account Holder. The information it stores relates to personal information 
 *  needed in order to identify the Account Holder, as well as login credentials so they can access their accounts and perform tasks within the Banking
 *  Simulation Application. 
 */
package BankSim;

public class AccountHolderInfo {	
	private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;

    /**
	 * This is a constructor that will initialize a Account Holder. The Account Holder instance will keep track of the  user's personal information like their
     *  name, address, email, and phone number. It will also keep track of their login credentials so that only authorized people are able to perform banking 
     *  tasks on the user's accounts.
	 */
    public AccountHolderInfo(String userName, String pw, String firstName, String lastName, String addy, String email, String phoneNum) {
        this.username = userName;
        this.password = pw;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = addy;
        this.email = email;
        this.phone = phoneNum;
    }

    /**
	 * This function will retrieve the Account Holder's username.
	 * @return String; the username needed to login.  
	 */
    public String getUserName() {
        return this.username;
    }

    /**
	 * This function will retrieve the Account Holder's password.
	 * @return String; the password needed to login.  
	 */
    public String getPassword() {
        return this.password;
    }

    /**
	 * This function will retrieve the Account Holder's first name.
	 * @return String; the Account Holder's first name.  
	 */
    public String getFirstName() {
        return this.firstName;
    }

    /**
	 * This function will retrieve the Account Holder's last name.
	 * @return String; the Account Holder's last name.  
	 */
    public String getLastName() {
        return this.lastName;
    }

    /**
	 * This function will retrieve the Account Holder's address.
	 * @return String; the Account Holder's address.  
	 */
    public String getAddress() {
        return this.address;
    }

    /**
	 * This function will retrieve the Account Holder's email address.
	 * @return String; the Account Holder's email.  
	 */
    public String getEmail() {
        return this.email;
    }

    /**
	 * This function will retrieve the Account Holder's phone number.
	 * @return String; the Account Holder's phone number.  
	 */
    public String getPhone() {
        return this.phone;
    }

    /**
	 * This function will change the Account Holder's username.
	 * @param username the new username.  
	 */
    public void setUserName(String userName) {
        this.username = userName;
    }

    /**
	 * This function will change the Account Holder's password.
	 * @param pw the new password.  
	 */
    public void setPassword(String pw) {
        this.password = pw;
    }

    /**
	 * This function will change the Account Holder's first name.
	 * @param firstName the new first name.  
	 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
	 * This function will change the Account Holder's last name.
	 * @param lastName the new last name.  
	 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
	 * This function will change the Account Holder's home address.
	 * @param addy the new home address.  
	 */
    public void setAddress(String addy) {
        this.address = addy;
    }

    /**
	 * This function will change the Account Holder's email address.
	 * @param email the new email address.  
	 */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
	 * This function will change the Account Holder's phone number.
	 * @param phoneNum the new phone number.  
	 */
    public void setPhone(String phoneNum) {
        this.phone = phoneNum;
    }
}