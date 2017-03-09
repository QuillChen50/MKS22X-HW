import java.io.*;

public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    private int s;
    public char[][] toReturn;
    public String sReturn;
    
    public QueenBoard(int size){
	board = new int[size][size];
	s = size;
	solutionCount = -1;
    }

    public int getSize(){
        return s;
    }
    //Problem AREA should be here b/c Queens don't seem to be added (there's no -1
    //----------------Adding/Removing Queens---------------

    private void addQueen(int r, int c){
	board[r][c] = -1;
	

	for (int i = 0; (c+i < s) && (r+i < s); i++){
	    if ((r-i > 0) && !(board[r-i][c+i] == 1)){
		board[r-i][c+i] += 1;
		System.out.println("Results of Adding Threats" + board[r-i][c+i]);
	    }
	    if ((r+i < s) && !(board[r+i][c+i] == 1)){
		board[r+i][c+i] += 1;
		System.out.println("Results of Adding Threats" + board[r+i][c+i]);
	    }
	    if (board[r][c+i] == 1){
	    board[r][c+i] +=1;
	    System.out.println("Results of Adding Threats" + board[r][c+i]);
	    }

	}
	//System.out.println(this);
	printArray();

    }

    private void removeQueen(int r, int c){
	board[r][c] = 0;
	
for (int i = 0; (c+i < s) && (r+i < s); i++){
    if ((r-i > 0) && !(board[r-i][c+i] == -1) && (board[r-i][c+i] != 0)){
		board[r-i][c+i] = board[r-i][c+i]- 1;
		System.out.println("Result of Removing Threats" + board[r-i][c+i]);
	    }
	    if ((r+i < s) && !(board[r+i][c+i] == -1)  && (board[r+i][c+i] != 0)){
		board[r+i][c+i] = board[r+i][c+i] - 1;
		System.out.println("Result of Removing Threats" + board[r+i][c+i]);
	    }
	    if ((board[r][c+i] != -1)  && (board[r][c+i] != 0)){
	    board[r][c+i] =  board[r][c+i] - 1;
	    System.out.println("Result of Removing Threats" + board[r][c+i]);
	    }

	}
//printArray();
	
    }
    /*Not necessary
    public int calculateThreats(int r, int c){
	int result = 0;
for (int i = 0; (c+i < s) && (r+i < s); i++){
	    if ((r-i > 0) && !(board[r-i][c+i] == 1)){
	        result++;
	    }
	    if ((r+i < s) && !(board[r+i][c+i] == 1)){
	        result++;
	    }
	    if (!board[r][c+i] == 1){
		result++;
	    }
}
	    return result;

	
    }
    */


    //----------------ExtrasHelpful---------------------------
    private boolean Placeable(int r, int c){
	/*
	//only need to check left side and left diagonals (upper and lower)
	int a = r;
	int b = c;
	int d = r;
	int e = c;
	//check side 
	for (int n = 0; n < s ; n++){
	if ( board[r][n] >= 1 || board[r][n] == -1){
	System.out.println("side check: " + r + "," + n );
	return false;
	}
	}
	
	//check upper right diagonal
	for (; a >= 0 && b < s  ; a--, b++){
	if (board[a][b] >= 1 || board[a][b] == -1){
	System.out.println("up-right diagonal check: " + a + "," + b );
	return false;
	}
	}
	
	//check lower right diagonal
	for (; d < s && e < s; d++, e++){
	if (board[d][e] >= 1 || board[d][e] == -1){
	System.out.println("down-right diagonal check: " + d + "," + e );
	return false;
	}
	}
	return true;
	*/

	System.out.println(this);
	System.out.println(r);
	System.out.println(c);
	/* I made a very big mistake by looking for safe columns, rows, and diagonals
	for (int i = 1; c+i < s; i++){
	    
	    if ((r-i > 0) || (board[r-1][c+i] == -1) || (board[r-i][c+i] > 0){
		System.out.println('a');
		return false;
	    }
	    if ((r+1 < s-1) || (board[r+1][c+1] == -1)){
		System.out.println('b');
		return false;
	    }
	    if (board[r+1][c+1] == -1){
		System.out.println('c');
		return false;
	    }
	*/
	return (board[r][c] == 0);
	    
    }

    /* Old Functions, Repetitive
    private void removeThreats(int r, int c){
	//need to have a calculate threats method board[r][c] = ;
	
	for (int i = 0; (c+i < s) && (r+i < s); i++){
	    if ((r-i > 0) && (board[r-i][c+i] >= 0)){
		board[r-i][c+i] -= 1;
	    }
	    if ((r+i < s) && (board[r+i][c+i] >= 0)){
		board[r+i][c+i] -= 1;
	    }
	    if (board[r][c+i] >= 0){
	    board[r][c+i] -=1;
	    }

	}
	printArray();
	/*Inefficient Code

	  int a = r;
	  int b = c;
	  int d = r;
	  int e = c;
	  //change threst of right horizontal
	  for (int n = 0 ; n < c; n++){
	  //System.out.println("hello");
	  if (board[r][n] > 0){
	  board[r][n] = board[r][n] - 1;
	  }
	  }
	
	  //change threat status of upper right diagonal
	  for (; a >= 0 && b < s; a--, b++){
	  //System.out.println("hi");
	  if (board[a][b] > 0){
	  board[a][b] = board[a][b] - 1;
	  //****	System.out.println("" + r + "," + c);
	  }}
	
	  //change threat staus of lower right diagonal
	  for (; d < s-1 && e < s; d++, e++){
	  System.out.println("" + d + "," + e);
	  if (board[d][e] > 0){
	  board[d][e] = board[d][e] - 1;
	  }}
	  //System.out.println("die");
	  
	
    }

    private void addThreats(int r, int c){

	System.out.println("die");
	//more optimized version in progress
	System.out.println(this);
	//I accidentally used s-1
	board[r][c] = -1;
	for (int i = 0; (c+i < s) && (r+i < s); i++){
	    if ((r-i > 0) && (board[r-i][c+i] >= 0)){
		board[r-i][c+i] += 1;
	    }
	    if ((r+i < s) && (board[r+i][c+i] >= 0)){
		board[r+i][c+i] += 1;
	    }
	    if (board[r][c+i] >= 0){
	    //I accidentally used c instead of c+i
	    board[r][c+i] +=1;
	    }

	}
	System.out.println(this);
	printArray();
    }
    */

    
    
    //------------Solves--------------------------

    public boolean solve(){
	/*don't need this
	  if (solveH(0) == false){
	  System.out.println("No Solution");
	  return false;
	  }
	*/
	int col = 0;
	//	try{
	//	    for (;col < s-1; col++){
	return solveH(0);
	//	    solveH(col+1);}}
    }
    //		catch (ArrayIndexOutOfBoundsException e){
    //	    blank = true;
    //	    printArray();
    //	    return false;
        


    
    

    private boolean solveH(int col){

	//	for (int c = col; c < s; col ++){
	for (int i = 0; i < s-1; i++){//loops through rows in this column
	    System.out.println("" + i + "," + col );
	    if (Placeable(i, col)){
		System.out.println("Calling addQueens");
		//All Queens Placed
		if (col == s-1){
		    return true;
		}
		addQueen(i,col);
		//System.exit(0);
		printArray();
		solveH(col + 1);//{
		System.out.println("" + col);
		//  return true;
		//	}
	        

	    }
	    //solveH(col);
	    removeQueen(i,col);
	    printArray();
	    
	    //	    removeQueen(i, col);
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
		//	try{
		countH(col + 1);} 
	    //	}
	    //	catch (ArrayIndexOutOfBoundsException e){
	    //	    System.out.println("" + col);
	    //	    blank = true;
	    //	    return false;
	    //	}
	    removeQueen(i, col);
	    
	}
	return false;
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
	toReturn = new char[s][s];
	//converting int[][] to char[][]
	for (int i = 0; i < s; i++){
	    for (int j = 0; j < s; j++){
		if (board[i][j] == -1){
		    System.out.println("inside Q");
		    toReturn[i][j] = 'Q';}
		else {
		    toReturn[i][j] = '_';}
	    }
	}
	sReturn = "";
	//returning info from char[][]
	for (int i = 0; i < s; i++){
	    sReturn = sReturn + System.lineSeparator();
	    for (int j = 0; j < s; j++){
		sReturn = sReturn + " " + toReturn[i][j];}}
	
	return sReturn;
    }

    public void  printArray(){

	String result = "";
	String nresult = "";
	for (int i = 0; i < s; i++){
	    result = result + System.lineSeparator();
	    nresult = nresult +System.lineSeparator();
	    for (int j = 0; j < s; j++){
		if (board[i][j] == -1){
		    result = result + " " +  'Q';
		    nresult = nresult + " " + board[i][j];}
		else {
		    result = result + " " + '_';
		    nresult = nresult + " " + board[i][j];}
	    }
	    
	}
	System.out.println("" + result);
	System.out.println("" + nresult);
    }
	
    
    public static void main (String [] args){
	QueenBoard x = new QueenBoard(8);
	//System.out.println(x);
	x.solve();
	//	x.printArray();
	System.out.println(x);
	//	x.countSolutions();
	//	System.out.println(x.getSolutionCount());
    }
    

}
