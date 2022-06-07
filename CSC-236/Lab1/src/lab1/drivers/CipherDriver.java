package lab1.drivers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import lab1.Cipher;
import lab1.exceptions.ModKeyOutofRange;
import lab1.exceptions.ShiftKeyOutofRange;

/**
 * The CipherDriver class is used to control the Cipher class
 * 
 * CSC-236-03 Lab 1
 * 
 * @author Alexander Laudino
 */
public class CipherDriver {

	/**
	 * The encryptPlainText method prompts for the name of the file with plaintext
	 * Strings and the name of the file to hold the ciphertext, prompts for the
	 * keys, reads each line of the file, encrypts it, and writes the ciphertext to
	 * the output file
	 * 
	 * @param keyboard
	 * @throws FileNotFoundException
	 */
	public static void encryptPlainText(Scanner keyboard) throws FileNotFoundException {
		System.out.print("Enter plaintext filename to read from: ");
		String plainTextFile = keyboard.next();
		System.out.print("Enter ciphertext filename to write to: ");
		String cipherTextFile = keyboard.next();
		Cipher encrypt = createCipher(keyboard);
		Scanner encryptInput = new Scanner(new File(plainTextFile));
		PrintWriter encryptWriter = new PrintWriter(new File(cipherTextFile));
		while (encryptInput.hasNext()) {
			String line = encryptInput.nextLine();
			String cipherLine = encrypt.encrypt(line);
			encryptWriter.write(cipherLine + "\n");
			encryptWriter.flush();
		}
	}

	/**
	 * The decryptCipherText method prompts the user for the name of the file with
	 * ciphertext Strings and the name of the file to hold the plaintext, prompts
	 * for the keys, then reads each line of the file, decrypts it, and writes the
	 * plaintext to the output file
	 * 
	 * @param keyboard Scanner for user input
	 * @throws FileNotFoundException If file user input files not found
	 */
	public static void decryptCipherText(Scanner keyboard) throws FileNotFoundException {
		System.out.print("Enter ciphertext filename to decrypt: ");
		String cipherTextFile = keyboard.next();
		System.out.print("Enter filename for decrypted plaintext: ");
		String decryptedTextFile = keyboard.next();
		Cipher decrypt = createCipher(keyboard);
		Scanner decryptInput = new Scanner(new File(cipherTextFile));
		PrintWriter decryptWriter = new PrintWriter(new File(decryptedTextFile));
		while (decryptInput.hasNext()) {
			String cipherLine = decryptInput.nextLine();
			String line = decrypt.decrypt(cipherLine);
			decryptWriter.write(line + "\n");
			decryptWriter.flush();
		}
	}

	/**
	 * The createCipher method prompts the user for the keys and creates a new
	 * Cipher object
	 * 
	 * @param keyboard Scanner for user input
	 * @return Cipher object
	 */
	private static Cipher createCipher(Scanner keyboard) {
		boolean continueInput = true;
		Cipher cipher = null;
		while (continueInput) {
			try {
				System.out.print("Enter shift key value =< 10: ");
				int shiftKey = keyboard.nextInt();
				System.out.print("Enter mod value < shift key: ");
				int modKey = keyboard.nextInt();
				cipher = new Cipher(shiftKey, modKey);
				continueInput = false; // Break out of loop
			} catch (ShiftKeyOutofRange e) {
				System.out.println(e.getMessage());
				continue;
			} catch (ModKeyOutofRange e) {
				System.out.println(e.getMessage());
				continue;
			}
		}
		return cipher;
	}

	@SuppressWarnings("unused")
	@Deprecated
	/**
	 * Used for testing different input for file
	 * 
	 * @param keyboard
	 * @param plainTextFileName
	 * @throws FileNotFoundException
	 */
	private static void createPlainTextFile(Scanner keyboard, String plainTextFileName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(new File(plainTextFileName));
		boolean continueInput = true;
		System.out.println("Type exit to quit");
		keyboard.nextLine();
		do {
			System.out.print(":");
			String input = keyboard.nextLine();
			if (input.toLowerCase().equals("exit"))
				continueInput = false;
			else
				writer.write(input + "\n");
			writer.flush();
		} while (continueInput);
	}

	@Deprecated
	/**
	 * Used to test CipherDriver class
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Scanner keyboard = new Scanner(System.in);
		encryptPlainText(keyboard);
		decryptCipherText(keyboard);
	}

}