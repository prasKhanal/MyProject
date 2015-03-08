/**
 * 
 */
package pras.com.sparrowProblem.input;

import java.util.List;
import java.util.Map;

/**
 * @author pras_khanal
 *
 */
public class SparrowInputaker {
	private InputTaker input;
	public SparrowInputaker(){
		this.input=new InputTaker();
	}
	/**
	 * This method is used to return name valu pair for 
	 * Spiral class input from user 
	 * @return
	 */
	public Map<String, String> getSpiralInput(){
		String[] valuetitle={ "row","column","xPosition","yPosition"};
		String delim=" ,";
		String message="Please enter row,colum,Xposition and YPosition for Spiral" +
			"Followed by space or comma in between:\n";
		return input.getInputWithToken(message, delim, valuetitle);	
	}
	/**
	 * To take input to run Cvs parse class..
	 * @return
	 */
	public String getCvsParseInput(){
		String message="Please enter the Cvs: \n";
		return input.getInput(message);
	}
	/**
	 * Name value pair input from user for Anagram solving by Anagram 
	 * class
	 * @return
	 */
	public Map<String, String> getAnagramInput(){
		String[] valuetitle={ "parentString","queryString"};
		String [] message={"Please enter the Main String:\n","Please enter the Query String:\n"};
		return input.getMultipleLineInput(message, valuetitle);
		
	}
	/**
	 * This methods take input for Bracket balance check
	 * @return
	 */
	public String getBracketInput(){
		String message="Please enter the bracket expression\n";
		return input.getInput(message);
	}
	/**
	 * Input number for Time confusion calculation
	 * @return
	 */
	private int getTotalTimeConfusionInput(){
		String message="Please enter the number of Time confusion you going to enter,\nFollowed by the times:\n";
		return input.getIntegerInput(message);
	}
	/**
	 * Plain lines inputs for time confusion calculation..
	 * @return
	 */
	 public List<String> getTimeConfusionInput(){
		 String message="";
		 return input.getMultipleLineInput(getTotalTimeConfusionInput(), message);
		 
	 }

}
