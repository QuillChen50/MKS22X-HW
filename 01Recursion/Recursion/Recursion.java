public class Recursion{
    
 public static String name(){
     return "Chen,Jenny";}
    
    public static double sqrt(double n){
	if (n < 0) { //exception
	    try{}
            catch (IllegalArgumentException e) { 
		System.out.println("Cannot Take SquareRoote of negative.");
		return -1;}
	}
	return helper(n, n/2);
	}}
	
    
	public static double helper (double n, double guess){

	    if (n == 0 || n == 1){
		return n;
	    }
        
	    if (Math.abs(Math.pow(guess, 2) - n) < 0.0001){
		return guess;}

	    else{
		double bGuess = (n/guess + guess)/2
		return helper(n, bGuess);}
	}

    public static void main (String args[]){
	System.out.println("sqrt of 0 should be 0, ?= " + sqrt(0));
	System.out.println("sqrt of 0 should be 1, ?= " + sqrt(1));
	System.out.println("sqrt of 25 should be 5, ?= " + sqrt(25));
	System.out.println("sqrt of 2 should be 1.414, ?= " + sqrt(2));
	System.out.println("sqrt of -25 should be IllegalArgumentException, ?= " + sqrt(5));
    }
}
