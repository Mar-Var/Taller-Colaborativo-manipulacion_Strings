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
	
	/**
	* Method that returns the string of the constructor parameter "defaultMessaje" as proper name
	* @return String converted to proper name
	**/
	
	public String ConvertProperName() {
		String convertedString="";
		
		for (int i = 0; i < DEFAULT_MESSAGE.length(); i++) {
			
			convertedString+=(i==0 || (DEFAULT_MESSAGE.charAt(i-1)==' ' && DEFAULT_MESSAGE.charAt(i+1)!=' ') )
					?Character.toUpperCase(DEFAULT_MESSAGE.charAt(i)):Character.toLowerCase(DEFAULT_MESSAGE.charAt(i));
		}
		
		return DEFAULT_MESSAGE.length()>0?convertedString:"Error:Imposible acceder";
	}
	
	/**
	* This method looks for the times that a string is skipped in another string
	* @param word The word parameter defines the string to search for in the string entered as
	  the class constructor parameter
	* @return The number of times the string is repeated in the string entered as the class constructor parameter
	*/
	
	public int searchTimeWord(String word) {
		int counter=0;

		for (int i = 0; i < DEFAULT_MESSAGE.length(); i++) {
			counter+=(DEFAULT_MESSAGE.toLowerCase().indexOf(word.toLowerCase(), i)>=0 
					 && DEFAULT_MESSAGE.toLowerCase().indexOf(word.toLowerCase(), i)==i)?1:0;
		}
		return counter;
	}
	
	public static String encrypt(String word) {
		
		return null;
	}
	public static String decrypt(String word) {
		
		return null;
	}
	
	/**
	* Method that seeks to generate a string concatenated with the character n times left or right
	* @param letter The letter parameter defines the character to be added to the parameter string of the
	  class constructor
	* @param amount The amount parameter defines the number of times the letter character will be repeated
	* @param orientation The orientation parameter defines if the data will be entered from the left
	  or to the right of the class constructor parameter string
	* @return The string with the character "letter" repeated "amount" times on the "orientation" side
	*/
	
	public String addCharacters(char letter,int amount,String orientation) {
		String add="";
		for (int i = 0; i < amount; i++) {
			add+=letter;
		}
		if(orientation=="Izquierda") {
			return add+DEFAULT_MESSAGE;
		}else if(orientation=="Derecha") {
			return DEFAULT_MESSAGE+add;
		}else {
			return "Error";
		}
	}
	
	/**
	* This method removes the letter character from the entire string set by default in the class constructor
	* @param letter The letter parameter defines the character to be removed from the parameter string
	  from the class constructor
	* @return The string without the letter character anywhere
	*/
	
	public String deleteCharacter(char letter) {
		
		String output="";
		for (int i = 0; i < DEFAULT_MESSAGE.length(); i++) {
			
			//Loop to remove a character from a string
			
			output+=(DEFAULT_MESSAGE.toLowerCase().charAt(i)==Character.toLowerCase(letter))?
					"":DEFAULT_MESSAGE.charAt(i);
		}
		return DEFAULT_MESSAGE.length()>0?output:"Error:Imposible acceder";
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
	
	/**
	* This method faces two strings in order to show at the end which characters do not belong to the intersection of
	  themselves
	* @param word The word parameter defines a string that will be matched to the parent string of the constructor of
	  class
	* @return A string with all the characters that do not have "word" or defaultMessage in common.
	*/
	
	public String differentiateStrings(String word) {
		String output="";
		for (int i = 0; i < DEFAULT_MESSAGE.length(); i++) {
			output+=(word.toLowerCase().indexOf(DEFAULT_MESSAGE.toLowerCase().charAt(i))>=0)?
					"":DEFAULT_MESSAGE.charAt(i);			
		}
		return DEFAULT_MESSAGE.length()>0?word:output;
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
