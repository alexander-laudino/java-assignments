package lab1;

import lab1.exceptions.ModKeyOutofRange;
import lab1.exceptions.ShiftKeyOutofRange;

/**
 * The Cipher class is used to encrypt and decrypt a String object 
 * 
 * CSC-236-03 Lab 1 
 * @author Alexander Laudino
 *
 */
public class Cipher {

	// ---------- VARIABLES ----------

	private int shiftKey; // Initial character shift

	private int modKey; // Variable key shift, 0 <= modKey < shiftKey

	// ---------- CONSTRUCTORS ----------

	public Cipher() {
		super();
	}

	/**
	 * This constructor creates a Cipher object with the given keys
	 * 
	 * @param shiftKey Int value 1 <= shiftKey <= 10
	 * @param modKey   Int value 0 <= modKey < shiftKey
	 * @throws ShiftKeyOutofRange Exception error if shift key int value is greater
	 *                            than 10 or less than 1
	 * @throws ModKeyOutofRange   Exception error if mod key int value is less than
	 *                            0 or greater than shiftKey value
	 */
	public Cipher(int shiftKey, int modKey) throws ShiftKeyOutofRange, ModKeyOutofRange {
		setKeys(shiftKey, modKey);
	}

	// ---------- METHODS ----------

	/**
	 * The setKey method checks to make sure the keys are in range, if valid the key
	 * attributes are set, if not valid, throws Out of Range Exception
	 * 
	 * @param shiftKey Int value 1 <= shiftKey <= 10
	 * @param modKey   Int value 0 <= modKey < shiftKey
	 * @throws ShiftKeyOutofRange Exception error if shift key int value is greater
	 *                            than 10 or less than 1
	 * @throws ModKeyOutofRange   Exception error if mod key int value is less than
	 *                            0 or greater than shiftKey value
	 */
	private void setKeys(int shiftKey, int modKey) throws ShiftKeyOutofRange, ModKeyOutofRange {
		if (shiftKey < 1 || shiftKey > 10)
			throw new ShiftKeyOutofRange(shiftKey);
		else if (modKey < 0 || modKey >= shiftKey)
			throw new ModKeyOutofRange(modKey, shiftKey);
		else {
			this.shiftKey = shiftKey;
			this.modKey = modKey;
		}
	}

	/**
	 * The encrypt method takes a plaintext String object, uses the keys to encrypt
	 * each character and returns a ciphertext String object
	 * 
	 * @param word Plaintext String object
	 * @return Ciphertext String object
	 */
	public String encrypt(String word) {
		int currentShift = shiftKey;
		int totalShift = shiftKey + modKey;
		String newWord = "";
		// Loop through characters
		for (int i = 0; i < word.length(); i++) {
			char charAt = word.charAt(i);
			char newChar = ' ';
			if (!Character.isLetter(charAt)) // Maintain special characters
				newChar = charAt;
			else {
				if (currentShift > totalShift) // Reset shift
					currentShift = shiftKey;
				newChar = encryptChar(currentShift, charAt);
				currentShift++;
			}
			newWord = newWord + newChar;
		}
		return newWord;
	}

	/**
	 * The encryptChar method takes the current shift and character and returns the
	 * shifted character
	 * 
	 * @param currentShift Int value of current shift
	 * @param charAt       Char value of current character in string
	 * @return Shifted character
	 */
	private char encryptChar(int currentShift, char charAt) {
		char newChar;
		newChar = (char) ((int) charAt + currentShift);
		if (charAt <= 'Z') {
			if (newChar > 'Z')
				newChar = (char) ((int) newChar - 26);
		} else if (newChar > 'z') {
			newChar = (char) ((int) newChar - 26);
		}
		return newChar;
	}

	/**
	 * The decrypt method takes a ciphertext String object, uses the keys to decrypt
	 * each character and returns a plaintext String object
	 * 
	 * @param word Ciphertext String object
	 * @return Plaintext String object
	 */
	public String decrypt(String word) {
		int currentShift = shiftKey;
		int totalShift = shiftKey + modKey;
		String newWord = "";
		// Loop through characters
		for (int i = 0; i < word.length(); i++) {
			char charAt = word.charAt(i);
			char newChar = ' ';
			if (!Character.isLetter(charAt)) // Maintain special characters
				newChar = charAt;
			else {
				if (currentShift > totalShift) // Reset shift
					currentShift = shiftKey;
				newChar = decryptChar(currentShift, charAt);
				currentShift++;
			}
			newWord = newWord + newChar;
		}
		return newWord;
	}

	/**
	 * The decryptChar method takes the current shift and character and returns the
	 * unshifted character
	 * 
	 * @param currentShift Int value of current shift
	 * @param charAt       Char value of current character in string
	 * @return Unshifted character
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