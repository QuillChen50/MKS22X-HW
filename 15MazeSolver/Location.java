public class Location implements Comparable<Location>{

    private int row,col;
    private int distToGoal;
    private int distToStart ;
    private Location previous; //(used to trace the solution)
    private boolean aStar;
//when this is true, compareTo will use: distToStart + distToGoal
//when this is false, compareTo will use the distToGoalonly.
                   
     public Location(int r, int c, Location previous , int distToStart, int distToGoal, boolean aStar){
     row = r;
     col = c;
     this.previous = previous;
     this.distToStart = distToStart;
     this.distToEnd = distToEnd;
     this.aStar = aStar;

 }

    public Location getLocation(int row, int col){
     return this;
 }

    public int getrow(){
	int temp;
	temp = row;
	return temp;

    }

    public int getcol(){
	int temp;
	temp = col;
	return temp;

    }

    public int getdistToStart(){
	int temp;
	temp = distToGoal;
	return temp;

    }

    public int getdistToEnd(){
	int temp;
	temp = distToEnd;
	return temp;

    }

    public int getPrevious(){
	Location prev;
	prev = previous;
	return prev;

    }

    public int getaaStar(){
	boolean star;
	star =  astar;
	return star;

    }




     public int compareTo( Location other){
	 int sum1, sum2;
	 
	 if (aStar == true){
	     sum1 = this.getdistToStart + this.getdistToEnd;
	     sum2 = other.getdistToStart + other.getdistToEnd;
	     return compareH(sum1,sum2);
	     
	 }
	 //////////
	 else{
	     sum1 = this.getdistToEnd;
	     sum2 = other.getdistToEnd();
	 }
                  
}

    public int compareH(int sum1,int sum2){

	     if (sum1 = sum2){
		 return 0;
	     }
	     else if(sum1 > sum2){
		 return 1;
	     }
	     else {
		 return -1;
	     }
	     
}

    public static void main (String [] args){
	Location hi = new Location()
    }

}
