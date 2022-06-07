package lab1.drivers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import lab1.Breaker;

/**
 * The BreakerDriver class is used to control the Breaker class
 * 
 * CSC-236-03 Lab 1
 * 
 * @author Alexander Laudino
 */
public class BreakerDriver {

	/**
	 * The breakCipherText method prompts for the name of the file with ciphertext
	 * to be broken and the name of the file to hold the plaintext
	 * 
	 * The method reads each line of the file and concatenates the input into one
	 * String, attempts to break the ciphertext, and write the output to a file; if
	 * the code is not broken by any key/mod pair, a message is printed and nothing
	 * is written to the file
	 * 
	 * @param input Scanner to read input from user
	 * @throws FileNotFoundException If user entered files are not found
	 */
	public static void breakCipherText(Scanner input) throws FileNotFoundException {
		Breaker breaker = new Breaker(input);
		System.out.print("Enter file name of ciphertext to be broken: ");
		String cipherTextFile = input.next();
		System.out.print("Enter file name to write broken ciphertext to: ");
		String brokenCipherFile = input.next();
		Scanner breakerInput = new Scanner(new File(cipherTextFile));
		String concat = "";
		while (breakerInput.hasNext()) {
			String line = breakerInput.nextLine();
			concat = concat + "\n" + line;
		}
		String broken = breaker.breakCipher(concat, 10);
		if (broken == null)
			System.out.println("Unable to break ciphertext");
		else {
			PrintWriter brokenWriter = new PrintWriter(new File(brokenCipherFile));
			brokenWriter.write(broken);
			brokenWriter.flush();
		}
	}

	@Deprecated
	/**
	 * Used to test methods in breaker class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			CipherDriver.encryptPlainText(input);
			CipherDriver.decryptCipherText(input);
			breakCipherText(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}