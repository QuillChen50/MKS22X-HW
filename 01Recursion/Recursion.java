mpublic class Recursion{
    
    public double TakeSqRtOf = 0;
    
 public static String name(){
     return "Chen,Jenny";}
    
    public static double sqrt(double n){
	TakeSqRtOf = n;
	if (n < 0) { //exception
	    try{}
            catch (IllegalArgumentException e) { 
		System.out.println("Cannot Take SquareRoote of negative.");}

    else {
	return helper(n, n/2);}
}
	
    
	public float helper (double n, double guess){
	        double oGuess = guess
        
	    if (Math.abs(Math.sqrt(n) - guess) < 0.001){
		return guess;}

	    else{
		double bGuess = (n/original_guess + original_guess)/2;
		return helper(n, better_guess);}
	}

	public String toString(){
	    return "sqrt of " + TakSqRtOf + " should be " + sqrt(TakeSqRtOf);
    }

    public static void main (String args[]){
	System.out.println("sqrt of 0 should be 0, ?= " + sqrt(0));
	System.out.println("sqrt of 0 should be 1, ?= " + sqrt(1));
	System.out.println("sqrt of 25 should be 5, ?= " + sqrt(25));
	System.out.println("sqrt of 2 should be 1.414, ?= " + sqrt(2));
	System.out.println("sqrt of -25 should be IllegalArgumentException, ?= " + sqrt(5));
