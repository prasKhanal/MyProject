/**
 * 
 */
package pras.com.sparrowProblem.driver;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import pras.com.sparrowProblem.input.SparrowInputaker;
import pras.com.sparrowProblem.solutions.Anagram;
import pras.com.sparrowProblem.solutions.BalanceBracket;
import pras.com.sparrowProblem.solutions.CvsParse;
import pras.com.sparrowProblem.solutions.Spiral;
import pras.com.sparrowProblem.solutions.timeConfusion.TimeConfusion;


/**
 * @author pras_khanal
 *
 */
public class Driver {

private SparrowInputaker inputtaker;


public Driver(){
this.inputtaker =new SparrowInputaker();
	  

}
/**
 * Run the spiral with taking input from SparrowInputaker
 * @return the list of number pattern in spiral order
 */
public List<Integer> runspiral(){
	return Spiral.runSpiral(inputtaker.getSpiralInput());
	
}
/**
 * Runs the Cvs Prase 
 * @return list of string after seperation
 */
public List<String> runCvsParse(){
	return CvsParse.parseCvs(inputtaker.getCvsParseInput());
}
/**
 * runs bracket balance checker  
 * @return a string value Balanced if balance or Unbalanced
 * if not balanced.
 */
public String runBalanceBracket(){
	return BalanceBracket.checkBalance(inputtaker.getBracketInput());
	
}
/**
 * runs anagram checker
 * @return numbers of anagram 
 */
public int runAnagram(){
	return Anagram.checkAnagram(inputtaker.getAnagramInput());
} 
/**
 * runs time confusion and returns valid if abled to 
 * be extracted
 * @return the valid time
 */
public String runTimeConfusion(){
	return TimeConfusion.solveconfusion(inputtaker.getTimeConfusionInput());
}
/**
 * The main method of the project
 * @param args
 */
public static void main(String [] args){
	Driver driver=new Driver();
	//runSpiral
	System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<");
	System.out.println("RunSpiral");
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<");
	try{
	System.out.println(Arrays.asList(driver.runspiral().toString()));
	}
	catch(Exception e){
	System.out.println("Error parsing the input");	
	}
	
	//run cVs
	System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<");
	System.out.println("RunCVS");
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<");
	try{
	Iterator<String> iterator=driver.runCvsParse().iterator();
	while(iterator.hasNext())
	System.out.print(iterator.next()+"\n"); 
	}
	catch(Exception e){
	System.out.println("Error parsing the input");	
	}
	
	
	//runAnagram
	System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<");
	System.out.println("Run ANAGRAM");
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<");
	try{
	System.out.print(driver.runAnagram());
	}
	catch(Exception e){
	System.out.println("Error parsing the input");	
	}
	
	
	//run  time confusion
	System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<");
	System.out.println("TIME CONFUSION");
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<");
	try{
	System.out.print(driver.runTimeConfusion());
	}
	catch(Exception e){
	System.out.println("Error parsing the input");	
	}

	
	//run balanceBracket
	System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<");
	System.out.println("BRACKET BALANCE");
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<");
	try{
	System.out.print(driver.runBalanceBracket());
	}
	catch(Exception e){
	System.out.println("Error parsing the input");	
	}


}
}
