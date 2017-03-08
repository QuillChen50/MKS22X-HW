public class Maze{

    private char[][]maze;
    private boolean animate;
    public int start;
    public int end;
    public String asString;
    public int totr;
    public int totc;
    public int ex;
    public int ey;
    public int sx;
    public int sy;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename)throws IOException{
	//Will come back to study txt file reading specifically
	BufferedReader read = new BufferedReader(new FileReader(filename.getSelectedFile()));
	String rea = read.readLine();
	String[] s = rea.s(" ");
	width =  Integer.valueOf(s[0]);
	totc = width - 1;
	height = Integer.valueOf(s[1]);
	totr = height - 1;
	asString = "";

	String readline;
	int num = 0;
	maze = new char[width][height];
	while((readline = read.readLine()) != null){
	    char[] ch = readline.toCharArray();
	    for(int i = 0;i < ch.length;i++){
		maze[i][num] = ch[i];
		if (maze[i][num] = 'E'){
		    ey = num;
		    ex = i;
		}
		if (maze[i][num] = 'S'){
		    sy = num;
		    sx = i;
		}
	    }
	    num++;
	}
        //COMPLETE CONSTRUCTOR

	/* The Alternative Way
	   BufferedReader input;
	   String line;
	   StringTokenizer tokenizer;
 
	   nRows = 0;
	   try {
	   int currentRow = 0;
	   input = new BufferedReader(new FileReader(filename));
	   while ((line = input.readLine()) != null) {
	   if (nRows == 0) {  // true if reading first line in file, containing   nRows nColums
	   tokenizer = new StringTokenizer(line);
	   nRows = Integer.parseInt(tokenizer.nextToken());
	   nCols = Integer.parseInt(tokenizer.nextToken());
	   maze = new char[nRows][nCols];
	   } else if (line.length() == 1) 
	   break; // in case there is a linefeed at end of file
	   else {
	   for (int c = 0; c < nCols; c++) {
	   maze[currentRow][c] = line.charAt(c);
	   }
	   currentRow ++;
	   }
	   }
	   }
	   catch (IOException e) {
	   throw new MazeException("Problem reading maze file " + filename);
	   }
	*/
	
    }
    
    private void wait(int millis){ //ADDED SORRY!
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
	final static String ESC = "\033[";
	System.out.print(ESC + "2J"); 
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	int startr=-1,startc=-1;
	//Initialize starting row and startint col with the location of the S. 
	maze[startr][startc] = ' ';//erase the S, and start solving!
	return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
      The S is replaced with '@' but the 'E' is not.
      All visited spots that were not part of the solution are changed to '.'
      All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }

	if (x == ex  && y == ey ){ return true;} // If you reached the end
	if (maze[x][y] == 2 || wasHere[x][y]) {return false;}  
	// If you are on a wall or already were here
	wasHere[x][y] = true;
	
	if(validMove(x, y)){
	    if(atEnd(x, y)) {
		// Mark the exit
		maze[y][x] = 'E';
		return true;
	    }else {
		// Mark that we moved here
		maze[y][x] = '.';

		if(  solve(x+1, y) ||  //Move right
		     solve(x, y+1) || //Move down
		     solve(x-1, y) ||  //Move left
		     solve(x, y-1)) {  //Move up
		    // The exit was found and so this location is a part of the path
		    maze[y][x] = '@';
		    return true;
		}
	    }
	}

    //COMPLETE SOLVE
    return false; //so it compiles
}

public  boolean validMove(int x, int y) {
    // Within the maze bounds?
    if(y < 0 || x < 0 || y >= maze.length || x >= maze[y].length)
        return false;
    // In a wall or where we have been?
    if(maze[y][x] == 'X' || maze[y][x] == 'V')
        return false;

    return true;
}

public boolean atEnd(int curX, int curY) {
    return (curX == end[X] && curY == end[Y]);
}

private void printMaze() {
    for (char[] row:maze) {
	for (char c:row) System.out.print(c);
	System.out.println();
    }
}

public String convert(char c, char[][] array) {
    String result = "";
    for (int i = 0; i < r; r++) {
	for (int j = 0; j < c; c++){
	    result = result + maze[i][j];
        
	}
    }
    asString = result;
    return result;
}

}
