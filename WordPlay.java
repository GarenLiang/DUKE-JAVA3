package duke3;
import edu.duke.*;
//transform words from a file into another form, 
//such as replacing vowels with an asterix
public class WordPlay {
	//low performance -> later modification needed
	/*
	 * one Char parameter named ch. This method returns true 
	 * if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or 
	 * the uppercase versions) and false otherwise
	 */
	
	public boolean isVowel(char ch){
	//	char[] trueCh = new char[]{'a','e','i','o','u','A','E','I','O','U'};
		String strVowel ="aeiouAEIOU";
		boolean checkVowel = false;
			if(strVowel.indexOf(ch) != -1){
//				System.out.println(ch);
//				System.out.println(strVowel);
		      checkVowel = true;
			}
			else {
		      checkVowel = false;
		    }
//			System.out.println(checkVowel);
			return checkVowel;
	    }
		
	
	
	/*
	 * two parameters, a String named phrase and a Char named ch.
	 * This method should return a String that is the string phrase 
	 * with all the vowels (uppercase or lowercase) replaced by ch.
     * For example, the call replaceVowels(“Hello World”, ‘*’) returns the string
     *  “H*ll* W*rld”. Be sure to call the method isVowel that
     *  you wrote and also test this method.
	 */
	public String replaceVowels(String phrase, char ch){
		StringBuilder sbPhase = new StringBuilder(phrase);
		
		for (int i=0 ; i < sbPhase.length();i++){
			char currch = sbPhase.charAt(i); 
//			System.out.println("*******");
//			System.out.println(currch+" number : " + i);
		  if(isVowel(currch)){
	 	//  int idx = phrase.indexOf(currch);   //because indexOf is first appear char's position.
		 //error 2nd appear vowel is submitted 1st vowel so 2nd vowel not changed.
//			  System.out.println("i "+i);
			  sbPhase.setCharAt(i, ch);
		  }	
	    }
		return sbPhase.toString();
	}
	/*
	 *  two parameters, a String named phrase and a character named ch.
	 *   This method should return a String that is the string phrase but 
	 *   with the Char ch (upper- or lowercase) replaced by
     *   ‘*’ if it is in an odd number location in the string 
     *   (first character has index 0, third character has index 2, etc.), or
     *  ‘+’ if it is in an even number location in the string 
     *  (second character has index 1, fourth character has index 3, etc.).
	 */

	public String emphasize(String phrase, char ch){
		
        StringBuilder sbPhase = new StringBuilder(phrase);
        
		// for each char in given string from 0 to string size
		for (int i=0 ; i < sbPhase.length();i++){
			char currCh = sbPhase.charAt(i); 
			char chLow = Character.toLowerCase(currCh);
		    if(chLow == ch){
		    	// ch is odd number location(ex 1,3..)=(i = 0,2,..) change to *
		    	if((i%2) == 0){
		    		sbPhase.setCharAt(i, '*');
		    	}
		    	// ch is even number location (ex 2,4..)=(i = 1,3,..) change to +
		    	else{
		    		sbPhase.setCharAt(i, '+');
		    	}
		    }
		//	  System.out.println("i "+i);
	     }
		return sbPhase.toString();
	}
}
