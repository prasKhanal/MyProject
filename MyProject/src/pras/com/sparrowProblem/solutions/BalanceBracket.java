package pras.com.sparrowProblem.solutions;

import java.util.Stack;

/**
 * 
 */

/**
 * @author pras_khanal
 *
 */
public class BalanceBracket {
    
	
	
	/**
	 * The only visible static method
	 * which check the bracket balance.. 
	 * @param input
	 * @return
	 */
	public static String checkBalance(String input) {
		
		if (checkBracketBalance(input)) return "Balanced";
		return "Not Balanced";
	}
	

	/**
	 * This method check weather the string input has balanced
	 * bracket or not.
	 * @param input Bracket expression
	 */
	private static boolean checkBracketBalance(String input) {
		    //creating stack to store open brackets.
			Stack<Character> stack=new Stack <Character>();
			for(int i=0;i<input.length(); i++){
				char token=input.charAt(i);
				//continue to loop if the token is space
				if(token==' ') continue;
				//if opening bracket push to the stack
				if (checkOpeningBrackets(token))
				stack.push(token);
				//if closing bracket
				//first check if any opening bracket is in the stack
				else  if (stack.empty()) 
					return false;
			    //then check if the closing bracket balance first bracket of stack
				//if balanced then remove that bracket from stack
				else if ((checkbalance(token,stack.peek())))
						{ 
					stack.pop();
					}
				else 
					return false;
				}
			//finally check weather all the bracket is balanced 
			//and stack for opening bracket is empty
			if (stack.isEmpty())
			return true;
			else 
				return false;		
	}


	/**
	 * This method check balance of individual bracket.
	 * @param token
	 * @param peek
	 * @return
	 */
	private static boolean checkbalance(char token, Character peek) {
		if((token==')'&&peek=='(')||(token=='}'&&peek=='{')||(token==']'&&peek=='[')){
		return true;
		}
		return false;
	}
	/**
	 * This method weather the bracket is opening or closing
	 * @param value
	 * @return boolean 
	 */
	private static boolean checkOpeningBrackets(char value){
		if(value=='{'||value=='('||value=='['){
		    return true;
		}
			return false;
	}
}
