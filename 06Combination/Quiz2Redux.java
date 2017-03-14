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
	help( words , result, "" , 0);
	Collections.sort(words);
	return words;
    }
  
    private static void help( ArrayList<String> words,String in, String out, int index){
	for (int i = index; i < in.length(); i++){
	    out += in.charAt(i);
	    words.add(out);
	    System.out.println(words.get());
	    help(words, in, out, i+1);
	    //out.remove(out.length() - 1);
	    removeCharAt(out, out.length() - 1);
	}
    }

    public static String removeCharAt(String s, int pos) {
      return s.substring(0, pos) + s.substring(pos + 1);
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
	combinations("abc");
    }
}
