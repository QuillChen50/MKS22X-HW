
public class KnightBoard{
    private int[][] board;

    
    
    
    public KnightBoard(int startingRows,int startingCols){
        board = new int [startingRows][startingCols];


	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){	
		board[i][j] = 0;
	    }
	}
    }
	    
	    

    public void solve(){

	if (solveH(0,0,1)){
	    printBoard();}
	else {
	    System.out.println("No Path Found");
	}
    }

        //a repeated step is checking to make sure the night is still on the board

    public boolean legal(int r, int c){
        return board.length > r && board[0].length > c && r >= 0 && c >= 0;
    }
	    
    private boolean solveH(int r ,int c, int level){ // level is the # of the knight

	//base cases
	// current square shouldn't be in use
	//System.out.println("" + r + " " +c);
	
	if (board[r][c] != 0) {
	    return false;
	}

	board[r][c] = level;

	
	// if (index == 50) {
	if (level == board.length*board[0].length) {
	    // When reach finalNum, we have solved it successfully
	    return true;
	}

		
	// Possible Moves [recursive]
	//experiment with which moves going first would allow fastest 




	// move down and left
	if (legal(r + 2, c - 1)
	    && solveH(r + 2, c - 1, level + 1)) {
	    return true;
	}

	// move left and down
	if (legal(r + 1, c - 2)
	    && solveH(r + 1, c - 2, level + 1)) {
	    return true;
	}

	// move left and up
	if (legal(r - 1, c - 2)
	    && solveH(r - 1, c - 2, level + 1) ) {
	    return true;
	}

	// move up and left
	if (legal(r - 2, c - 1)
	    && solveH(r - 2, c - 1, level + 1)) {
	    return true;
	}

	// move up and right
	if (legal(r - 2, c + 1)
	    && solveH(r - 2, c + 1, level + 1)) {
	    return true;
			
	}

	// move right and up
	if (legal(r - 1, c + 2)
	    && solveH(r - 1, c + 2, level + 1)) {
	    return true;
	}
	// move right and down
	if (legal(r + 1, c + 2)
	    && solveH(r + 1, c + 2, level + 1)) {
	    return true;
	}

	// move down and right
	if (legal(r + 2, c + 1) 
	    && solveH(r + 2, c + 1, level + 1)) {
	    return true;
	}

		
	// if we are here means nothing has worked , backtrack
       
	board[r][c] = 0;
	//level-- not necessary b/c already ending, and will just go back 
	return false;

    }



    public String printBoard(){
	int bDigits = (""+board.length* board[0].length).length();
	String result = "";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board.length; j++) {
		int cDigit = (""+board[i][j]).length();
		for (int c = cDigit; c < bDigits; c++){
		    result += " ";
		}
		result += board[i][j] + " ";
	    }
	    result = result + "\n";
	}
	return result;
    }

    public String toString(){ //blank if you never called solve or when there is no solution
	    return printBoard();
    }

    /*
    public String toStringH(){
	finalNum = board.length;
	String result = "";
	int n = 0;
	while (n < finalNum){
	    if (n%cols == 0){
		result = result + "\n" + " " + "__";
		n++;
	    }
	    else{
		result = result + " " + "__";
		n++;
	    }
	}
	return result;
    }
    */
	
    public static void main (String [] args){
	KnightBoard n;
	n = new KnightBoard (7,7);
	n.solve();
	System.out.println(n);
    }	    



	
}
