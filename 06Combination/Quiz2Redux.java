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
	help( words , result);
	Collections.sort(words);
	return words;
    }
  
    private static void help( ArrayList<String> words,String in){
	/*	if (in.length() == 1){
		words.add(in);
		return;}
	*/
	if (in.length() == 0){
	    return;}
	String out = "" + in.charAt(0);
	words.add(out);
	for (int j = 1; j < in.length(); j++){
	    /*System.out.println("added");
	      for (String str : words){
	      System.out.println( str);}
	    */
	    System.out.println(j);
	    out = out + in.charAt(j);
	    words.add(out);

	    help(words, in.substring(1));
	    for (int i = j; i < 0; i++){
	    removeCharAt(out, out.length() - 1);
	    }
	}
	    
	for (String str : words){
	    System.out.println( str);}
    
}

public static String removeCharAt(String s, int index) {
    return s.substring(0, index) + s.substring(index + 1);
}

	
			      
			   
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
}
}
