import java.util.*;
public class Quiz2Redux{
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	String result = s;
	ArrayList<String>words = new ArrayList<String>();
	words.add("");
	help( words , "", result);
	Collections.sort(words);
	return words;
    }
  
    private static void help( ArrayList<String> words,String out, String in){
	/*	if (in.length() == 1){
		words.add(in);
		return;}
	*/
	//base case
	if (in.length() == 0){
	    words.add(""+ out);
	    return;}
	//	if (in.length() == 0){
	//   return;}

	        if (in.length() > 0) {
		    
		    //words.add(out + in.charAt(0)); //this added the middle of the tree
		    //System.out.println("current partial added: ");
		    //for (String str : words){
		    //System.out.println(str);}
		
		    help(words, out + in.charAt(0), in.substring(1));
		}
		    //removeCharAt(out,out.length()-1); 
		    help(words, out,in.substring(1));
        }
    

    /*
	for (int j = 0; j < in.length() ; j++){
	    
	    out = out + in.charAt(j);
	    
	    //Looking at Each element added
	    //System.out.println(out);
	    
	    words.add(out);
	    System.out.println(out);
	    //for (String str : words){
	    //System.out.println(str);}
	    help(words, in.substring(1), out + );//if add
	
	    //removeCharAt(out, out.length() -1);
	    //System.out.println(in.substring(1));
	help(words, in.substring(1), out); //if not add
	
	}
    */
	    
    /*
public static String removeCharAt(String s, int index) {
    return s.substring(0, index) + s.substring(index + 1);
}
    */

	
    /*			      
			  
  for (int i = 0; i < result.length(); i++) {
  // Record size as the list will change
  int ArrayLength = words.size();
  for (int j = 0; j < ArrayLength; j++) {
  words.add(s.charAt(i) + words.get(j));
  }
  words.add(Character.toString(s.charAt(i)));
  }
  METHOD TO BE WRITTEN BY YOU.*/
	
    

public static void main (String[] args){
    System.out.println(combinations("abc"));
    System.out.println(combinations("abcdef"));
    System.out.println(combinations("a"));
}
}
