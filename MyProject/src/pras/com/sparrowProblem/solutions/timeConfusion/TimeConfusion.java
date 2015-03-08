package pras.com.sparrowProblem.solutions.timeConfusion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */

/**
 * @author pras_khanal
 *
 */
public class TimeConfusion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
   try {
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   System.out.print("Please enter the number of input:\n");
   int number=Integer.parseInt(br.readLine().trim());
   StringBuffer buff=new StringBuffer();
   while(number>0){
	    String input=br.readLine().trim();
	    if(input.equals("")) continue;
	   Time time=solveConfusion(createTimeList(input));
	   if(time==null)
		   buff.append("Look at the sun.\n");
	   else
		   buff.append("The correct time is  "+time+"\n");
	   number--;
	   }
   br.close();
   System.out.print(buff.toString());
   }
   catch (IOException e) {
	   e.printStackTrace();
	   }
   }
	public static String solveconfusion( List<String> list){
	 StringBuffer buff=new StringBuffer();
	 Iterator<String> iterator=list.iterator();
	 while(iterator.hasNext()){
		 Time time=solveConfusion(createTimeList(iterator.next()));
		   if(time==null)
			   buff.append("Look at the sun.\n");
		   else
			   buff.append("The correct time is  "+time+"\n");
		  
		   }
	 	return buff.toString();
	}
	/**
	 * This Method take String as input and converts 
	 * string into 3 Time objects and returns it as a list
	 * @param input
	 * @return Time objects
	 */
	private static List<Time> createTimeList(String input) {
	StringTokenizer tokens=new StringTokenizer(input," :",false);
	List<Time> timeList=new ArrayList<Time>();
	
	while(tokens.hasMoreTokens()){
		int hour=Integer.parseInt(tokens.nextToken().trim());
		int minute=Integer.parseInt(tokens.nextToken().trim());
		Time time =new Time(hour,minute);
		timeList.add(time);
	}
	return timeList;
	}
	/**
	 * This methods compares each Time object among three 
	 * with other two and return the Time object which is 
	 * perfectly in between other Two.
	 * @param timeList
	 * @return
	 */
	private static Time solveConfusion(List<Time> timeList){ 
	int i=0;
	while(i<3){
		//here from i two other integer k and j is created.
		//so that every time there will be three integer with value
		//0,1,2 for comparing the Time object
		int j=i+1;
		if(j>2) j=j-3;
		int k=i+2;
		if(k>2) k=k-3;
		/*
		 * Here three Time object is difference is compaired with one another
		 * in serial order For example: say Time object A is compaired to B and 
		 * C is compaired to A putting A in middle both compatision produces Time objects
		 * If the produced Time objects are equal then A is returned.
		 * Like wise it is done for C and D as well.
		*/
		if(timeList.get(i).compareTimeDifference(timeList.get(j))
				.equals(timeList.get(k).compareTimeDifference(timeList.get(i))) 
				||
				timeList.get(j).compareTimeDifference(timeList.get(i))
				.equals(timeList.get(i).compareTimeDifference(timeList.get(k)))){
			return timeList.get(i);
		}
		else i++;
		}
	return null;
	
	
}

}
