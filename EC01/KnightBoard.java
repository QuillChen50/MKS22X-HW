
public class KnightBoard{
    private int[][] board;
    private int rows;
    private int cols;
    private boolean worked;


    
    
    
    public KnightBoard(int startingRows,int startingCols){
        board = new int [startingRows][startingCols];
	rows = startingRows;
	cols = startingCols;
	worked = true;

	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){	
		board[i][j] = 0;
	    }
	}
    }
	    
	    

    public void solveFast(){
	int eooR = rows%2;
	int eooC = cols%2;
	

	    try {
		solveH(0,0,1);
		    }
	    catch (ArrayIndexOutOfBoundsException e){
		worked = false;
		System.out.println("No Path Found or No Solution");
	    }
	    /*
     if ( (eooR == 1 && eooC  == 1)
	     || ( rows == 1 || rows == 2 || rows == 4)
	     || ((rows == 3) && (cols == 4 || cols == 6 || cols == 8))
	  || (worked = false)
	     ){ 
	//  if (solveH(0,0,1)){
	//	printBoard();}
	      printBlankBoard();
	}
	    */
	    if (solveH(0,0,1) && worked){  
	printBoard();
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
	try{
	if (board[r][c] != 0) {
	    return false;
	}
	}
	catch (ArrayIndexOutOfBoundsException e){
	    worked = false;
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

	try{
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
	}
	catch(ArrayIndexOutOfBoundsException e){
	    System.out.println ("No solution or invalid Board or solve wasn't run");
	    return printBlankBoard();
	}

	if (worked = false){
	    return printBlankBoard();
	}
	else {
	
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
    }
    
    public String printBlankBoard(){
	String result = "";
	for ( int i = rows; i > 0; i-- ){
	    result = result + "\n";
	}
	return result;
    }
	    
	

    public String toString(){ //blank if you never called solve or when there is no solution
	try {
	    printBoard();
		    }
	    catch (ArrayIndexOutOfBoundsException e){
		printBlankBoard();
	    }

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
	n.solveFast();
	System.out.println(n);

	KnightBoard m;
	m = new KnightBoard (8,8);
	m.solveFast();
	System.out.println(m);

	KnightBoard p;
	p = new KnightBoard (0,0);
	p.solveFast();
	System.out.println(p);

	KnightBoard q;
	q = new KnightBoard (2,1);
	q.solveFast();
	System.out.println(q);

	KnightBoard r;
	    r = new KnightBoard (20,20);
	r.solveFast();
	System.out.println(r);
    }	    



	
}
