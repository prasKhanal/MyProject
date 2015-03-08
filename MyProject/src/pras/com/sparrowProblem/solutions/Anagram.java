package pras.com.sparrowProblem.solutions;
import java.util.Arrays;
import java.util.Map;

/**
 * 
 */

/**
 * @author pras_khanal
 *
 */
public class Anagram {
	public static int checkAnagram(Map<String, String> map){
		String parentString=map.get("parentString");
		String queryString=map.get("queryString");
		return checkAnagram(parentString,queryString);
	}

	/**
	 * This methods check number of anagram and 
	 * returns the number
	 * @param parentString 
	 * @param queryString
	 * @return int number of anagrams
	 */
	private static int checkAnagram(String parentString, String queryString) {
		int count=0;
		int queryStringLength=queryString.length();
		//the number of possible substring for parentString string
		int totalSubstring=parentString.length()-queryStringLength+1;
		String sortedqueryString=sort(queryString);
		
		for (int i=0; i< totalSubstring; i++){
			String reducedparentString=parentString.substring(i, queryStringLength+i);
			if(containSameCharacters(reducedparentString,sortedqueryString))
				count++;
		}
		return count;
		}
	/**
	 * This methods compares two unsorted strings with sortedqueryString
	 * disregarding the case
	 * @param parentString 
	 * @param sortedqueryString
	 * @return boolean result of comparision
	 */
	private static boolean containSameCharacters (String parentString, String sortedqueryString){
		
		if(parentString.length()!=sortedqueryString.length()) 
			return false;	
		if (sort(parentString.toLowerCase()).equals(sortedqueryString.toLowerCase())){
				return true;
		}
		return false;
	}
	/**
	 * This method sorts the characters within the Strings.
	 * @param unsorted String
	 * @return sorted String
	 */
	private static String sort(String unsorted ){
		char [] chars=unsorted.toCharArray();
		Arrays.sort(chars);
		String sorted =new String(chars);
		return sorted;
	}
}
