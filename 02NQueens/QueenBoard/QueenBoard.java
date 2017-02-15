import java.io.*;

public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    private int s;
    public int[][] temp;
    public char[][] toReturn;
    
    public QueenBoard(int size){
	board = new int[size][size];
	temp = new int[size][size];
	s = size;
    }

    public int getSize(){
        return s;
    }

    //----------------Adding/Removing Queens---------------

    private void addQueen(int r, int c){
	temp[r][c] = -1;
	addThreats(r,c);
    }

    private void removeQueen(int r, int c){
	temp[r][c] = 0;
	removeThreats(r,c);
    }


    //----------------ExtrasHelpful---------------------------
    private boolean Placeable(int r, int c){
	//only need to check left side and left diagonals (uperp and lower)
	int i = r;
	int j = c;
	int k = r;
	int l = c;

	//check side
	for (int n = 0 ; i < col; i++){
	    if (temp[r][n] >= 1 || temp[r][i] == -1){
		return false;
	    }}
	
	//check upper left diagonal
	for (; i >= 0 && j >= 0; i--, j--){
	    if (temp[i][j] >= 1 || temp[i][j] == -1){
		return false;
	    }}
	
	//check lower left diagonal
	for (; k < s && l >= 0; k++, l--){
	    if (temp[i][j] >= 1 || temp[i][j] == -1){
		return false;
	    }}
	return true;
	    
    }

    private void removeThreats(int r, int c){
	int i = r;
	int j = c;
	int k = r;
	int l = c;

	for (int n = 0 ; i < col; i++){
	    if (temp[r][n] >= 1){
	        temp[r][n] = temp[r][i] - 1;
	    }}
	
	//check upper left diagonal
	for (; i >= 0 && j >= 0; i--, j--){
	    if (temp[i][j] >= 1){
	        temp[i][j] = temp[i][j] - 1;
	    }}
	
	//check lower left diagonal
	for (; k < s && l >= 0; k++, l--){
	    if (temp[i][j] >= 1){
	        temp[i][j] = temp[i][j] - 1;
	    }}
   
    }

    private void addThreats(int r, int c){
	int i = r;
	int j = c;
	int k = r;
	int l = c;

	for (int n = 0 ; i < c; i++){
	    if (temp[r][n] >= 0){
	        temp[r][n] = temp[r][i] + 1;
	    }}
	
	//check upper left diagonal
	for (; i >= 0 && j >= 0; i--, j--){
	    if (temp[i][j] >= 0){
	        temp[i][j] = temp[i][j] + 1;
	    }}
	
	//check lower left diagonal
	for (; k < s && l >= 0; k++, l--){
	    if (temp[i][j] >= 0){
	        temp[i][j] = temp[i][j] + 1;
	    }}
   
    }

    
    
    //------------Solves--------------------------

    public boolean solve(){

	if (solveH(0) == false){
	    System.out.println("No Solution");
	    return false;
	}
	
	return solveH(0);
    }
    

    private boolean solveH(int col){
	//Base Cases
	
	//all Queens Placed
	if (col >= s){
	    return true;}

	for (int i = 0; i < s; i++){//loops through rows in this column
	    if (Placeable(i, col)){
		addQueen(i,col);
		if (solveH(col + 1) == true){
		    return true;}
		    removeQueen(i, col);
		}
	    }		    
	    return false;//if doesn't place anywhere
    }

//------------SolutionCounting and Returning-----------------------
    public void countSolutions(){
	countH(0);
    }


	public boolean countH(int col){
	    solutionCount = -1;
	    //all Queens Placed
	if (col >= s){
		solutionCount++;}
	for (int i = 0; i < s; i++){//loops through rows in this column
	    if (Placeable(i, col)){
		addQueen(i,col);
		if (countH(col + 1) == true){
		    }
		    removeQueen(i, col);
		}
	    }
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


	public String toString(){
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
	    

}
