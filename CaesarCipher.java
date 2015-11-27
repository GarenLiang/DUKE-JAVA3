# DUKE-JAVA3
import edu.duke.*;
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    public String encrypt(String input,int key){
        //Make a StringBulider with message (encryted)
        StringBuilder encrypted =new StringBuilder(input);
        //write down the alphbet
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        //compute the shilfted alphabet
        String shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        //count  from 0 to <length of enctypted (call it i)
        for(int i=0;i<encrypted.length();i++){
            //look at the ith character of encrypted (call it currChar)
            char currChar=encrypted.charAt(i);
            //Find the index of currChar in the alphabet
            int idx=alphabet.indexOf(currChar);
            //if currChar is in the alphabet 
            if(idx!=-1){
                //Get the idxth character of shiftedAlphabet(newChar)
                char newChar=shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with the newChar
                encrypted.setCharAt(i,newChar);
            }
            //Otherwise :do nothing 
        }
        //Your answer is the String inside of encrypted 
        return encrypted.toString();
    }
    
    public void testCaesar(){
        int key=8;
        FileResource fr=new FileResource();
        String message =fr.asString();
        String encrypted=encrypt(message,key);
        System.out.println(encrypted);
        String decrypted=encrypt(encrypted,26-key);
        System.out.println(decrypted);
    }
        
        

}
