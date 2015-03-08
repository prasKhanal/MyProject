package pras.com.sparrowProblem.solutions;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 
 */

/**
 * @author pras_khanal
 *
 */
public class Spiral {
	
/**
 * This is only method which is visibile 
 * and used to calculate spiral values and returns 
 * list	
 * @param valueList
 * @return
 */
public static List<Integer> runSpiral (Map<String, String> valueList){
	int row,column,xPosition,yPosition;
	row=Integer.parseInt(valueList.get("row"));
	column=Integer.parseInt(valueList.get("column"));
	xPosition=Integer.parseInt(valueList.get("xPosition"));
	yPosition=Integer.parseInt(valueList.get("yPosition"));
	
	return runSpiral(row,column,xPosition,yPosition);
}

/**
 *This method will fill the ascending numerical value to the grid.
 * @param row
 * @param column
 * @return  grid
 */
private static int[][] getGrid(int row, int column) {
	int [][] grid= new int[row][column];
	for( int k=1,i=0;i<row; i++)
		for(int j=0;j<column; j++){
			grid[i][j]=k++;
		}
	
	return grid;
}
/**
 * 
 * @param row
 * @param column
 * @param xPosition
 * @param yPosition
 * @return
 */
 private static ArrayList<Integer> runSpiral(int row,int column,int xPosition, int yPosition){
	ArrayList<Integer> results = new ArrayList<Integer>();
	//solving position conflict betn argument and array
	 xPosition--;
	 yPosition--;
	 //creating temp value so that actual value cant be changed
	 int xTemp;
	 int yTemp;
	 Direction tempDirection;
    //grid creation
	 int [][] grid=getGrid(row,column);
	 //as first position value can be directly used
	 //adding it to result list and changing direction of pointer
	 //-1 is add to grid position of extracted value to know  
	 //it has already bean used or not
	 	 results.add(grid[xPosition][yPosition]);
		 grid[xPosition][yPosition]=-1;
		 Direction currentDirection=Direction.UP;

     //for  a loop is run untill the total number 
	//of grids element is filled in resultlists
	 while(results.size()!=row*column){
		 
	/*FIRST ATTEMPT:
	 * assigning value to temp variables and 
	 * changing horizontal or vertical values according to
	 * current direction 
	 * direction
	 */
	 tempDirection=currentDirection;
	 xTemp=xPosition;
	 yTemp=yPosition;
	 switch (tempDirection) {
		case UP:{
			xTemp--;
			break;
		}
		case LEFT:{
			yTemp--;
			break;
		}
		case DOWN:{
			xTemp++;
			break;
		}
		case RIGHT:{
			yTemp++;
			break;
		}
		}
	 //check weather position created by value exits in current grid
	 //if true change the temprory direction.
	 if(checkValidPosition(xTemp,yTemp,grid)){
		 tempDirection=changeDirection(currentDirection);
	 }
	 /*
	  * SECONT ATTEMPT:
	  * Other wise change the current temp position to original positions.
	  * If tempx and y are not  out of bound of rows and column size 
	  */
	 else if (xTemp<column&&yTemp<row&&xTemp>-1&&yTemp>-1){
		 xTemp=xPosition;
		 yTemp=yPosition;
	 /*
	  * Adjusting the current direction changed with straight 
	  * directional value.
	  * NOTE: In this switch statement,
	  * It is adjusted that the temp position will be changed
	  * according to previous tempDirectionnot the current one.
	  * For example:if the temp direction is TOP then positions will be changed
	  * according to RIGHT as RIGHT LEADS to TOP
	  */
		 switch (tempDirection) {
			case UP:
				yTemp++;
				break;
			case LEFT:
				xTemp--;
				break;
			case DOWN:
				yTemp--;
				break;
			case RIGHT:
				xTemp++;
				break;
			}
	 }
	/*
	 * check weather position created by value exits in current grid
	 * if not then new close accessible value has to be searched
    */
	 if(!checkValidPosition(xTemp,yTemp,grid)){
	 Object[] value=getNextPosition(xPosition,yPosition,grid,tempDirection);
	 xTemp=(Integer) value[0];
	 yTemp= (Integer) value[1];
	 tempDirection=(Direction) value[2];
	 
	 }
	 /*
	  * Now, finally all the temporary value are used ase actual value
	  * and the grid value of the x,y positions is added to result
	  * and that grid position is made -1. 
	  */
	 if(checkValidPosition(xTemp,yTemp,grid)){
		 xPosition=xTemp;
		 yPosition=yTemp;
		 results.add(grid[xPosition][yPosition]);
		 grid[xPosition][yPosition]=-1;
		 currentDirection=tempDirection;
	 
	 }
	 }
	 //end of loop
	 
	return results; 
 }


/**
 * @param xTemp
 * @param yTemp
 * @param grid
 * @return
 */
private static boolean checkValidPosition(int xTemp, int yTemp, int[][] grid) {
	try{
		return (grid[xTemp][yTemp]!=-1);
	}
	catch(Exception e){
		 return false;
	}
}


/**
 * This Method change the current direction
 * to anti clockwise direction
 * @param currentDirection
 */
private static Direction changeDirection(Direction tempDirection) {
	Direction newDirection = null;
   switch(tempDirection){
	case UP:{
		newDirection=Direction.LEFT;
    	 break;
    	 }
	case RIGHT:{
		newDirection=Direction.UP;
    	 break;
    	 }
	case LEFT:{
		newDirection=Direction.DOWN;
    	 break;
	}
	case DOWN:{
		newDirection=Direction.RIGHT;
    	 break;
    	 }
   }
   return newDirection;
}
/**
 * If changing direction anticlockwiseily or going straight 
 * is not valid then this method will jump the positions and find the
 * most favourable anticlockwise position in the grid.
 * @param x
 * @param y
 * @param grid
 * @param tempDirection
 * @return An object array containing of avaliable x and y positions with 
 *         next direction it should point 
 */

private static Object[] getNextPosition(int x, int y, int[][] grid,
		Direction tempDirection) {
	//
	boolean check=false;
	int xTemp, yTemp;
	int i=0;
	while(!check){
		if(i>1000) System.exit(0);
		xTemp=x;
		yTemp=y;
		 switch (tempDirection) {
			case UP:{
				xTemp--;
				break;
			}
			case LEFT:{
				yTemp--;
				break;
			}
			case DOWN:{
				xTemp++;
				break;
			}
			case RIGHT:{
				yTemp++;
				break;
			}
		 }
		 
		
			try{
				/*
				 * if sucessfully new position found then temp position are changed to actual 
				 * position for value return. is set and value to end loop is also set.
				 * 
				 * Else loop  re-runs.
				 * 
				 * However, if any exception happens then the current temp direction is changed.
				 * 
				 */
		        
				if(grid[xTemp][yTemp]!=-1) check=true;
				x=xTemp;
				y=yTemp;
			}
			catch(Exception e){
			 tempDirection=changeDirection(tempDirection); 
			}
			i++;
			 }
	Object[] rtnValue={x,y,changeDirection(tempDirection)};
	return rtnValue;
		}

/*
 * Nested enum class to provide values of direction
 * which can be used for comparisions
 */
public enum Direction{
	UP,DOWN,LEFT,RIGHT
}
	


}

