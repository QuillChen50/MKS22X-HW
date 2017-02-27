import java.text.DecimalFormat;

public class KnightBoard{
    private int[][] board;
    private int index;
    private int finalNum;
    private int rows;
    private int cols;
    private int startingrow;
    private int startingcol;
    
    
    
    public KnightBoard(int startingRows,int startingCols){
        board = new int [startingRows][startingCols];
	finalNum = board.length;
	rows = startingRows;
	cols = startingCols;

	for (int i = 0; i < finalNum; i++){
	   for (int j = 0; j < finalNum; i++){ 
	       board[i][j] = 0;
	   }
	}
    }
	    

    public String toString(){ //blank if you never called solve or when there is no solution
	if (solveH() != true){
	    return toStringH();}
	else {
	    return printBoard();
	}
    }

	public String toStringH(){
	    finalNum = board.length;
	    String result = "";
	    n == 0
	    while (n < finalNum){
		if (n%cols == 0){
		    result = result + System.lineSeparator() + " " + "__";
		}
		    else{
		result = result + " " + "__";
		    n++;
		    }
	   }
	    return result;
	}
	    

	public void solve(){

	    if (solveH(startingrow,startingco,0)){
		printBoard();}
	    else (
		  System.out.println("No Path Found");
		  }
	}
	    
		
	}

        private boolean solveH(int r ,int c, int level){ // level is the # of the knight

	    //base cases
	        // current square shouldn't be in use 
		if (Board[r][c] != 0) {
			return false;
		}
		// mark the current cell  as used
	        Board[r][c] = index++;
		// if (index == 50) {
		if (level == finalNum) {
			// When reach finalNum, we have solved it successfully
			return true;
		}

		
		// Possible Moves [recursive]
		//experiment with which moves going first would allow fastest 




		// move down and left
		if (safeH(r + 2, c - 1)
		    && legal(r + 2, c - 1, level + 1)) {
			return true;
		}

	        // move left and down
		if (safeH(r + 1, c - 2)
				&& legal(r + 1, c - 2, level + 1)) {
			return true;
		}

	        // move left and up
		if (safeH(r - 1, c - 2)
				&& legal(r - 1, c - 2, level + 1)) {
			return true;
		}

	        // move up and left
		if (safeH(r - 2, c - 1)
				&& legal(r - 2, c - 1, level + 1)) {
			return true;
		}

	        // move up and right
		if (safeH(r - 2, c + 1)
				&& findH(r - 2, c + 1, level + 1)) {
			return true;
			
		}

	        // move right and up
		if (safeH(r - 1, c + 2)
				&& legal(r - 1, c + 2, level + 1)) {
			return true;
					}
	        // move right and down
		if (safeH(r + 1, c + 2)
				&& legal(r + 1, c + 2, level + 1)) {
			return true;
		}

		// move down and right
		if (safeH(r + 2, c + 1)
				&& legal(r + 2, c + 1, level + 1)) {
			return true;
		}

		
		// if we are here means nothing has worked , backtrack
		else{
	        Board[r][c] = 0;
		index--;
		return false;
		}

	
	}

//a repeated step is checking to make sure the night is still on the board

public boolean legal(int r, int c){
    if (c >= 0 && c < finalNum && r >= 0 && r < finalNum){
	return true;}
    else{
	return false;
    }
}


    public void printBoard(){
	   DecimalFormat twodigits = new DecimalFormat("00");
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				System.out.print("   " + twodigits.format(solution[i][j]));
			}
			System.out.println();
		}
    }
	
	    



	
	}
