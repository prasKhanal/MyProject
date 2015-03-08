/**
 * 
 */
package pras.com.sparrowProblem.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author pras_khanal
 *
 */
public class InputTaker {
	BufferedReader scanner;
	public InputTaker(){
		scanner = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void close(){
		try {
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	/**
	 * Method returns name value pair from input 
	 * input is taken from user and value is passed as agrument from user..
	 * String tokenizer is used to seperate values from inputs.
	 * @param message
	 * @param delim
	 * @param valuetitle
	 * @return
	 */
	public Map<String, String> getInputWithToken(String message,String delim,String[] valuetitle){
		Map<String, String> rtnList= new HashMap<String, String>();
			try{
		String input=getInput(message);
		StringTokenizer tokens=new StringTokenizer(input,delim,false);
		int i=0;
		while(tokens.hasMoreTokens()){
			String ta=tokens.nextToken().trim();			
			rtnList.put(valuetitle[i],ta);
			i++;
		}
		
		}
		catch(Exception e){
			System.out.print("Please enter the value correctlly:\n");
			getInputWithToken(message,delim,valuetitle);
		}
	
		return rtnList;	
	}
	/**
	 * Method returns name value pair from input 
	 * input is taken from user and value is passed as agrument from user..
	 *  
	 * @param message
	 * @param valuetitle
	 * @return
	 */
	public Map<String, String> getMultipleLineInput(String [] message,String[] valuetitle){
		Map<String, String> rtnList= new HashMap<String, String>();
		
		try{
		for(int i=0;i<message.length;i++){
		System.out.print(message[i]+"\n");
		String  input=scanner.readLine().trim();
		rtnList.put(valuetitle[i],input);
		}
		
		}
		catch(Exception e){
			System.out.print("Please enter the value correctlly:\n");
			getMultipleLineInput(message,valuetitle);
		}
		
	
		return rtnList;
	
	}
	/**
	 * Muthod to return multiple lines from user at once and 
	 * returns list of those strings.
	 * @param number
	 * @param message
	 * @return
	 */
	public List<String> getMultipleLineInput(int number,String message){
		List<String> rtnList= new ArrayList<String>();
		
		try{
		for(int i=0;i<number;){
		String  input=scanner.readLine().trim();
		if (input.equals("")) continue;
		rtnList.add(input);
		i++;
		}
		}
		catch(Exception e){
			System.out.print("Please enter the value correctlly:\n");
			getMultipleLineInput(number,message);
		}
		
		return rtnList;
	
	}
	/**
	 * Method which displays message which is passed as parameter 
	 * and returns input taken as integer
	 * @param message
	 * @return
	 */
	public int getIntegerInput(String message){
		System.out.print(message+"\n");
		int input = 0;
		try {
			input = Integer.parseInt(scanner.readLine().trim());
		} catch (IOException e) {
			System.out.print("Please enter the integer value correctlly:\n");
			getIntegerInput(message);
		}
		return input;
		
	}
	/**
	 * Method to take general input.
	 * @param message
	 * @return
	 */
	public String getInput(String message){
		
			System.out.print(message+"\n");
			String input="";
			try {
				input = scanner.readLine().trim();
			} catch (IOException e) {
				System.out.print("Please enter the value correctlly:\n");
				getInput(message);
			}
			return input;
	}
	 

	
}
