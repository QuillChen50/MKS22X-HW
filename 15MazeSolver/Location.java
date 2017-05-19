public class Location implements Comparable<Location>{

 private int row,col
 private int distToGoal
 private int distToStart 
     private Location previous //(used to trace the solution)
     private boolean aStar 
//when this is true, compareTo will use: distToStart + distToGoal
//when this is false, compareTo will use the distToGoalonly.
                   

     public Location(int r, int c, Location previous , int distToStart, int distToGoal, boolean aStar){

 }

 public getLocation(int row, int col){

 }




     public int compareTo( Location other){

 }
                  
}
