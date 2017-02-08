mpublic class Recursion{
    
 public static String name(){
     return "Chen,Jenny";}
    
    public static double sqrt(double n){
	if (n < 0) { //exception
	    throw new IllegalArgumentException;}
		("Cannot Take SquareRoote of negative.");
	else if (n == 0 || n == 1) //base cases}
	    return n;}
    else {
	return helper();}
}
	
    
	public float helper (double n, double guess){
	    double original_guess = guess
		double better_guess = (n/original_guess + original_guess)/2;
	    if (better_guess
	    return helper(n, better_guess);
    }
    
}
