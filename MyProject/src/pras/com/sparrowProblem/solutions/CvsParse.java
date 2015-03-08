package pras.com.sparrowProblem.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author pras_khanal
 *
 */
public class CvsParse {

	/**
	 * @param input
	 */
	public static List <String> parseCvs(String input) {
		//To save weather the double quote has been 
		//entered or not with initial value false
		boolean quoteCheck=false;
		List <String>csvList=new ArrayList<String>();
		StringBuilder buff = new StringBuilder(); 
		for(int i=0;i<input.length(); i++){
			//if char is quote biff it on string buff 
			//and make quote check true
			char token=input.charAt(i);
			if(token=='"') {
				quoteCheck=!quoteCheck;
				buff.append(token);
			}
			//if character is comma and is not inside quote
			//add buffered string to returning list
			else if(!quoteCheck&&token==','){
				csvList.add(buff.toString());
			buff.delete(0, buff.length());
			}
			else buff.append(token);
		}
		csvList.add(buff.toString());
		return csvList;
	}

}
