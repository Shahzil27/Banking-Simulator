
/**
 *  @author Brooklyn Coulson SID 200375222
 *  Course: ENSE 375 Software Testing and Validation
 *  Instructors: Yogesh Sharma and Trevor Douglas
 *  Assignment: Group Course Project
 *  Other group members: Shahzil Siddiqui, Quinn Maloney
 *  Filename: PlanFactory.java
 * 
 *  Date Created: July 05, 2024
 * 
 *  Description: This file describes how various information will be returned from a function call so that the GUI will be able to relay/display accurate
 *  and valuable information to the user. There will be two types of information stored within the Tuple class; a boolean stating whether the requested task
 *  was successfully completed, and a String that will contain a description of the success/failure state being returned. This will allow the Main function 
 *  to be able to perform additional logical tasks according to the success/failure state and the reason driving that state. 
 */
package BankSim;

public class Tuple {
    private boolean taskCompleted;
    private String taskStateDescription;

    public Tuple() {
        this.taskCompleted = false;
        this.taskStateDescription = "";
    }
    
    /**
	 * This is a constructor that will initialize a new Tuple. The Tuple will store the success state of a requested banking task, as well as a description of 
     * the results of that task explaining why it succeeded or failed. 
	 */
    public Tuple(boolean taskCompleted, String description) {
        this.taskCompleted = taskCompleted;
        this.taskStateDescription = description;
    }
    
    /**
	 * This function will set the boolean value for the taskCompleted primary variable
	 * @param	taskCompleted is a boolean parameter used to set the local boolean variable
	 */
    public void setTaskStatus(boolean taskCompleted) {
    	this.taskCompleted = taskCompleted;
    }
    
    /**
	 * This function will set the String value for the taskStateDescription primary variable
	 * @param	description is a string parameter used to set the local taskStateDescription variable
	 */
    public void setTaskStateDescription(String description) {
    	this.taskStateDescription = description; 
    }

    /**
	 * This function will retrieve the completion state of the banking task in question.
	 * @return true or false; this reflects whether the task was successfully completed.  
	 */
    public boolean getTaskStatus() {
        return this.taskCompleted;
    }

    /**
	 * This function will retrieve the description of the completion state of the banking task in question.
	 * @return String; this describes why the task succeeded or failed.  
	 */
    public String getResultsDescription() {
        return this.taskStateDescription;
    }
}
