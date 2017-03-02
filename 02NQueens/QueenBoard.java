import java.io.*;

public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    private int s;
    public int[][] temp;
    public char[][] toReturn;
    public boolean blank;
    public String sReturn;
    
    public QueenBoard(int size){
	board = new int[size][size];
	temp = new int[size][size];
	s = size;
	blank = false;
	solutionCount = -1;
    }

    public int getSize(){
        return s;
    }

    //----------------Adding/Removing Queens---------------

    private void addQueen(int r, int c){
	//System.out.println(r);
	//System.out.println(c);
	//System.out.println(temp.length);
	//System.out.println(temp[0].length);
	temp[r][c] = -1;
	//System.out.println("" + r + "," + c);
	//System.out.println("" + temp[r][c]);
	addThreats(r,c);
	
    }

    private void removeQueen(int r, int c){
	temp[r][c] = 0;
	removeThreats(r,c);
    }


    //----------------ExtrasHelpful---------------------------
    private boolean Placeable(int r, int c){
	//only need to check left side and left diagonals (upper and lower)

	//check side 
	for (; c < s-1 ; c++){
	    if ( temp[r][c+1] >= 1 || temp[r][c+1] == -1){
		//****	System.out.println("" + r + "," + c );
		return false;
	    }
	}
	
	//check upper right diagonal
	for (; r >= 0 && c < s && c >= 0; r--, c++){
	    if (temp[r][c] >= 1 || temp[r][c] == -1){
		return false;
	    }
	}
	
	//check lower right diagonal
	for (; r < s-1 && c < s; r++, c++){
	    if (temp[r][c] >= 1 || temp[r][c] == -1){
		return false;
	    }
	}
	return true;
	    
    }

    private void removeThreats(int r, int c){

	for (int n = 0 ; n < c; n++){
	    if (temp[r][n] >= 1){
	        temp[r][n] = temp[r][n] - 1;
	    }}
	
	//check upper right diagonal
	for (; r >= 0 && c < s; r--, c++){
	    if (temp[r][c] >= 1){
	        temp[r][c] = temp[r][c] - 1;
	    }}
	
	//check lower right diagonal
	for (; r < s-1 && c < s; r++, c++){
	    if (temp[r][c] >= 1){
	        temp[r][c] = temp[r][c] - 1;
	    }}
   
    }

    private void addThreats(int r, int c){
	for (int n = 0 ; n < c; n++){
	    //System.out.println("hello");
	    if (temp[r][n] >= 1){
	        temp[r][n] = temp[r][n] + 1;
	    }
	}
	
	//check upper right diagonal
	for (; r >= 0 && c < s; r--, c++){
	    //System.out.println("hi");
	    if (temp[r][c] >= 1){
	        temp[r][c] = temp[r][c] + 1;
		//****	System.out.println("" + r + "," + c);
	    }}
	
	//check lower right diagonal
	for (; r < s-1 && c < s; r++, c++){
	    //System.out.println("bye");
	    if (temp[r][c] >= 1){
	        temp[r][c] = temp[r][c] + 1;
	    }}
	//System.out.println("die");
    }

    
    
    //------------Solves--------------------------

    public boolean solve(){
	/*don't need this
	  if (solveH(0) == false){
	  System.out.println("No Solution");
	  return false;
	  }
	*/
	int col = 0;
	try{
	    for (;col < s-1; col++){
		if (solveH(col)){
		    solveH(col+1);}}
	}
	catch (ArrayIndexOutOfBoundsException e){
	    blank = true;
	    return false;
	}
	return true;
    }
    

    private boolean solveH(int col){

	//All Queens Placed
	if (col == s-1){
	    return true;
	}
	//	for (int c = col; c < s; col ++){
	for (int i = 0; i < s-1; i++){//loops through rows in this column
 
	    if (Placeable(i, col)){
		addQueen(i,col);
		System.out.println("Add Queen" + "/n" + sReturn);
		return solveH(col + 1);}//{
	    //System.out.println("" + col);
	    //  return true;
	    //	}
	        
	    removeQueen(i, col);
	    System.out.println("Remove Queen" + "/n" + sReturn);
	    //solveH(col);
		
		
	       
	}
			    
	return false;//if doesn't place anywhere
    }
    

    //------------SolutionCounting and Returning-----------------------



    public boolean countH(int col){
	//all Queens Placed
	if (col == s-1){
	    solutionCount++;
	}
	for (int i = 0; i < s; i++){//loops through rows in this column
	    if (Placeable(i, col)){
		addQueen(i,col);
		//	System.out.println("" + col);
		try{
		    countH(col + 1); 
		}
		catch (ArrayIndexOutOfBoundsException e){
		    System.out.println("" + col);
		    blank = true;
		    return false;
		}
   	        removeQueen(i, col);
	    }
	}
	return true;
    }

    public int getSolutionCount(){

	if (s == 2 || s == 3){
	    return 0;}
	else if (s == 1){
	    return 1;}
	else if (s > 3){
	    return solutionCount;}
	else {
	    return -1;
	}
	     
    }

    public String blankBoard(){
	toReturn = new char[s][s];
	for (int i = 0; i < s; i++){
	    sReturn = sReturn + "\n";
	    for (int j = 0; j < s; j++){
		sReturn = sReturn + "_ ";}
		
	}
	return sReturn;
    }
    
    public void countSolutions(){
	solutionCount = 0;
	int col = 0;
	for (;col < s; col++){
	    countH(col);
	}
   
	    
    }
 


    public String toString(){
	/*
	  if (blank = true){
	  return blankBoard();
	  }
	*/
	    
	toReturn = new String[s][s];
	//converting int[][] to char[][]
	for (int i = 0; i < s; i++){
	    for (int j = 0; j < s; j++){
		if (temp[i][j] == -1){
		    toReturn[i][j] = "Q";}
		else {
		    toReturn[i][j] = "_";}
	    }
	}
	    
	//returning info from char[][]
	for (int i = 0; i < s; i++){
	    sReturn = sReturn + System.lineSeparator();
	    for (int j = 0; j < s; j++){
		sReturn = sReturn + " " + toReturn[i][j];}}
	
	return sReturn;
    }
    
    public static void main (String [] args){
	QueenBoard x = new QueenBoard(8);
	System.out.println(x);
	x.solve();
	System.out.println(x);
	//	x.countSolutions();
	//	System.out.println(x.getSolutionCount());
    }
    

}
