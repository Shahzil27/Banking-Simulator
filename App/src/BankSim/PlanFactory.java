package BankSim;

/**
 * @author Brooklyn Coulson SID 200375222
 *  Course: ENSE 375 Software Testing and Validation
 *  Instructors: Yogesh Sharma and Trevor Douglas
 *  Assignment: Group Course Project
 *  Other group members: Shahzil Siddiqui, Quinn Maloney
 *  Filename: PlanFactory.java
 * 
 *  Date Created: July 01, 2024
 *  Last Updated: July 14, 2024
 * 
 *  Description: This file describes the Plan Factory itself. This is like the middle man where the main method in FactoryPlanController.java file will ask for 
 *  specific plans to be created at run time, and this file shows how the factory will create a new instance of it and send it back to main.
 */

public class PlanFactory {
    public Plans getPlan(String plan, AccountHolderInfo accountHolder, String kidFirstName, String kidLastName) {
        if (plan.equalsIgnoreCase("KIDS")) {
            // Logic to get the Kid information and Parent information
            return new Kids(accountHolder, kidFirstName, kidLastName);
        }
        else if (plan.equalsIgnoreCase("BASIC")) {
            // Logic to get the Account Holder information
            return new Basic(accountHolder, "", "");
        }
        else if (plan.equalsIgnoreCase("STUDENT")) {
            // Logic to get the Account Holder information
            return new Student(accountHolder, "", "");
        }
        else {
            return null;
        }
    }
}
