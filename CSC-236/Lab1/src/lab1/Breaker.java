package lab1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Breaker class is used to break an Enhanced Caesar Cipher 
 * 
 * CSC-236-03 Lab 1
 * @author Alexander Laudino
 *
 */
public class Breaker {

	// ---------- VARIABLES ----------

	private Dictionary dictionary; // To store list of words to test against

	// ---------- CONSTRUCTORS ----------

	public Breaker() {
		super();
	}

	/**
	 * This constructor passes the Scanner to the Dictionary class to initialize the
	 * Dictionary object that will contain the list of words to be checked against
	 * 
	 * @param input Scanner for keyboard input of dictionary file name
	 * @throws FileNotFoundException If dictionary file is not found.
	 */
	public Breaker(Scanner input) throws FileNotFoundException {
		this.dictionary = new Dictionary(input);
		System.out.println("Dictionary created!");
	}

	// ---------- METHODS ----------

	/**
	 * The breakCipher method is used to break an Enhanced Caesar Cipher ciphertext
	 * String
	 * 
	 * @param cipher String of ciphertext
	 * @param maxKey Int vale of max shift key to try
	 * @return Plaintext String if broken, null if none of the key pairs result in a
	 *         message with all English words
	 */
	public String breakCipher(String cipher, int maxKey) {
		String plainText = "";
		boolean isAllWords = false;
		// Loop through all combinations of keys
		// Outer loop - shift key
		for (int shiftKey = 1; shiftKey <= maxKey; shiftKey++) {
			// Inner loop - mod key
			String broken = "";
			boolean modKeyB = false;
			for (int modKey = 0; modKey < maxKey; modKey++) {
				int currentShift = shiftKey;
				int maxShift = shiftKey + modKey;
				broken = decipherString(cipher, shiftKey, currentShift, maxShift);
				broken = broken.stripLeading();
				String[] words = broken.split("\\s+");
				isAllWords = isAllWords(words);
				if (isAllWords) {
					modKeyB = true;
					plainText = broken;
					break;
				} else
					plainText = null;
			}
			if (modKeyB) {
				break;
			}

		}
		return plainText;
	}

	/**
	 * The isAllWords method validates if all the words in a given String array are
	 * valid English words
	 * 
	 * @param words String of words
	 * @return True if all words are valid, false otherwise
	 */
	private boolean isAllWords(String[] words) {
		boolean allWords = false;
		for (String word : words) {
			word = word.replaceAll("\\p{Punct}", "");
			if (!dictionary.isWord(word)) {
				allWords = false;
				break;
			} else
				allWords = true;
		}
		return allWords;
	}

	/**
	 * The decipherString method takes a ciphertext String and tries to decipher it
	 * 
	 * @param cipher       String of ciphertext
	 * @param shiftKey     Int value of current shiftKey testing
	 * @param currentShift Int value of current total shift
	 * @param maxShift     Int value of maximum total shift
	 * @return Potential deciphered String
	 */
	private String decipherString(String cipher, int shiftKey, int currentShift, int maxShift) {
		String textLine = "";
		for (int i = 0; i < cipher.length(); i++) {
			char charAt = cipher.charAt(i);
			char newChar = ' ';
			if (charAt == '.' || charAt == '\n')
				currentShift = shiftKey;
			if (!Character.isLetter(charAt))
				newChar = charAt;
			else {
				if (currentShift > maxShift)
					currentShift = shiftKey;
				newChar = decryptChar(currentShift, charAt);
				currentShift++;
			}
			textLine = textLine + newChar;
		}
		return textLine;
	}

	/**
	 * The decryptChar method takes the current shift and current character and
	 * attempts to decrypt it
	 * 
	 * @param currentShift Int value of current shift
	 * @param charAt       Char of current character to be decrypted
	 * @return Potential decrypted character
	 */
	private char decryptChar(int currentShift, char charAt) {
		char newChar;
		newChar = (char) ((int) charAt - currentShift);
		if (charAt <= 'Z') {
			if (newChar < 'A')
				newChar = (char) ((int) newChar + 26);
		} else if (newChar < 'a') {
			newChar = (char) ((int) newChar + 26);
		}
		return newChar;
	}

}
