import java.util.*;
public class Quiz2Redux{
    private result = "";
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	result = s;
	ArrayList<String>words = new ArrayList<String>();
	help( words , /*fill this in with more */);
	Collections.sort(words);
	return words;
    }
  
    private static void help( ArrayList<String> words, 
			      /*fill this in with more arguments*/ ){

	for (int i = 0; i < result.length(); i++) {
	    // Record size as the list will change
	    int ArrayLength = words.size();
	    for (int j = 0; j < ArrayLength; j++) {
	        words.add(s.charAt(i) + words.get(j));
	    }
	    words.add(Character.toString(s.charAt(i)));
	}
	/*METHOD TO BE WRITTEN BY YOU.*/ 
    }
}
