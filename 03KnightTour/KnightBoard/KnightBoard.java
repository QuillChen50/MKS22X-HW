import java.text.DecimalFormat

public class KnightBoard{
    private int[][] board;
    private int index;
    private int finalNum;
    
    
    public KnightBoard(int startingRows,int startingCols){
	solution = new int [startingRows][startingCols];
	for (int i = 0; i < N; i++){
	   for (int j = 0; j < N; i++){ 
	       board[i][j] = 0;
	   }
	}
	finalNum = board.length;
    }
	    

	public String toString() //blank if you never called solve or when there is no solution

	public void solve(){

	    if (solveH(0,0,0)){
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
		// move down and right
		if (safeH(r + 2, c + 1)
				&& findH(r + 2, c + 1, level + 1)) {
			return true;
		}
		// move right and down
		if (safeH(r + 1, c + 2)
				&& findH(r + 1, c + 2, level + 1)) {
			return true;
		}
		// move right and up
		if (safeH(r - 1, c + 2)
				&& findH(r - 1, c + 2, level + 1)) {
			return true;
		}
		// move up and right
		if (safeH(r - 2, c + 1)
				&& findH(r - 2, c + 1, level + 1)) {
			return true;
		}
		// move up and left
		if (safeH(r - 2, c - 1)
				&& findH(r - 2, c - 1, level + 1)) {
			return true;
		}
		// move left and up
		if (safeH(r - 1, c - 2)
				&& findH(r - 1, c - 2, level + 1)) {
			return true;
		}

		// move down and left
		if (safeH(r + 2, c - 1)
		    && legal(r + 2, c - 1, level + 1)) {
			return true;
		}

	        // move left and down
		if (safeH(r + 1, c - 2)
				&& findH(r + 1, c - 2, level + 1)) {
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
    if (col >= 0 && col < finalNum && row >= 0 && r < finalNum){
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
