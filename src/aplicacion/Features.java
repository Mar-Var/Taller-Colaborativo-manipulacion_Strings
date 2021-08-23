package aplicacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class defines the functionality of the application handling character strings in different ways.
 * @author Marcos Vargas Avella,Andres Ponguta Perez,Geraldine Parada Tobar,Jherson  Baez Paco
 */

public class Features {
	
	private final String DEFAULT_MESSAGE;
	
	/**
	* Class constructor
	* @param defaultMessaje The defaultMessaje parameter defines an unchangeable string from when the constructor
	  is instantiated
	**/
	
	public Features(String defaultMessaje) {
		 this.DEFAULT_MESSAGE=defaultMessaje;
	} 
	public String ConvertProperName() {
		
		
		return null;
	}
	
	public int searchWord(String word) {
		
		return 0;
	}
	
	public static String encrypt(String word) {
		
		return null;
	}
	public static String decrypt(String word) {
		
		return null;
	}
	
	public String addCharacters(char letter,int amount,char orientation) {
		
		return null;
	}
	
	public String deleteCharacter(char letter) {
		return null;
	}
	
	/**
	* Method that searches for the string with the intersection of characters between two strings (word and defaultMessaje),
	  without repeating.
	* @param word The word parameter defines a string that will be matched with the constructor's parameter string
	* @return String with the characters found both in the string "word" of the method parameter and
	  in the class constructor parameter string
	*/
	
	public String intersectStrings(String word) {
		String output="";
		String f="";
		
		for (int i = 0; i < word.length(); i++) {
			
			//Cycle to find common characters
			
			output+=(DEFAULT_MESSAGE.toLowerCase().indexOf(word.toLowerCase().charAt(i))>=0)?
					word.toLowerCase().charAt(i):"";
		}
		for (int j = 0; j < output.length(); j++) {
			
			//Cycle to remove repeating characters
			
			f+=(output.indexOf(output.charAt(j))==j)?output.charAt(j):"";
		}
		return f;
	}
	
	public String differentiateStrings(String word) {
		
		return null;
	}
	
	/**
	* This Method seeks to Delete to the Left or Right of the string the characters that exist in the input string,
	  until you find a character that does not exist in the input string
	* @param word The word parameter defines the string that will be matched to default Message
	* @param orientation The orientation parameter defines if the tour will start from the left or right
	* @return String without the characters found from the word string.
	*/
	
	public String deleteCharactersWithWord(String word,String orientation) {
		String reverseString="";
		String output="";
		boolean a=true;
		if (orientation=="Derecha") {
			for (int i = DEFAULT_MESSAGE.length()-1; i >=0; i--) { 
				// Cycle to reverse chain
				output+=DEFAULT_MESSAGE.charAt(i);
			}
			for (int i = 0; i < DEFAULT_MESSAGE.length(); i++) {
				// Cycle to remove common characters
				if (word.toLowerCase().indexOf(output.toLowerCase().charAt(i))>=0 && a) {
					reverseString+="";
				}else {
					a=false;
					reverseString+=output.charAt(i);
				}		
			}
			output="";
			for (int i = reverseString.length()-1; i >=0; i--) {
				// Cycle to delete re-invert string
				output+=reverseString.charAt(i);
			}
			
		}else if(orientation =="Izquierda") {
			
			for (int i = 0; i < DEFAULT_MESSAGE.length(); i++) {
				
				// Cycle to remove common characters
				
				if (word.toLowerCase().indexOf(DEFAULT_MESSAGE.toLowerCase().charAt(i))>=0 && a) {
					output+="";
				}else {
					a=false;
					output+=DEFAULT_MESSAGE.charAt(i);
				}	
			}
		}else {
			return "Error";
		}

		return DEFAULT_MESSAGE.length()>0?output:"Error:Imposible acceder";
	}
	
	/**
	* This method seeks to validate email addresses based on the RFC 3696 Standard
	* @param email The email parameter defines the string of an email address to validate
	* @return Logical value, which indicates whether the incoming email address is valid or not.
	*/
	
	public boolean validateEmail(String email) {
	    Pattern pat = Pattern.compile("^[A-Za-z0-9!#$%&'*+/=?^`_{|}~-]+(?:\\.[A-Za-z0-9!#$%&'_*+/=?^`{|}~-]+)"
	    							  + "*@(?:(?:[a-z0-9-]{2,})?\\.)+[a-z0-9]{2,}$");
		String[] parts = email.split("@");
		if (parts.length==2 && parts[0].length()<=64 && parts[1].length()<=255) {
			 Matcher mat = pat.matcher(email);
		     if (mat.find()) {
		         return true;                                                                            
		     } 
		}	
		return false;
	}
	
	public String getDEFAULT_MESSAGE() {
		return DEFAULT_MESSAGE;
	}
}
