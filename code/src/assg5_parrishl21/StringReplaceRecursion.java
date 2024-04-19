/**
 * @author Link Parrish
 * Contains 2 recursive methods, one that replaces the first instance of a character.
 * The other replaces all instances of a character.
 * The main method tests the recursive replace methods
 */
package assg5_parrishl21;

public class StringReplaceRecursion {

	public static void main(String[] args) {
		
		System.out.println("Testing replace:");
		System.out.println(replace("testing", 't', 'x'));
		System.out.println(replace("ztesting", 't', 'x'));
		System.out.println(replace("testing", 'g', 'x'));
		System.out.println(replace("testing", 'z', 'x'));
		System.out.println();
		
		System.out.println("Testing replaceAll:");
		System.out.println(replaceAll("testing", 't', 'x'));
		System.out.println(replaceAll("ztesting", 't', 'x'));
		System.out.println(replaceAll("gtesting", 'g', 'x'));
		System.out.println(replaceAll("gtestging", 'g', 'x'));
		System.out.println(replaceAll("testing", 'z', 'x'));

	}
	
	/**
	 * replaces the first instance of a character in a string with another character
	 * @param str the string to replace the character in
	 * @param oldChar the character to replace
	 * @param newChar the character to replace with
	 * @return the string with the replaced character, if oldChar does not exist in str then returns the original string is returned
	 */
	public static String replace(String str, char oldChar, char newChar) {
			
		if (str.length() == 0)
			return str;
		
		if (str.charAt(0) == oldChar)
			return newChar + str.substring(1);
		
		return str.charAt(0) + replace(str.substring(1), oldChar, newChar);
	}
	
	/**
	 * replaces all instances of a character in a string with another character
	 * @param str the string to replace the character in
	 * @param oldChar the character to replace
	 * @param newChar the character to replace with
	 * @return the string with the replaced character(s), if oldChar does not exist in str then returns the original string is returned
	 */
	public static String replaceAll(String str, char oldChar, char newChar) {
		
		if (str.length() == 0)
			return str;
		
		if (str.charAt(0) == oldChar)
			return newChar + replaceAll(str.substring(1), oldChar, newChar);
			
		return str.charAt(0) + replaceAll(str.substring(1), oldChar, newChar);
	}
}
