public class Recursion{
    
 public static String name(){
     return "Chen,Jenny";}
    
    public static double sqrt(double n){

	return helper(n, n/2);
	}
	
    
	public static double helper (double n, double guess){

	    	if (n < 0) { //exception
		throw new IllegalArgumentException("Cannot Take SquareRoote of negative.");
		}
	    if (n == 0 || n == 1){
		return n;
	    }

	    if (close(n, guess)){
		return guess;}

	    else{
		return helper(n, improveGuess(n,guess));}
	}

	    public static boolean close(double n, double g){
		double a = n/g;
		return (Math.abs(a - g) < .0000001);
	    }

	    public static double improveGuess(double n, double guess){
		return ((n/guess + guess)/2);
	    }

    public static void main (String args[]){
	System.out.println("sqrt of 0 should be 0, ?= " + sqrt(0));
	System.out.println("sqrt of 0 should be 1, ?= " + sqrt(1));
	System.out.println("sqrt of 25 should be 5, ?= " + sqrt(25));
	System.out.println("sqrt of 2 should be 1.414, ?= " + sqrt(2));
	System.out.println("sqrt of -25 should be IllegalArgumentException, ?= " + sqrt(5));
    }
}
