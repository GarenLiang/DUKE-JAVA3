 

import edu.duke.*;

public class CaesarAss {
	// input = "I AM"; -> store to encrypted , type of StringBuider
	//Modify the encrypt method to be able to handle both 
	// uppercase and lowercase letters. 
	public String encrypt(String input, int key){
		StringBuilder encrypted = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabetL = "abcdefghijklmnopqrstuvwxyz";
		String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
		String shiftedAlphabetL = alphabetL.substring(key) + alphabetL.substring(0, key);
		// for each "I AM" char in StringBuilder 
		for(int i =0 ; i < encrypted.length();i++){
			//look at the i-th character of encryped (call it currChar)
			char currChar = encrypted.charAt(i);
			if(Character.isAlphabetic(currChar)){
				if(Character.isUpperCase(currChar)){
					//Find the index of currChar in the alphabet (call it idx)
					int idx = alphabet.indexOf(currChar);
					//If currChar is in the alphabet
					if(idx != -1){
						//Get the idx-th character of shiftedAlphabet (newChar)
						char newChar = shiftedAlphabet.charAt(idx);
				//		System.out.println("hi :i "+i+",newchar "+newChar);
						//Replace the i-th character of encrypted with newChar
						encrypted.setCharAt(i, newChar);
					}
				}
				// if currChar is lower case 
				else{
					//Find the index of currChar in the alphabet (call it idx)
					int idx = alphabetL.indexOf(currChar);
					//If currChar is in the alphabet
					if(idx != -1){
						//Get the idx-th character of shiftedAlphabet (newChar)
						char newChar = shiftedAlphabetL.charAt(idx);
					//	System.out.println("low :i "+i+",newchar1 "+newChar);
						//Replace the i-th character of encrypted with newChar
						encrypted.setCharAt(i, newChar);
					
				     }
		         }
		      }
	       } 
		return encrypted.toString();
	}
	
	public String encryptTwoKeys(String input, int key1, int key2){
		StringBuilder encrypted = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabetL = "abcdefghijklmnopqrstuvwxyz";
		String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
		String shiftedAlphabetL1 = alphabetL.substring(key1) + alphabetL.substring(0, key1);
		String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
		String shiftedAlphabetL2 = alphabetL.substring(key2) + alphabetL.substring(0, key2);
		for(int i =0 ; i < encrypted.length(); i++){
		// ch is odd number location (ex 1,3)=(i=0,2..)	key1, shiftedAlphabet1, sfhiftedAlpahbetL1
		if((i%2) == 0){
			char currChar = encrypted.charAt(i);
			if(Character.isAlphabetic(currChar)){
				if(Character.isUpperCase(currChar)){
					//Find the index of currChar in the alphabet (call it idx)
					int idx = alphabet.indexOf(currChar);
					//If currChar is in the alphabet
					if(idx != -1){
						//Get the idx-th character of shiftedAlphabet (newChar)
						char newChar = shiftedAlphabet1.charAt(idx);
				//		System.out.println("hi :i "+i+",newchar "+newChar);
						//Replace the i-th character of encrypted with newChar
						encrypted.setCharAt(i, newChar);
					}
				}
				// if currChar is lower case 
				else{
					//Find the index of currChar in the alphabet (call it idx)
					int idx = alphabetL.indexOf(currChar);
					//If currChar is in the alphabet
					if(idx != -1){
						//Get the idx-th character of shiftedAlphabet (newChar)
						char newChar = shiftedAlphabetL1.charAt(idx);
					//	System.out.println("low :i "+i+",newchar1 "+newChar);
						//Replace the i-th character of encrypted with newChar
						encrypted.setCharAt(i, newChar);
					
				     }
		         }
		      }
    	   }
    	// ch is even number location (ex 2,4..)=(i = 1,3,..) key2 shiftedAlphabet2 shiftedAlphabetL2
    	else{
    	 	char currChar = encrypted.charAt(i);
			if(Character.isAlphabetic(currChar)){
				if(Character.isUpperCase(currChar)){
					//Find the index of currChar in the alphabet (call it idx)
					int idx = alphabet.indexOf(currChar);
					//If currChar is in the alphabet
					if(idx != -1){
						//Get the idx-th character of shiftedAlphabet (newChar)
						char newChar = shiftedAlphabet2.charAt(idx);
				//		System.out.println("hi :i "+i+",newchar "+newChar);
						//Replace the i-th character of encrypted with newChar
						encrypted.setCharAt(i, newChar);
					}
				}
				// if currChar is lower case 
				else{
					//Find the index of currChar in the alphabet (call it idx)
					int idx = alphabetL.indexOf(currChar);
					//If currChar is in the alphabet
					if(idx != -1){
						//Get the idx-th character of shiftedAlphabet (newChar)
						char newChar = shiftedAlphabetL2.charAt(idx);
					//	System.out.println("low :i "+i+",newchar1 "+newChar);
						//Replace the i-th character of encrypted with newChar
						encrypted.setCharAt(i, newChar);
					
				     }
		         }
		      }
    	   }
		}
		return encrypted.toString();
	}
		//
		
	
	public void testCaesar(){
		//quiz: message5
		int key = 15;
		int key1 =21;
		int key2 =8;
		FileResource fr = new FileResource();
		String message = fr.asString();
//		for(int i = 0 ; i < message.length() ; i++){
//			char currC = message.charAt(i);
//			if(Character.isAlphabetic(currC)){
//				Character.toUpperCase(currC);
//			}
//		}
//		String messageR = message.toUpperCase();
//		System.out.println(messageR);
//		String encrypted = encrypt(messageR, key);
		System.out.println(message);
		String encrypted = encrypt(message, key);
		System.out.println("key is " + key + "\n" + encrypted);
		String decrypted = encrypt(encrypted, 26-key);
		System.out.println(decrypted);
		
		System.out.println(message);
		String encrypted1 = encryptTwoKeys(message, key1, key2);
		System.out.println("Two key encrypt : "+ encrypted1);
		String decrypted1 = encrypt(encrypted, 26-key);
		System.out.println(decrypted1);
		
	  }
	}
