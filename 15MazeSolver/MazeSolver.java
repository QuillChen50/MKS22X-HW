/*5. MazeSolver

  5a constructors:
  MazeSolver(String filename) : filename - input name of the maze file.
  MazeSolver(String filename, boolean animate) : filename - input name of the maze file, animate - true for animating your maze.

  5b public methods:
  solve() - call solve(1)
  solve(int style) - style is 0-4, where 0-DFS, 1-BFS,2-BestFirst, 3-A*
  This method will instantiate the Frontier based on which style was chosen. 
  It will then add the starting location of the maze to the Frontier.
  Finally it will process each subsequent element of the frontier until the end is found. 


  toString() - the toString of the maze instanceVariable.

  addToFrontier - change the maze to a '?'
*/

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import javax.swing.JFileChooser;


public class MazeSolver{

    public int ey, ex, sy, sx;
    public boolean move;

    public MazeSolver(String filename){
	char[][] maze = Helper(filename);
	move = false;

    }

    public MazeSolver(String filename, boolean animate){
	char[][] maze = Helper(filename);

	if (animate == true)
	    move = true;
	move = false;
	
	


    }

    public char[][] Helper(String filename) throws IOException{
	char[] maze;
	char[][] temp;

	List<String> lines = Files.readAllLines(Paths.get(filename));
	//created array of array
	for (int i = 0; i < lines.size(); i++) {
	    maze[i] = lines.get(i).toCharArray();
	}
	//create 2D Array
	for(int i = 0;i < maze.length;i++, num++){
		temp[i][num] = ch[i];
		if (temp[i][num] = 'E'){
		    ey = num;
		    ex = i;
		}
		if (maze[i][num] = 'S'){
		    sy = num;
		    sx = i;
		}
	}	
	return temp;
    }



public void printMaze() {
    for (char[] row:maze) {
	for (char c:row) 
	    System.out.print(c);
	System.out.println();
    }
}

    public String toString(){
StringBuilder sb = new StringBuilder();
    for (char[] row:maze) {
	sb.append("\r\n");
	for (char c:row) 
	    sb.append ("" + c);
    }

    sb.toString();

    }

    public static void main (String [] args){


    }






}
