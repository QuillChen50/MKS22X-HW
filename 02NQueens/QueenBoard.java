import java.io.*;

public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    private int s;
    public int[][] temp;
    public char[][] toReturn;
    public boolean blank;
    
    public QueenBoard(int size){
	board = new int[size][size];
	temp = new int[size][size];
	s = size;
	blank = false;
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
		System.out.println("" + r + "," + c );
		return false;
	    }
	}
	
	//check upper right diagonal
	for (; r >= 0 && c < s-1 && c >= 0; r--, c--){
	    if (temp[r-1][c+1] >= 1 || temp[r-1][c+1] == -1){
		return false;
	    }
	}
	
	//check lower right diagonal
	for (; r < s-1 && c < s-1; r++, c++){
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
	for (; r > 0 && c < s-1; r--, c++){
	    if (temp[r][c] >= 1){
	        temp[r][c] = temp[r][c] - 1;
	    }}
	
	//check lower right diagonal
	for (; r < s-1 && c < s-1 ; r++, c++){
	    if (temp[r][c] >= 1){
	        temp[r][c] = temp[r+1][c+1] - 1;
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
	for (; r > 0 && c < s-1; r--, c++){
	    //System.out.println("hi");
	    if (temp[r][c] >= 1){
	        temp[r][c] = temp[r][c] + 1;
		System.out.println("" + r + "," + c);
	    }}
	
	//check lower right diagonal
	for (; r < s-1 && c < s-1 ; r++, c++){
	    //System.out.println("bye");
	    if (temp[r][c] >= 1){
	        temp[r][c] = temp[r+1][c+1] + 1;
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
	try{
	return solveH(0);
	}
	catch (ArrayIndexOutOfBoundsException e){
	    blank = true;
	    return false;
	}
    }
    

    private boolean solveH(int col){
	//Base Cases
	
	//all Queens Placed
	if (col == s-1){
	    return true;
	}
	//	for (int c = col; c < s; col ++){
	for (int i = 0; i < s; i++){//loops through rows in this column
	    if (Placeable(i, col)){
		addQueen(i,col);
		if (solveH(col + 1)){
		    return true;
		}
		else { 
		    removeQueen(i, col);
		}
		
		//	}
	    }
	}		    
	return false;//if doesn't place anywhere
    }
    

//------------SolutionCounting and Returning-----------------------
    public void countSolutions(){
	solutionCount = -1;
	countH(0);
    }


	public boolean countH(int col){
	    //all Queens Placed
	if (col == s-1){
		solutionCount++;}
	for (int i = 0; i < s; i++){//loops through rows in this column
	    if (Placeable(i, col)){
		addQueen(i,col);
		//	try{
			    countH(col + 1); 
			    //	}
			    //	catch (ArrayIndexOutOfBoundsException e){
			    //   blank = true;
			    //  return false;
			    //	}
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
	    String sReturn = "";
	    for (int i = 0; i < s; i++){
		sReturn = sReturn + "\n";
		for (int j = 0; j < s; j++){
		    sReturn = sReturn + "_ ";}
		
	    }
	    return sReturn;
	}

 


	public String toString(){

	    if (blank = true){
		return blankBoard();
	    }
	    
	    toReturn = new char[s][s];
	    String sReturn = "";
	    //converting int[][] to char[][]
	    for (int i = 0; i < s; i++){
		for (int j = 0; j < s; j++){
		    if (temp[i][j] == -1){
			toReturn[i][j] = 'Q';}
		    else {
			toReturn[i][j] = '_';}
		}
	    }
	    
	    //returning info from char[][]
	    for (int i = 0; i < s; i++){
		sReturn = sReturn + System.lineSeparator();
		for (int j = 0; j < s; j++){
		    sReturn = sReturn + " " + toReturn[i][j];}}
	
	    return sReturn;
	}
    /*
    public static void main (String [] args){
	QueenBoard x = new QueenBoard(7);
	x.solve();
	System.out.println(x);
	x.countSolutions();
	System.out.println(x.getSolutionCount());
    }
    */

}
